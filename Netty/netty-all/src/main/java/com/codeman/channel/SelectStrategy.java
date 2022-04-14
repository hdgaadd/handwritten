package com.codeman.channel;

import com.codeman.until.IntSupplier;

/**
 * @author hdgaadd
 * Created on 2022/04/13
 */
public interface SelectStrategy {
    int SELECT = -1;

    int CONTINUE = -2;

    int BUSY_WAIT = -3;

    int calculateStrategy(IntSupplier selectSupplier, boolean hasTasks) throws Exception; // [ˈkælkjuleɪt]计算策略

}
