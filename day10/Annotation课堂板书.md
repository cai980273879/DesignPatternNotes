注解的基本概念和原理
* Annotation其实是一种接口。通过Java的反射机制相关的API来访问annotation信息
* annotation是不会影响程序代码的执行，无论annotation怎么变化，代码都始终如一地执行。
* ava语言解释器在工作时会忽略这些annotation，因此在JVM 中这些annotation是“不起作用”的，只能通过配套的工具才能对这些annontaion类型的信息进行访问和处理。
___
1.Annotation与interface的异同
* Annotation类型使用关键字@interface而不是interface
这个关键字声明隐含了一个信息：它是继承了java.lang.annotation.Annotation接口，并非声明了一个interface
* Annotation类型、方法定义是独特的、受限制的。
* Annotation 类型的方法必须声明为无参数、无异常抛出的
* Annotation类型又与接口有着近似之处。
它们可以定义常量、静态成员类型（比如枚举类型定义）。Annotation类型也可以如接口一般被实现或者继承。
2.自定义注解@interface
3.元注解:注解的作用就是负责注解其他注解。
@Target
    * 说明了Annotation所修饰的对象范围：
		ElementType
		CONSTRUCTOR:用于描述构造器
		
        FIELD:用于描述域

		LOCAL_VARIABLE:用于描述局部变量

		METHOD:用于描述方法

		PACKAGE:用于描述包

		PARAMETER:用于描述参数

		TYPE:用于描述类、接口(包括注解类型) 或enum声明

	
@Retention
    * 表示需要在什么级别保存该注释信息，用于描述注解的生命周期(即：被描述的注解在什么范围内有效）
		RetentionPolicy
		SOURCE:在源文件中有效（即源文件保留）
		
CLASS:在class文件中有效（即class保留）

		RUNTIME:在运行时有效（即运行时保留）

	
@Documented
	* 用于描述其它类型的annotation应该被作为被标注的程序成员的公共API
@Inherited:
    * 如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。
4.注解参数的可支持数据类型

	1.所有基本数据类型（int,float,boolean,byte,double,char,long,short)
	2.String类型

	3.Class类型
	4.enum类型
	5.Annotation类型
	6.以上所有类型的数组


5.注解的使用

    @注解 @注解()
    @注解(值) @注解(value=值)
    @注解(参数=值,参数=值)

6.注解编程

	通过反射
	
    isAnnotationPresent(Class)

	getAnnotation(Class)
	
7.作业
    为上次作业编写一个Anotation，用于指定实体类属性和类名的中文名，并加入对应的提示。