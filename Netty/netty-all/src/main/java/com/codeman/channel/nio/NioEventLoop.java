package com.codeman.channel.nio;

import com.codeman.channel.EventLoop;
import com.codeman.until.IntSupplier;

import java.nio.channels.Selector;

/**
 * @author hdgaadd
 * Created on 2022/03/25
 * @description Nio事件循环
 */
public class NioEventLoop implements EventLoop {

    private Selector selector;

    private final IntSupplier selectNowSupplier = () -> selector.selectNow();



    @Override
    public Selector selector() {
        return null;
    }

    @Override
    public void execute(Runnable command) {

    }
}
