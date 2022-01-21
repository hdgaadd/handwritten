package com.code.demo.service;

import com.code.spring.Autowired;
import com.code.spring.Component;
import com.code.spring.Lazy;
import com.code.spring.Scope;

@Component("userService")
@Scope
@Lazy
public class UserService {
    @Autowired
    private User user;

    public void test(){
        System.out.println(user);
    }
}
