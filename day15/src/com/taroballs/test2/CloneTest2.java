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
        System.out.println("�����õ�����Ϣ");
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getTeacher().getName());
        System.out.println(student2.getTeacher().getAge());
        System.out.println("-------------");
        
        // �޸���ʦ����Ϣ
        teacher.setName("Teacher Zhang has changed");
        System.out.println(student1.getTeacher().getName());
        System.out.println(student2.getTeacher().getName());

        // ��������student1��student2ָ��ͬ����������
        // ������������student1��student2�е�����teacher����ָ�����ͬһ������
        // ����˵����ǳ����
        
	}

}
