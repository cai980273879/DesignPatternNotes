package com.taroballs.test4;
/*
 * 利用序列化来做深复制。

　　把对象写到流里的过程是序列化过程（Serialization），而把对象从流中读出来的过程则叫做反序列化过程（Deserialization）。

　　应当指出的是，写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。

　　在Java语言里深复制一个对象，常常可以先使对象实现Serializable接口，然后把对象（实际上只是对象的一个拷贝）写到一个流里，再从流里读出来，便可以重建对象。

　　这样做的前提是对象以及对象内部所有引用到的对象都是可串行化的，否则，就需要仔细考察那些不可串行化的对象可否设成transient，从而将其排除在复制过程之外。

　　注意Cloneable与Serializable接口都是marker Interface，也就是说它们只是标识接口，没有定义任何方法。
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

	        System.out.println("拷贝得到的信息:");
	        System.out.println(s2.getName());
	        System.out.println(s2.getAge());
	        System.out.println(s2.getTeacher().getName());
	        System.out.println(s2.getTeacher().getAge());
	        System.out.println("---------------------------");

	        // 将复制后的对象的老师信息修改一下：
	        s2.getTeacher().setName("New Teacher Wang");
	        s2.getTeacher().setAge(28);

	        System.out.println("修改了拷贝对象的教师后：");
	        System.out.println("拷贝对象的教师：");
	        System.out.println(s2.getTeacher().getName());
	        System.out.println(s2.getTeacher().getAge());
	        System.out.println("原来对象的教师：");
	        System.out.println(s1.getTeacher().getName());
	        System.out.println(s1.getTeacher().getAge());

	        // 由此证明序列化的方式实现了对象的深拷贝

	}
}
