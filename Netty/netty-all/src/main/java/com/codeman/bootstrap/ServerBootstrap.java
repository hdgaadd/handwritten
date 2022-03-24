package com.codeman.bootstrap;

import com.codeman.channel.Channel;
import lombok.Data;

/**
 * @author hdgaadd
 * Created on 2022/03/24
 * @description 服务端的启动类
 * TODO: 这种泛型内置的设计目的是什么
 */
@Data
public class ServerBootstrap extends AbstractBootstrap<ServerBootstrap, Channel> { // AbstractBootstrap的B和C是该两者，且该B也继承于AbstractBootstrap

}
