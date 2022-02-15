package servlet;

import dto.MyRequest;
import dto.MyResponse;
/**
 * @author hdgaadd
 * Created on 2022/02/15
 */
public abstract class MyServlet {

    public abstract void doGet(MyRequest request, MyResponse response);

    public abstract void doPost(MyRequest request, MyResponse response);

    public  void service(MyRequest request, MyResponse response){
        String method = request.getMethod().toUpperCase();
        if ("POST".equals(method)){
            doPost(request, response);
        }else if ("GET".equals(method)){
            doGet(request, response);
        }
    }

}
