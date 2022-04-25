package com.codeman.until.concurrent;

/**
 * @author hdgaadd
 * Created on 2022/04/11
 */
public interface EventExecutorChooser {

    EventExecutor next();
}
