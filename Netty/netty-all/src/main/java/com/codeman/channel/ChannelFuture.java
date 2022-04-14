package com.codeman.channel;

import com.codeman.until.concurrent.GenericFutureListener;

import java.util.concurrent.Future;

/**
 * @author hdgaadd
 * Created on 2022/04/11
 */
public interface ChannelFuture extends Future<Void> { // Future、Void??
    Channel channel();

    ChannelFuture addListener(GenericFutureListener<? extends Future<? super Void>> future); // 下界通配符
}
