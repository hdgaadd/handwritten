package com.codeman.channel;

import lombok.Data;

/**
 * @author hdgaadd
 * Created on 2022/04/19
 */
@Data
public abstract class AbstractChannelHandlerContext implements ChannelHandlerContext {
    private final DefaultChannelPipeline defaultChannelPipeline;

    volatile AbstractChannelHandlerContext next;

    volatile AbstractChannelHandlerContext prev;

    static void invokeChannelActive(AbstractChannelHandlerContext next) { // 传递该对象，实现调用该对象的private方法
        next.invokeChannelActive();
    }

    private void invokeChannelActive() {
        try {
            ((ChannelInboundHandler) handler()).channelActive(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
