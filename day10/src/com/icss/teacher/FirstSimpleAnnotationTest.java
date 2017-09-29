package com.icss.teacher;
/*Annotation例子
使用到@Deprecated() 已过时
 @SuppressWarnings() 抑制警告

首先进行一个AnnotationTest
 */
@Deprecated() //提醒你不要使用“过时”方法
public class SimpleAnnotationTest {
    @Deprecated
    private String bb;

    @SuppressWarnings("unused")  //抑制编译器警告
    public void test1(@SuppressWarnings("unused") String name){
        @SuppressWarnings("unused")
                String a;
    }
}
