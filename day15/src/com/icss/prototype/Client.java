package com.icss.prototype;

public class Client {
    public static void main(String[] args) throws Exception{
        ClassInfo cls = new ClassInfo();
        cls.setId(1);
        cls.setName("15级软件工程2班");

        Student stu1 = new Student();
        stu1.setAge(23);
        stu1.setClassInfo(cls);
        stu1.setName("张三");
        stu1.setNum("001");

        Student stu2 = null;

        stu2 = (Student)stu1.clone();

        stu2.setName("李四");
        stu2.getClassInfo().setName("15级软件工程1班");


        System.out.println(stu1);
        System.out.println(stu2);

        /*
        com.icss.prototype.Student@5e2de80c[num=001, name=张三, age=23, classInfo=com.icss.prototype.ClassInfo@1d44bcfa[id=1, name=15级软件工程2班]]
        com.icss.prototype.Student@266474c2[num=001, name=李四, age=23, classInfo=com.icss.prototype.ClassInfo@6f94fa3e[id=1, name=15级软件工程1班]]
         */
    }
    /*
    三种方法实现原型模式：
    1.重写clone方法：必须实现Cloneable接口
    2.自定义clone对象，调用Object clone()
    3.使用对象序列化进行克隆
     */
    /*
    深度克隆：同时实现重写组合中对象的克隆
     */
}
