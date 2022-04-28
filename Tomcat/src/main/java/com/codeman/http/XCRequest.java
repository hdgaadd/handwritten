package com.codeman.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author hdgaadd
 * Created on 2022/04/27
 */
public class XCRequest {

    private ChannelHandlerContext ctx;

    private HttpRequest req;

    public XCRequest(ChannelHandlerContext ctx, HttpRequest req) {
        this.ctx = ctx;
        this.req = req;
    }

    /**
     * 获取HttpRequest解码后的参数
     *
     * @return
     */
    public Map<String, List<String>> getParameters() { // [diːˈkəʊdə(r)]
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(req.uri());
        return queryStringDecoder.parameters();
    }

    /**
     * 获取参数第一个值
     *
     * @param name
     * @return
     */
    public String getParameters(String name) {
        Map<String, List<String>> parameters = this.getParameters();
        List<String> strings = parameters.get(name);
        if (Objects.isNull(strings)) {
            return null;
        } else {
            return strings.get(0); //
        }
    }

    public String getUrl() {
        return this.req.uri();
    }

    public String getMethod() {
        return this.req.method().name();
    }

}
