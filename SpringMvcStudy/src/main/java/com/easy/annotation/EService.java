package com.easy.annotation;

import java.lang.annotation.*;

//作用域
@Target(ElementType.TYPE)
//生命周期
@Retention(RetentionPolicy.RUNTIME)
//可见
@Documented
public @interface EService {
    String value() default "";
}
