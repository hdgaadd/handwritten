package com.codeman.bootstrap;

import com.codeman.channel.Channel;
import lombok.Data;

/**
 * @author hdgaadd
 * Created on 2022/03/24
 */
@Data
public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel> {

}
