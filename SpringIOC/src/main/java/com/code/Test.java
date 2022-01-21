package com.code;

import com.code.demo.AppConfig;
import com.code.spring.CodeApplicationContext;

public class Test {//主类

    public static void main(String[] args) {
        CodeApplicationContext codeApplicationContext=new CodeApplicationContext(AppConfig.class);
        Object o=codeApplicationContext.getBean("userService");
        System.out.println(o);
    }
}
