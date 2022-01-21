import aspects.LikeAspect;
import aspects.TimeIntervalAspect;
import service.Service;
import service.User;
import service.impl.ServiceImpl;
import service.impl.UserImpl;
import utils.MyHandlerImpl;
import utils.ProxyUtil;

import java.lang.reflect.Proxy;
/**
 * @author Chen
 **/

public class Test {
    public static void main(String[] args) throws Throwable {
        System.out.println("---------------普通实现---------------");
        Service service1=new ServiceImpl();
        service1.sout();
        User user1=new UserImpl();
        user1.userSout();

        System.out.println();System.out.println();

        System.out.println("---------------Myjdk动态代理实现+hutool的切面---------------");
        Service service2= (Service) ProxyUtil.proxy(new ServiceImpl(), LikeAspect.class);//创建代理类
        service2.sout();
        service2.sout2();
        User user2= (User) ProxyUtil.proxy(new UserImpl(), TimeIntervalAspect.class);
        user2.userSout();


        System.out.println();System.out.println();
        System.out.println("---------------Jdk源码动态代理实现---------------");
        Service service3=new ServiceImpl();
        MyHandlerImpl manHandler = new MyHandlerImpl(service3);
        //把  通过被代理类实现创建的内存加载对象、被代理类的接口、调用处理器传递给Proxy的newProxyInstance方法
        Service o = (Service)Proxy.newProxyInstance(service3.getClass().getClassLoader(), service3.getClass().getInterfaces(), manHandler);
        o.sout();
    }
}
