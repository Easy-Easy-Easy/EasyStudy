package com.easy.annotation;

import java.lang.annotation.*;

//作用域
@Target({ElementType.FIELD})
//生命周期
@Retention(RetentionPolicy.RUNTIME)
//可见
@Documented
public @interface EAutowired {
    String value() default "";
}
