package com.codeman.channel;

/**
 * @author hdgaadd
 * Created on 2022/04/18
 */
public class DefaultChannelPipeline implements ChannelPipeline { // [ˈpaɪplaɪn]管道

    private AbstractChannelHandlerContext head;

    private AbstractChannelHandlerContext tail;

    private Channel channel;

    public final ChannelPipeline fireChannelActive() { // fire激发
        AbstractChannelHandlerContext.invokeChannelActive(head);
        return this;
    }

}
