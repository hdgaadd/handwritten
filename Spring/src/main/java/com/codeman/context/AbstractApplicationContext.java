package com.codeman.context;

import java.lang.reflect.Method;

/**
 * @author hdgaadd
 * Created on 2022/03/03
 * @description 规范实现者之一
 */
public class AbstractApplicationContext implements ApplicationContext {

    public void refresh() throws Exception {

    }

    public Method getHandlerMethod(String url) {
        return null;
    }

    public Object getController(String url) {
        return null;
    }

    public Object getBean(String beanName) {
        return null;
    }
}
