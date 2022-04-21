package com.codeman.channel;

/**
 * @author hdgaadd
 * Created on 2022/04/21
 */
public abstract class ChannelInitializer<C extends Channel> extends ChannelInboundHandlerAdapter {
    public abstract void initChannel(C ch) throws Exception;

    public void readChannel(ChannelHandlerContext ctx, Object msg) {
    }
}
