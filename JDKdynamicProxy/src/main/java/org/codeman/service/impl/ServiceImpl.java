package org.codeman.service.impl;

import org.codeman.service.Service;

public class ServiceImpl implements Service {
    public void sout() {
        System.out.println("org/codeman/service");
    }

    @Override
    public void sout2() throws Throwable {
        System.out.println("动态代理会代理所有方法");
    }
}
