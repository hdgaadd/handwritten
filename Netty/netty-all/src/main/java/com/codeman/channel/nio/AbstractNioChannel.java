package com.codeman.channel.nio;

import com.codeman.channel.Channel;
import com.codeman.channel.DefaultChannelPipeline;
import com.codeman.channel.DefaultChannelPromise;
import com.codeman.channel.EventLoop;
import lombok.Data;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/**
 * @author hdgaadd
 * Created on 2022/03/25
 * @description 第一层规范实现
 */
@Data
public class AbstractNioChannel implements Channel {
    /**
     * NioServerSocketChannel
     */
    private Channel parent;

    /**
     * Java自带的Channel
     */
    private SelectableChannel channel;

    protected int ops;

    protected SelectionKey selectionKey;

    private final Unsafe unsafe;

    private final DefaultChannelPipeline defaultChannelPipeline; // [ˈpaɪplaɪn] 渠道

    private volatile EventLoop eventLoop;

    @Override
    public Unsafe unsafe() {
        return null;
    }
}
