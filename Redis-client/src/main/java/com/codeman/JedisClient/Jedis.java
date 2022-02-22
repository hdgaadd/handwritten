package com.codeman.JedisClient;

import com.codeman.Redis.Command;
import com.codeman.util.CommandTransformUtil;
import com.codeman.util.SocketUtil;

import java.io.IOException;

/**
 * @author hdgaadd
 * Created on 2022/02/22
 *
 * Jedis客户端
 */
public class Jedis {

    private SocketUtil socketUtil = new SocketUtil("127.0.0.1", 6379);

    public Jedis() throws IOException {

    }

    /**
     * 添加键值对
     * @param key
     * @param value
     * @return
     * @throws IOException
     */
    public String set(String key, String value) throws IOException {
        socketUtil.send(CommandTransformUtil.commandTransform(Command.SET, key.getBytes(), value.getBytes()));
        return socketUtil.read();
    }

    /**
     * 获取值
     * @param key
     * @return
     * @throws IOException
     */
    public String get(String key) throws IOException {
       socketUtil.send(CommandTransformUtil.commandTransform(Command.GET, key.getBytes()));
        return socketUtil.read();
    }

    /**
     * 获取值
     * @param key
     * @return
     * @throws IOException
     */
    public String incr(String key) throws IOException {
        socketUtil.send(CommandTransformUtil.commandTransform(Command.INCR, key.getBytes()));
        return socketUtil.read();
    }
}
