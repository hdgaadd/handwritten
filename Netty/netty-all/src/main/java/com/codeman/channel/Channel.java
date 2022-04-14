package com.codeman.channel;

import sun.misc.Unsafe;

/**
 * @author hdgaadd
 * Created on 2022/03/24
 * @description netty网络操作底层规范
 */
public interface Channel {
    /**
     * Channel的协助类，用于进行IO读写操作
     */
    interface Unsafe {
        void read();

        void register(EventLoop eventLoop, ChannelPromise promise);
    }

    Unsafe unsafe();
}
