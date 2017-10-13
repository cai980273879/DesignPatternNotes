package com.taroballs.test2;

public class CloneTest2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Teacher teacher = new Teacher();
        teacher.setName("Teacher Zhang");
        teacher.setAge(40);

        Student2 student1 = new Student2();
        student1.setName("ZhangSan");
        student1.setAge(20);
        student1.setTeacher(teacher);

        Student2 student2 = (Student2) student1.clone();
        System.out.println("拷贝得到的信息");
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getTeacher().getName());
        System.out.println(student2.getTeacher().getAge());
        System.out.println("-------------");
        
        // 修改老师的信息
        teacher.setName("Teacher Zhang has changed");
        System.out.println(student1.getTeacher().getName());
        System.out.println(student2.getTeacher().getName());

        // 两个引用student1和student2指向不同的两个对象
        // 但是两个引用student1和student2中的两个teacher引用指向的是同一个对象
        // 所以说明是浅拷贝
        
	}

}
