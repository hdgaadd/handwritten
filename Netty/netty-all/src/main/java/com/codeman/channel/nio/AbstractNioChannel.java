package com.codeman.channel.nio;

import com.codeman.channel.Channel;

/**
 * @author hdgaadd
 * Created on 2022/03/25
 * @description 第一层规范实现
 */
public class AbstractNioChannel implements Channel {
    @Override
    public Unsafe unsafe() {
        return null;
    }
}
