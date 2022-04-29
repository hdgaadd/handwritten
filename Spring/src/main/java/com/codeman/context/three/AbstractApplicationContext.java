package com.codeman.context.three;

import com.codeman.bean.factory.BeanDefinition;
import com.codeman.bean.factory.two.DefaultListableBeanFactory;
import com.codeman.context.two.ApplicationContext;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hdgaadd
 * Created on 2022/03/03
 * @description 第二层规范实现者之一
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected String configFile = "application.xml";

    /**
     * 根据url获取方法对象
     */
    private Map<String, Method> methodMap = new HashMap<String, Method>();

    /**
     * 根据url获取Controller对象，具体为根据beanId获取Controller对象
     */
    private Map<String, String> controllerMap = new HashMap<String, String>();

    private DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();


    @Override
    public void refresh() {

    }

    @Override
    public Method getHandlerMethod(String url) {
        return null;
    }

    @Override
    public Object getController(String url) {
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }

    /**
     * 扫描指定包下的文件，将相应bean添加到该集合里
     * @param packageName
     * @param beanDefinitions
     */
    private void doScanner(String packageName, List<BeanDefinition> beanDefinitions) {

    }

    /**
     * 扫描指定类名，将相应bean添加到该集合里
     * @param className
     * @param beanDefinitions
     */
    private void initScanAnnotation(String className, List<BeanDefinition> beanDefinitions) {

    }
}
