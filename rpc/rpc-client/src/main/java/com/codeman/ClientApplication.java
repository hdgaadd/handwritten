package com.codeman;

import com.codeman.component.RpcClientProxy;

public class ClientApplication {
    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy("127.0.0.1", 9939);
        RpcInterface helloService = rpcClientProxy.getProxy(RpcInterface.class); // 创建代理类：方法执行，修改为向端口发送消息

        String hello = helloService.hello(new Hello("111", "666")); // Hello为消息，helloService返回消息
        System.out.println(hello);
    }
}
