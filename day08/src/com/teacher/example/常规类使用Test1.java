package com.teacher.example;

public class 常规类使用Test1 {
    public static void main(String[] args) {
        Student s1=null,s2=null;

        System.out.println("-----------类的实例化------------");
        s1 = new Student();
        s2 = new Student("张三", 172, 36, 60F, "200011111");

        System.out.println("-----------对象的成员变量的访问------------");
        s1.name = "李斯";
        String name = s2.name;
        System.out.println("name="+name);
        s1.className="软件一班";
        Student.className="软件二班";
        String className = Student.className;
        System.out.println("className="+className);


        System.out.println("-----------对象的成员方法的调用------------");
        s1.setAge(50);
        Student.setClassName("软件三班");
        int age = s1.getAge();
        System.out.println("age="+age);


        System.out.println("-----------输出结果------------");
        System.out.println(s1);
        System.out.println(s2);
    }
}
