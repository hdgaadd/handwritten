package org.codeman.impl;

import org.codeman.Hello;
import org.codeman.RpcInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcInterfaceImpl implements RpcInterface {
    private static final Logger logger = LoggerFactory.getLogger(RpcInterfaceImpl.class);

    public String hello(Hello hello) {
        logger.info("HelloServiceImpl收到: {}.", hello.getMessage());
        String result = "Hello description is " + hello.getDescription();
        logger.info("HelloServiceImpl返回: {}.", result);
        return result;
    }
}
