package com.codeman;

import com.codeman.JedisClient.Jedis;

import java.io.IOException;

/**
 * @author hdgaadd
 * Created on 2022/02/22
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis();

        // SET与GET
        System.out.println(jedis.set("codeman", "hdgaadd"));

        System.out.println(jedis.get("codeman"));


        System.out.println("----------------------------------------------");

        // INCR操作使键的值+1
        System.out.println(jedis.set("number", "666"));

        System.out.println(jedis.incr("number"));
    }
}
