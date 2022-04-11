package com.codeman.channel;

import com.codeman.until.concurrent.EventExecutor;

import java.nio.channels.Selector;

/**
 * @author hdgaadd
 * Created on 2022/04/11
 */
public interface EventLoop extends EventExecutor {

    Selector selector(); // ??
}
