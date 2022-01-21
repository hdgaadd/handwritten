package service.impl;

import service.Service;

public class ServiceImpl implements Service {
    public void sout() {
        System.out.println("service");
    }

    @Override
    public void sout2() throws Throwable {
        System.out.println("动态代理会代理所有方法");
    }
}
