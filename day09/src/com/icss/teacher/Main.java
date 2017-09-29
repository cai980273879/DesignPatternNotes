package com.icss.teacher;

import static java.lang.Class.forName;

/*题外话：Class.class中的方法：
1.	asSubclass	强制转换成子类
2.	cast	强制转换类
3.	desiredAssertionStatus	返回类的断言状态
4.	forName	返回指定类名的类对象
5.	getAnnotatedInterfaces	返回类的注解接口
6.	getAnnotatedSuperclass	返回注解的父类
7.	getAnnotation	返回类的指定类型的注解
8.	getAnnotations	返回类的所有注解
9.	getAnnotationsByType	返回类的指定类型的注解
10.	getCanonicalName	返回底层类的规范名称
11.	getClassLoader	返回类的类装载器
12.	getClasses	返回类的所有public成员的类对象
13.	getComponentType	返回数组中存放数据的类型
14.	getConstructor	返回类的指定参数类型的构造函数
15.	getConstructors	返回类的所有public构造函数
16.	getDeclaredAnnotation	返回类的指定类型的注解
17.	getDeclaredAnnotations	得到类的所有注解
18.	getDeclaredAnnotationsByType	返回类的指定类型的注解
19.	getDeclaredClasses	返回包含类的所有成员类或接口的数组
20.	getDeclaredConstructor	返回类的指定构造函数对象
21.	getDeclaredConstructors	返回包含类的所有构造函数的数组
22.	getDeclaredField	返回类的指定变量的变量对象
23.	getDeclaredFields	返回包含类的所有变量的数组
24.	getDeclaredMethod	返回类的指定方法的方法对象
25.	getDeclaredMethods	返回包含类的所有方法的数组
26.	getDeclaringClass	如果类是另一个类的成员，返回类对象
27.	getEnclosingClass	返回底层类的包含类
28.	getEnclosingConstructor	如果类是一个构造函数中的本地或匿名类，返回这个构造函数对象
29.	getEnclosingMethod	如果类对象是一个方法内的本地或匿名类，返回这个方法对象
30.	getEnumConstants	返回枚举类的所有值
31.	getField	返回指定类的公共成员变量的字段对象
32.	getFields	返回类的所有public成员变量
33.	getGenericInterfaces	返回类直接实现的接口
34.	getGenericSuperclass	返回类的直接父类
35.	getInterfaces	返回类实现的所有接口
36.	getMethod	返回类的指定名字和参数类型的方法
37.	getMethods	返回类的所有方法
38.	getModifiers	返回类的整数表示的修饰符
39.	getName	返回类的名字
40.	getPackage	返回类的包名
41.	getProtectionDomain	返回类的保护域
42.	getResource	返回指定名字的资源
43.	getResourceAsStream	返回指定名字的资源
44.	getSigners	返回类的签名
45.	getSimpleName	返回类的简单名字
46.	getSuperclass	返回类的父类
47.	getTypeName	返回类的类型信息
48.	getTypeParameters	返回泛型类的类型变量
49.	isAnnotation	判断类型是不是注解
50.	isAnnotationPresent	判断注解类是不是当前类的注解
51.	isAnonymousClass	判断类是不是匿名类
52.	isArray	判断类型是不是数组
53.	isAssignableFrom	判断另一个类是不是当前类的同一个类或父类(父接口)
54.	isEnum	判断类型是不是枚举
55.	isInstance	判断一个对象是不是类的实例
56.	isInterface	判断类型是不是接口
57.	isLocalClass	判断一个类是不是本地类
58.	isMemberClass	判断一个类是不是成员类
59.	isPrimitive	判断一个类型是不是原始类型
60.	isSynthetic	判断一个类是不是合成类(运行时生成)
61.	newInstance	创建类的一个实例
62.	toGenericString	返回类的描述信息
63.	toString	返回类的字符串表示
 */

public class Main {
    private static final String TAG1 = Main.class.getName();
    private static final String TAG2 = Main.class.getSimpleName();
//    private static final String TAG3 = Main.class.getComponen tType();
    //Java的反射机制中通过Class类的getComponentType()方法可以取得一个数组的Class对象
    public static void main(String[] args) {
        System.out.println("getName---"+TAG1+"\n"+"getSimpleName---"+TAG2);
    }
}
