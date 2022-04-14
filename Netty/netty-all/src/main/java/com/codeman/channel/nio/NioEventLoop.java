package com.codeman.channel.nio;

import com.codeman.channel.*;
import com.codeman.until.IntSupplier;
import lombok.Data;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author hdgaadd
 * Created on 2022/03/25
 * @description Nio事件循环
 *
 * BEAUTIFUL DESIGN
 */
@Data
public class NioEventLoop implements EventLoop {

    private final EventLoopGroup eventLoopGroup;

    private final Executor executor;

    private final SelectorProvider selectorProvider;

    private final SelectStrategy selectorStrategy; // [ˈstrætədʒi]策略

    private Queue<Runnable> taskQueue;

    private volatile Thread thread;

    private Selector selector;

    private final IntSupplier selectNowSupplier = () -> selector.selectNow();

    public NioEventLoop(EventLoopGroup eventLoopGroup, Executor executor, SelectorProvider selectorProvider, SelectStrategy selectorStrategy) {
        this.eventLoopGroup = eventLoopGroup;
        this.executor = executor;
        this.selectorProvider = selectorProvider;
        this.selectorStrategy = selectorStrategy;

        try {
            this.selector = selectorProvider.openSelector();
        } catch (IOException e){
            e.printStackTrace();
        }
        this.taskQueue = new LinkedBlockingQueue<Runnable>(Integer.MAX_VALUE);
    }

    @Override
    public ChannelFuture register(Channel channel) {
        ChannelPromise promise = new DefaultChannelPromise(channel, this);
        promise.channel().unsafe().register(this, promise);
        return promise;
    } // 结束

    @Override
    public Selector selector() {
        return null;
    }

    @Override
    public void execute(Runnable command) {

    }

    @Override
    public boolean isEventLop() {
        return false;
    }
}
