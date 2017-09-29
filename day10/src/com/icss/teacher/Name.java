package com.icss.teacher;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented  //文档化
@Retention(RUNTIME)  //生命周期，运行时
@Target({ TYPE, FIELD }) //类型以及域
@Inherited
public @interface Name {

    String value();// default "";

    int order() default 0;
}
