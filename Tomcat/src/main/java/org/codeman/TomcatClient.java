package org.codeman;

import org.codeman.config.CustomHandler;
import org.codeman.servlet.Servlet;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.io.FileInputStream;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author hdgaadd
 * Created on 2022/04/27
 */
public class TomcatClient {  // access url:   http://localhost:8080/firstServlet.do   http://localhost:8080/secondServlet.do

    private int port = 8080;

    private ServerSocket serverSocket;

    private Properties webxml = new Properties();

    public final static Map<String, Servlet> servletMapping = new HashMap<>();

    public static void main(String[] args) {
        new TomcatClient().start();
    }

    private void start() {
        init();
        // boss线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // work线程组
        EventLoopGroup workGroup = new NioEventLoopGroup();
        // nio服务端对象
        ServerBootstrap server = new ServerBootstrap();

        try {
            // 配置服务器
            server.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer() {
                        // NIO采用责任链模式，级别低的逻辑先触发，后是级别高的
                        @Override
                        protected void initChannel(Channel client) throws Exception {
                            client.pipeline().addLast(new HttpResponseEncoder()); // HttpResponseEncoder而不是HttpResponseDecoder
                            client.pipeline().addLast(new HttpRequestDecoder());
                            client.pipeline().addLast(new CustomHandler()); // 自定义触发逻辑
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 配置工作线程保存长连接
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // 启动服务器
            ChannelFuture channelFuture = server.bind(this.port).sync(); // [sɪŋk]同步，[baɪnd]捆绑

            System.out.println("___________                           __    .__                                    .__                                                       __   \n" +
                    "\\__    ___/___   _____   ____ _____ _/  |_  |__| ______ _______ __ __  ____   ____ |__| ____    ____     ____   ____   ______   ____________/  |_ \n" +
                    "  |    | /  _ \\ /     \\_/ ___\\\\__  \\\\   __\\ |  |/  ___/ \\_  __ \\  |  \\/    \\ /    \\|  |/    \\  / ___\\   /  _ \\ /    \\  \\____ \\ /  _ \\_  __ \\   __\\\n" +
                    "  |    |(  <_> )  Y Y  \\  \\___ / __ \\|  |   |  |\\___ \\   |  | \\/  |  /   |  \\   |  \\  |   |  \\/ /_/  > (  <_> )   |  \\ |  |_> >  <_> )  | \\/|  |  \n" +
                    "  |____| \\____/|__|_|  /\\___  >____  /__|   |__/____  >  |__|  |____/|___|  /___|  /__|___|  /\\___  /   \\____/|___|  / |   __/ \\____/|__|   |__|  \n" +
                    "                     \\/     \\/     \\/               \\/                    \\/     \\/        \\//_____/               \\/  |__|                       " + this.port);

            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully(); // [ˈɡreɪsfəli]优雅地关闭
            workGroup.shutdownGracefully();
        }
    }

    /**
     * 加载web.properties，初始化相应的bean
     */
    private void init() {
        String path = this.getClass().getResource("/").getPath();
        try {
            FileInputStream fileInputStream = new FileInputStream(path + "web.properties");
            // 加载
            webxml.load(fileInputStream);
            for (Object key : webxml.keySet()) {
                String keyString = key.toString();
                if (keyString.endsWith(".url")) {
                    String url = webxml.getProperty(keyString); // secondServlet.do

                    // 把"./url"以及后面的字符串，都替换为空，得到如：servlet.two
                    String prefix = keyString.replaceAll("\\.url$", ""); // [ˈpriːfɪks]
                    String methodName = webxml.getProperty(prefix + ".className"); // com.codeman.servlet.SecondServlet

                    Servlet obj = (Servlet) Class.forName(methodName).newInstance();
                    servletMapping.put(url, obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // [treɪs]追踪
        }
    }
}
