package org.codeman;

import org.codeman.model.Instance;
import org.codeman.subclasses.CustomLoadBalance;
import org.codeman.subclasses.RandomLoadBalance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdgaadd
 * created on 2022/10/25
 *
 * design: 采用java.security的SecureRandom实现
 *
 * 封装继承设计: interface -> interface -> abstract -> implementer
 */
public class Client {
    public static void main(String[] args) {
        List<Instance> instances = new ArrayList<Instance>(){{
            add(new Instance("127.0.0.1"));
            add(new Instance("127.0.0.2"));
            add(new Instance("127.0.0.3"));
        }};

        RandomLoadBalance randomLoadBalance = new RandomLoadBalance();
        for (int i = 0; i < 6; i++) {
            System.out.println(randomLoadBalance.load(instances));
        }

        CustomLoadBalance customLoadBalance = new CustomLoadBalance();
        for (int i = 0; i < 6; i++) {
            System.out.println(customLoadBalance.load(instances));
        }
    }
}
