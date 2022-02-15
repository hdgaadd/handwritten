package com.codeman;

import com.codeman.component.RpcServer;
import com.codeman.impl.RpcInterfaceImpl;

public class ServiceApplication {
    public static void main(String[] args) {
        RpcInterface helloService = new RpcInterfaceImpl(); // 消息格式
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9939);
    }
}
