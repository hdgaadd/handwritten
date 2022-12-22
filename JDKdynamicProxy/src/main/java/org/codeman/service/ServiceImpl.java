package org.codeman.service;

public class ServiceImpl implements Service {

    public void service0() {
        System.out.println("org/codeman/service");
    }

    @Override
    public void service1() throws Throwable {
        System.out.println("动态代理会代理所有方法");
    }

}
