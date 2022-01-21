package com.code.spring;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//next:通过getBean()创建singletonBean或者prototypeBean,使用某个类去实现new这个bean;给bean的属性赋值;bean的属性有另一个对象便创建这个对象,也可获取该对象的属性值
public class CodeApplicationContext {//启动类
    private Class configClass;
    private Map<String,BeanDefinition> beanDefinitionmap=new ConcurrentHashMap();//存放类的注解的对象
    public CodeApplicationContext(Class configClass) {//创建启动类时获取config
        this.configClass = configClass;

        //扫描注解，获取类
        List<Class> classList = new ArrayList<Class>();
        scan(configClass, classList);//把加载类的逻辑抽象成scan方法
        //System.out.println(classList);
        //获取类的注解
        for (Class aClass : classList) {

            if(aClass.isAnnotationPresent(Component.class)){
                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setBeanClass(aClass);//把类文件user.class这些放入BeanDefinition

                Component componentAnnotation = (Component)aClass.getAnnotation(Component.class);
                String beanName=componentAnnotation.value();

                if(aClass.isAnnotationPresent((Scope.class))){//如果是原型
                    Scope scopeAnnotation = (Scope)aClass.getAnnotation(Scope.class);
                    beanDefinition.setScope(scopeAnnotation.value());//把原型注解放在BeanDefinition对象
                }else{//单例
                    beanDefinition.setScope("singleton");
                }


                beanDefinitionmap.put(beanName,beanDefinition);//把类文件注解和对应的BeanDefinition对象放在map里,此时BeanDefinition存放类的所有注解
            }

        }

        creatSingletonBean();//创建单例bean


    }

    private void creatSingletonBean() {
        
    }

    private void scan(Class configClass, List<Class> classList) {
        //获取config上的注解(annotation)
        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
        String path = componentScanAnnotation.value();
        //System.out.println(path);
        path = path.replace(".", "/");
        ClassLoader classLoader = CodeApplicationContext.class.getClassLoader();//使用类加载器获取包
        URL url = classLoader.getResource(path);
        File file = new File(url.getFile());//获取包的文件夹
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String absolutePath = f.getAbsolutePath();//获取文件夹的每个class文件的路径
                absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
                absolutePath = absolutePath.replace("\\", ".");//类加载器要加载类必须是com.demo.的格式，不能\\
                //System.out.println(absolutePath);
                try {
                    Class<?> aClass = classLoader.loadClass(absolutePath);
                    classList.add(aClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    //获取
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition=beanDefinitionmap.get(beanName);
        if(beanDefinition.equals("prototype")){

        }else if(beanDefinition.equals("singleton")){

        }
        return null;
    }
}
