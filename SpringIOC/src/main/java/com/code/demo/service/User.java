package com.code.demo.service;

import com.code.spring.Component;
import com.code.spring.Lazy;
import com.code.spring.Scope;

@Component("user")
@Scope("prototype")
@Lazy
public class User {
    int a=1;
}
