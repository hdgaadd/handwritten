package com.codeman.until.concurrent;

import com.codeman.channel.Channel;
import com.codeman.channel.ChannelFuture;

import java.util.concurrent.Executor;

/**
 * @author hdgaadd
 * Created on 2022/04/11
 */
public interface EventExecutor extends Executor {
    ChannelFuture register(Channel channel);

    boolean isEventLop();
}
