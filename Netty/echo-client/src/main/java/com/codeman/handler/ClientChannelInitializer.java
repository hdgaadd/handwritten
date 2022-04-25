package com.codeman.handler;

import com.codeman.channel.Channel;
import com.codeman.channel.ChannelInitializer;
import org.springframework.stereotype.Component;

/**
 * @author hdgaadd
 * Created on 2022/04/25
 */
@Component
public class ClientChannelInitializer extends ChannelInitializer {

    @Override
    public void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast(new EchoClientHandler());

    }
}
