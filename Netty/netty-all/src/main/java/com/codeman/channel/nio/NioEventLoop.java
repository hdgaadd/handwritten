package com.codeman.channel.nio;

import com.codeman.channel.*;
import com.codeman.until.IntSupplier;
import lombok.Data;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Objects;
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

    private Queue<Runnable> taskQueue; // 队列任务类型为实现Runnable的任务

    private volatile Thread thread;

    private Selector selector;

    private final IntSupplier selectNowSupplier = () -> selector.selectNow(); // 供应商

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
    }

    @Override
    public Selector selector() {
        return this.selector;
    }

    /**
     * 运行队列所有任务
     */
    private void runAllTasks() {
        for (; ; ) {
            Runnable task = taskQueue.poll();
            if (Objects.isNull(task)) {
                break;
            }
            task.run();
        }
    }

    private boolean addTasks(Runnable task) {
        return taskQueue.offer(task);
    }

    @Override
    public boolean inEventLoop() {
        return this.thread == Thread.currentThread(); // Thread.currentThread()返回当前代码段正在被哪个线程调用的信息
    }

    protected boolean hasTasks() {
        return !taskQueue.isEmpty();
    }

    @Override
    public void execute(Runnable command) {
        boolean inEventLoop = inEventLoop();
        taskQueue.add(command);

        // 如果处理任务的线程不是对象中的private volatile Thread thread，则创建新线程去处理任务
        if (!inEventLoop) {
            executor.execute(this::run);
        }
    }

    /**
     * 让线程阻塞，直到处理程序的线程为this.线程
     */
    private void run() {
        thread = Thread.currentThread();

        while (true) {
            try {
                int strategy = selectorStrategy.calculateStrategy(selectNowSupplier, hasTasks()); // [ˈkælkjuleɪt]
                switch (strategy) {
                    case SelectStrategy.CONTINUE:
                        continue;
                    case SelectStrategy.BUSY_WAIT:
                    case SelectStrategy.SELECT:
                        strategy = selector.select();
                        break;
                }

                if (strategy > 0) {
                    processSelectedKeys();
                }

                runAllTasks();
            } catch (Exception e) {
                e.printStackTrace(); // [treɪs]查出
            }


        }
    }

    private void processSelectedKeys() {
        if (selector.selectedKeys() != null) {
            processSelectedKeysOptimited(); // ['ɒptɪmaɪzd]充分利用
        }
    } // 结束
}
