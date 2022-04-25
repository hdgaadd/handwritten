package com.codeman.netty;

import com.codeman.bootstrap.Bootstrap;
import com.codeman.channel.EventLoop;
import com.codeman.channel.nio.NioEventLoopGroup;
import com.codeman.channel.socket.nio.NioServerSocketChannel;
import com.codeman.channel.socket.nio.NioSocketChannel;
import com.codeman.handler.ClientChannelInitializer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author hdgaadd
 * Created on 2022/04/25
 */
@Slf4j
@Data
@Component
public class NettyClient implements CommandLineRunner {
    @Value("${netty.host}")
    String host;
    @Value("${netty.port}")
    int port;

    @Autowired
    private ClientChannelInitializer clientChannelInitializer;

    @Override
    public void run(String... args) throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class);
        bootstrap.handler(clientChannelInitializer);
        bootstrap.connect(host, port);
    }
}
