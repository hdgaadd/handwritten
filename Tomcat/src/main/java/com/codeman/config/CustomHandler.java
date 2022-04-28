package com.codeman.config;

import com.codeman.http.Request;
import com.codeman.http.Response;
import com.codeman.TomcatClient;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

/**
 * @author hdgaadd
 * Created on 2022/04/29
 *
 * @Description：自定义用户请求的触发逻辑
 */
public class CustomHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest req = (HttpRequest) msg;
            Request request = new Request(ctx, req);
            Response response = new Response(ctx, req);

            String url = request.getUrl();
            if (TomcatClient.servletMapping.containsKey(url)) {
                TomcatClient.servletMapping.get(url).service(request, response);
            } else {
                response.write("404");
            }
        }
    }
}