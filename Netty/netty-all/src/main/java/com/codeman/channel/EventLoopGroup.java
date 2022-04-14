package com.codeman.channel;

import com.codeman.until.concurrent.EventExecutor;

/**
 * @author hdgaadd
 * Created on 2022/04/13
 */
public interface EventLoopGroup {
    EventExecutor next();

    ChannelFuture register(Channel channel);
}
