package com.icss.teacher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
@Target()说明了Annotation所修饰的对象范围
取值(ElementType)有：
CONSTRUCTOR:用于描述构造器
FIELD:用于描述域
LOCAL_VARIABLE:用于描述局部变量
METHOD:用于描述方法
PACKAGE:用于描述包
PARAMETER:用于描述参数
TYPE:用于描述类、接口(包括注解类型) 或enum声明
 */
//@Target(value = ElementType.METHOD)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyDefinedAnnotation {//public @interface 注解名 {定义体}
    String value();
}
