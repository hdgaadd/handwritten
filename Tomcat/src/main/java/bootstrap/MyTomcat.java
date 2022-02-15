package bootstrap;

import dto.MyRequest;
import dto.MyResponse;
import mapping.ServletMapping;
import mapping.ServletMappingConfig;
import servlet.MyServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author hdgaadd
 * Created on 2022/02/15
 */
public class MyTomcat {

    private int port;

    private Map<String /*url*/, String /*clazz*/> urlServletMap =  new HashMap<String, String>();//保存url、类引用

    public MyTomcat(int port) {
        this.port = port;
    }

    public void start(){
        // 初始化url和servlet的mapping关系
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat is start...");
            int i=0;
            while (i<2){
                i++;
                Socket socket = serverSocket.accept();                //////////////
                InputStream inputStream = socket.getInputStream();//获取http协议的输入流
                OutputStream outputStream = socket.getOutputStream();
                // 构造request  response
                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                // 请求分发
                doDispatch(myRequest, myResponse);

                socket.close();
                System.out.println("socket.close()");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                    System.out.println("serverSocket.close()");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    private void initServletMapping(){
        List<ServletMapping> servletMappingList = ServletMappingConfig.servletMappingList;
        for (ServletMapping mapping:
             servletMappingList) {
            urlServletMap.put(mapping.getUrl(), mapping.getClazz());
        }
    }

    private void doDispatch(MyRequest request, MyResponse response) throws IOException{
        System.out.println("-------doDispa666tch: request: "+request);
        String url = request.getUrl();
        String clazz = urlServletMap.get(url);           //类引用
        if (url  ==  null  || url.length() == 0 ||  "/favicon.ico".equals(url)){
            response.write("404 : url is not exist");
            return;
        }
        if (clazz  ==  null  || clazz.length() == 0){
            response.write("404 : clazz is not exist");
            return;
        }
        // 反射
        try {
            Class<MyServlet> myServletClazz = (Class<MyServlet>)Class.forName(clazz);
            MyServlet myServlet = myServletClazz.newInstance();
            myServlet.service(request, response);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
