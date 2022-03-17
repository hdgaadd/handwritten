package com.codeman.bean.factory.two;

import com.codeman.bean.factory.BeanDefinition;
import com.codeman.bean.one.BeanFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hdgaadd
 * Created on 2022/03/02
 * @description
 * 底层规范实现者
 * 生产所有bean的工厂
 */
public class DefaultListableBeanFactory implements BeanFactory {

    private List<BeanDefinition> defines = new ArrayList<>();

    private Map<String, Object> singletons = new HashMap<>();


    @Override
    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }

    public List<BeanDefinition> getDefines() {
        return defines;
    }

    // TODO: some methods to do, I am tired
}
