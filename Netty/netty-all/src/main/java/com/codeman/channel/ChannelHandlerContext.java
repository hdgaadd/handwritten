package com.codeman.channel;

/**
 * @author hdgaadd
 * Created on 2022/04/19
 */
public interface ChannelHandlerContext extends ChannelHandler{
    ChannelHandler handler();
}
