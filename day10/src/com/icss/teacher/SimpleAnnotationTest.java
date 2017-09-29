package com.icss.teacher;

@Deprecated()
public class SimpleAnnotationTest {
    @Deprecated
    private String bb;

    @SuppressWarnings("unused")
    public void test1(@SuppressWarnings("unused")String name){
        @SuppressWarnings("unused")
                String a;
    }
}
