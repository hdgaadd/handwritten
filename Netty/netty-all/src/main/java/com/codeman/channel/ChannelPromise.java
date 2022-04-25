package com.codeman.channel;

import com.codeman.until.concurrent.GenericFutureListener;
import lombok.Data;

import java.util.Objects;
import java.util.concurrent.Future;

/**
 * @author hdgaadd
 * Created on 2022/04/14
 */
@Data
public abstract class ChannelPromise implements ChannelFuture {
    protected Object listener;

    @Override
    public abstract Channel channel();

    @Override
    public ChannelFuture addListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        if (!Objects.isNull(listener)) {
            this.listener = listener;
        }
        return this;
    }

}
