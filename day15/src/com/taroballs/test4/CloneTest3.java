package com.taroballs.test4;
/*
 * �������л�������ơ�

�����Ѷ���д������Ĺ��������л����̣�Serialization�������Ѷ�������ж������Ĺ�������������л����̣�Deserialization����

����Ӧ��ָ�����ǣ�д��������Ƕ����һ����������ԭ������Ȼ������JVM���档

������Java���������һ�����󣬳���������ʹ����ʵ��Serializable�ӿڣ�Ȼ��Ѷ���ʵ����ֻ�Ƕ����һ��������д��һ������ٴ������������������ؽ�����

������������ǰ���Ƕ����Լ������ڲ��������õ��Ķ����ǿɴ��л��ģ����򣬾���Ҫ��ϸ������Щ���ɴ��л��Ķ���ɷ����transient���Ӷ������ų��ڸ��ƹ���֮�⡣

����ע��Cloneable��Serializable�ӿڶ���marker Interface��Ҳ����˵����ֻ�Ǳ�ʶ�ӿڣ�û�ж����κη�����
 */
public class CloneTest3 {
	public static void main(String[] args)  throws Exception{
		 Teacher3 t = new Teacher3();
	        t.setName("Teacher Wang");
	        t.setAge(50);

	        Student3 s1 = new Student3();
	        s1.setAge(20);
	        s1.setName("ZhangSan");
	        s1.setTeacher(t);

	        Student3 s2 = (Student3) s1.deepClone();

	        System.out.println("�����õ�����Ϣ:");
	        System.out.println(s2.getName());
	        System.out.println(s2.getAge());
	        System.out.println(s2.getTeacher().getName());
	        System.out.println(s2.getTeacher().getAge());
	        System.out.println("---------------------------");

	        // �����ƺ�Ķ������ʦ��Ϣ�޸�һ�£�
	        s2.getTeacher().setName("New Teacher Wang");
	        s2.getTeacher().setAge(28);

	        System.out.println("�޸��˿�������Ľ�ʦ��");
	        System.out.println("��������Ľ�ʦ��");
	        System.out.println(s2.getTeacher().getName());
	        System.out.println(s2.getTeacher().getAge());
	        System.out.println("ԭ������Ľ�ʦ��");
	        System.out.println(s1.getTeacher().getName());
	        System.out.println(s1.getTeacher().getAge());

	        // �ɴ�֤�����л��ķ�ʽʵ���˶�������

	}
}
