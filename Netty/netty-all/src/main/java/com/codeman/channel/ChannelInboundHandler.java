package com.codeman.channel;

/**
 * @author hdgaadd
 * Created on 2022/04/19
 */
public interface ChannelInboundHandler extends ChannelHandler {
    void channelActive(ChannelHandlerContext ctx) throws Exception;

    void channelRead(ChannelHandlerContext ctx, Object msg);
}
