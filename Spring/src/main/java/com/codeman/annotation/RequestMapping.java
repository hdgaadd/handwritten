package com.codeman.annotation;

import java.lang.annotation.*;

/**
 * @author hdgaadd
 * Created on 2022/03/01
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String value() default "";
}
