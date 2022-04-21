package com.codeman.handler;

import com.codeman.channel.ChannelHandlerContext;
import com.codeman.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hdgaadd
 * Created on 2022/04/21
 */
@Slf4j
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 管道激活
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }

    /**
     * 管道数据读取
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info(msg.toString()); // 读取管道数据

        ctx.writeAndFlush("hallo, i am netty-server");
    }

}
