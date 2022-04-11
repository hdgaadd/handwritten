package com.codeman.channel;

import java.util.concurrent.Future;

/**
 * @author hdgaadd
 * Created on 2022/04/11
 */
public interface ChannelFuture extends Future<Void> { // Future、Void??
    Channel channel();


}
