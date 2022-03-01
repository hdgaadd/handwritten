package com.codeman.annotation;

import java.lang.annotation.*;

/**
 * @author hdgaadd
 * Created on 2022/03/01
 */
@Documented
@Target({ElementType.PARAMETER}) // [pəˈræmɪtə(r)]
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {

    String value() default "";
}
