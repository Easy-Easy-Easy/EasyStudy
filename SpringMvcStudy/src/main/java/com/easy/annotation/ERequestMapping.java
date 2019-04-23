package com.easy.annotation;

import java.lang.annotation.*;

//作用域
@Target({ElementType.TYPE,ElementType.METHOD})
//生命周期
@Retention(RetentionPolicy.RUNTIME)
//可见
@Documented
public @interface ERequestMapping {
    String value() default "";
}
