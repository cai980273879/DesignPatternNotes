package com.taroballs.icss;
public class CloneTest1{
	//http://www.cnblogs.com/mengdd/archive/2013/02/20/2917971.html
	public static void main(String[] args) throws CloneNotSupportedException
	{
    Student student1 = new Student();
    student1.setName("ZhangSan");
    student1.setAge(20);

    Student student2 = new Student();
    student2 = (Student) student1.clone();

    System.out.println("�����õ�����Ϣ");
    System.out.println(student2.getName());
    System.out.println(student2.getAge());
    System.out.println("-------------");

    // �޸ĵڶ����������Ϣ
    student2.setName("LiSi");
    student2.setAge(25);

    System.out.println("�޸ĵڶ������������Ϊlisi,25��");
    System.out.println("��һ������");
    System.out.println(student1.getName());
    System.out.println(student1.getAge());
    System.out.println("�ڶ�������");
    System.out.println(student2.getName());
    System.out.println(student2.getAge());
    System.out.println("-------------");
    
    // ˵����������student1��student2ָ����ǲ�ͬ�Ķ���
	}
}