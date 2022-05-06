package test;

import org.codeman.context.four.ClassPathXmlApplicationContext;
import org.codeman.context.two.ApplicationContext;
import test.service.UserService;

/**
 * @author hdgaadd
 * Created on 2022/05/06
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService.getUser());
        // NullPointException是因为核心类没有开发完毕
    }
}
