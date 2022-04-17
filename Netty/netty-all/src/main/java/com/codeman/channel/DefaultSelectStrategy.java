package com.codeman.channel;

import com.codeman.until.IntSupplier;

/**
 * @author hdgaadd
 * Created on 2022/04/17
 */
public class DefaultSelectStrategy implements SelectStrategy{
    private static final SelectStrategy INSTANCE = new DefaultSelectStrategy();

    public DefaultSelectStrategy() {

    }

    @Override
    public int calculateStrategy(IntSupplier selectSupplier, boolean hasTasks) throws Exception {
        return hasTasks ? selectSupplier.get() : SelectStrategy.SELECT;
    }
}
