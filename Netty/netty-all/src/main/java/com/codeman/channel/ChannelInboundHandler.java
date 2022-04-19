package com.codeman.channel;

/**
 * @author hdgaadd
 * Created on 2022/04/19
 */
public interface ChannelInboundHandler extends ChannelHandler {
    void channelActive(ChannelHandler ctx) throws Exception;

    void channelRead(ChannelHandler ctx, Object msg);
}
