package com.junhua.chapitre6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//注解在运行时保留
@Target (ElementType.METHOD)
//Test 注解只在方法声明中管用
public @interface Test {
}
