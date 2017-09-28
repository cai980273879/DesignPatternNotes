###Annotation(注解)
![](http://upload-images.jianshu.io/upload_images/3458176-c5642804973c8b6e.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
* 概述
  * Annotation即注解，也被翻译为注释，是JDK 5 Java对元数据（MetaData）的支持。
  *Annotation是代码里的特殊标记，这些标记可以在编译、类加载、运行时被读取，并执行相应的处理。
  *通过使用注解，程序开发人员可以在不改变逻辑的情况下，在源文件嵌入一些补充的信息。代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
  *Annotation提供了一种为程序元素设置数据的方法，从某些方面来看，Annotation就像修饰符一样，可用于修饰包、类、构造器、方法、成员变量、参数、局部变量的声明，这些信息被存储在Annotation的“name=value”对中。
  *Annotation能被用来为程序元素（类、方法、成员变量等）设置元数据。
  *Annotation不影响程序代码的执行，无论增加、删除Annotation，代码都始终如一地执行。
###5个基本Annotation
* @Override
* @Deprecated
* @SuppressWarnings
* @SafeVarargs
* @FunctionalInterface

(@FunctionalInterface是Java 8新增的。这5个基本的Annotation都定义在java.lang包下)
####Introduce to each Annotation
#####1.@Override
@Override就是用来指定一个方法是重写父类中的方法的。例如：
```
@Override
public String toString() {
    return super.toString();
}
```
上面是重写Object的toString()方法,我们用@Override来**标记**这个方法是重写父类Object中的toString()方法。如果不类不存在toString()方法，在编译时就会报错。
@Override主要是帮助程序员避免一些低级错误。例如父类中有个一个execute()的方法，但是我们在重写此方法的时候把方法名字写错了。这样我们在调用这个写错了的方法时不会影响程序的运行，但是得到的结果可能与我们的预期不同。这样的错误排查起来也非常费时费力，有了@Override可一定程度的解决这一问题的发生。

#####2.标识已过时：@Deprecated
@Deprecated用于表示某个程序元素（类、方法等）已过时，当其他程序使用已过时的类、方法时，编译器将会给出警告。例如：
```
public class Test {
    public static void main(String[] args) {
        // 下面使用info()方法是将会被编译器警告
        new Apple().info();
    }
}

class Apple {
    // 定义info方法已过时
    @Deprecated
    public void info() {
        System.out.println("Apple的info方法");
    }
```
#####3.抑制编译器警告：@SuppressWarnings
@SuppressWarnings指示被该Annotation修饰的程序元素（以及该程序元素中的所有子元素）取消显示指定的编译警告。
@SuppressWarnings会一直作用于该程序元素的所有自元素，例如，使用@SuppressWarnings修饰某个类取消显示某个编译器警告，同时又修饰该类里的某个方法取消显示另一个编译器警告，那么该方法将会同时取消显示这两个编译器警告。
```
@SuppressWarnings(value="unchecked")
public class Test {
    public static void main(String[] args) {
        List<String> myList = new ArrayList();
    }
}
```
如上代码所示，new ArrayList()；没有带有泛型，所以编译器会有警告，如果想要消除次警告有两种办法，一个是增加泛型，另一个则是使用@SuppressWarnings来标记Test或者标记main方法，也可以直接标记new ArrayList()这一条语句。这样编译器警告就会消失。
##### 4.Java 7的“堆污染”警告与@SafeVarargs
```
public static void main(String[] args) {
    List list = new ArrayList<Integer>();
    list.add(20); // 添加元素引发unchecked异常
    // 下面代码引起“未经检查的转换”的警告，编译、运行时完全正常
    List<String> ls = list;
    // 但只要访问ls里的元素，如下面代码就会引起运行时异常
    System.out.println(ls.get(0));
}
```
Java把引发这种错误的原因称为“堆污染”（Heap pollution）,当把一个不带泛型的对象赋给一个带泛型的变量时，往往就会发生这种“堆污染”，如上面的List< String > ls = list;这句代码。
三种“抑制”这个警告的方法：
```
使用@SafeVarargs修饰引发该警告的方法或构造器
使用@SuppressWarnings(“unchecked”)修饰。
编译时使用-Xlint：varargs选项
```
很明显，第三种方式一般比较少用，通常可以选择第一种或第二种方式，尤其是使用@SafeVarargs修饰引发该警告的方法构造器，它是Java 7专门为抑制“堆污染”警告提供的。
#####5.Java 8的函数式接口与@FunctionalInterface
@FunctionalInterface它是用来指定某个接口必须是函数式接口（一个接口中只能有一个抽象方法）
___
###元Annotation
JDK除了在java.lang下提供了5个基本的Annotation之外，还在java.lang.annotation包下提供了6个Meta Annotation（元Annotation），其中有5个元Annotation都用于修饰其他的Annotation定义。
(@Repeatable专门用于定义Java 8新增的重复注解。)




####1.@Retention
@Retention只能用于修饰Annotation定义，用于指定被修饰的Annotation可以保留多长时间

@Retention包含一个RetentionPolicy类型的value成员变量，所以使用@Retention时必须为该value成员变量指定值。value成员变量的值只能是如下三个：
* RetentionPolicy.CLASS:
编译器将把Annotation记录在class文件中。当运行Java程序时，JVM不可获取Annotation信息。这是默认值。

* RetentionPolicy.RUNTIME：
编译器将把Annotation记录在class文件中。当运行Java程序时，JVM也可获取Annotation信息。程序可以通过反射获取该Annotation信息。

* RetentionPolicy.SOURCE:
Annotation只能留在源码中，编译器直接丢弃这种Annotation。

如果需要通过反射获取注解信息，就需要使用value属性值为RetentionPolicy.RUNTIME的@Retention。使用@Retention元Annotation可采用如下代码为value指定值。

```
// 1.定义下面的Testable Annotation保留运行时
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Testable{}

// 2.定义下面的Testable Annotation将被编译器直接丢弃
@Retention(RetentionPolicy.SOURCE)
public @interface Testable{}
```
如第二种方式所示，当Annotation的变量名为value时，程序中可以直接在Annotation后的括号里指定该成员变量的值，无须使用name＝value的形式。
___
#####2.@Target
Target也只能修饰一个Annotation定义，它用于指定被修饰的Annotation能用于修饰那些程序单元。

@Target元Annotation也包含一个名为value的成员变量，该成员变量的值只能是如下几个。

* ElementType.ANNOTATION_TYPE:
指定该策略的Annotation只能修饰Annotation。
* ElementType.CONSTRUCTOR:
指定该策略的Annotation只能修饰构造器。
* ElementType.FIELD:
指定该策略的Annotation只能修饰成员变量。
* ElementType.LOCAL_VARIABLE:
指定该策略的Annotation只能修饰局部变量。
* ElementType.METHOD:
指定该策略的Annotation只能修饰方法定义。
* ElementType.PACKAGE:
指定该策略的Annotation只能修饰包定义。
* ElementType.PARAMETER:
指定该策略的Annotation只能修饰参数。
* ElementType.TYPE:
指定该策略的Annotation只能修饰类、接口（包括注解类型）或枚举定义。

使用@Target也可以直接在括号里指定value值，而无须使用name＝value的形式。如下代码指定@ActionListenerFor Annotation只能修饰成员变量。
```
@Target(ElementType.FIELD)
public @interface ActionListenerFor{}
```

___
#####3.@Documented
@Documented用于指定被该元Annotation修饰的Annotation类将被Javadoc工具提取成文档，如果定义Annotation类时使用了@Documented修饰，则所有使用该Annotation修饰的程序元素的API文档中将会包含该Annotation说明。明出处。

#####4.@Inherited
@Inherited元Annotation指定被它修饰的Annotation将具有继承性——如果某个类使用了@Xxx注解（定义该Annotation时使用了@Inherited修饰）修饰，则其子类将自动被@Xxx修饰。

____
###自定义Annotation
通过一个完整的例子来演示一下自定义Annotation。代码如下：
```
@Testable(name="hello",age=20)
public class Test {
    public static void main(String[] args) {

    }
}

// 定义下面的Testable Annotation保留运行时
@Retention(RetentionPolicy.RUNTIME)
// 可以修饰类、接口或枚举
@Target(ElementType.TYPE)
// 可以被javadoc工具提取成文档
@Documented
// 具有继承性
@Inherited
@interface Testable{
    // 定义成员变量name，默认值为TickTick
    String name() default "TickTick";
    // 定义成员变量age，默认值为18
    int age() default 18;
}
```
上面的例子已经有了详细的注释，自定义Annotation时一些规则:
* 根据我们的需求去添加不同的Annotation来修饰。
* 声明Annotation与声明接口类似，只不过是将interface关键字之前加了一个@符号。
* 成员变量的声明方式使用类似声明方法一样。
* 成员变量可以有默认值，如果有默认值则使用default关键字后面加默认值，当使用次Annotation时如果为成员变量指定值则默认值无效，否则使用默认值。
____
###分类：
根据Annotation是否可以包含成员变量，可以把Annotation分为如下两类。
* 1.标记Annotation：没有定义成员变量的Annotation类型被称为标记。这种Annotation仅利用自身的存在与否来提供信息，如前面介绍的@Override、@Test等Annotation。
* 2.元数据Annotation：包含成员变量的Annotation，因为他们可以接受更多的元数据，所以也被称为元数据Annotation。
____
###提取Annotation信息:
使用Annotation修饰了类、方法、成员变量等成员之后，这些Annotation不会自己生效，必须由开发者提供相应的工具来提取并处理Annotation信息。

Annotation接口是所有注解的父接口。

AnnotatedElement接口(java.lang.reflect反射包中)代表程序中可以接受注解的程序元素。即所有可以接受注解的程序元素都会实现该接口。而该接口就提供了获取Annotation的方法，它的所有实现类也便拥有了这些方法。常见的实现类：
```
Class：类定义。
Constructor：构造器定义。
Field：类的成员变量定义。
Method：类的方法定义。
Package：类的包定义。
```
由此可见，AnnotatedElement接口的实现类都是一些反射技术设计到的类，所以访问Annotation信息也是通过反射技术来实现的。

java.lang.reflect包下还包含实现反射功能的工具类，java5开始，java.lang.reflect包提供的反射API增加了读取允许Annotation的能力。但是，**只有定义Annotation时使用了@Rentention(RetentionPolicy.RUNTIME)修饰，该Annotation才会在运行时可见，JVM才会在装载*.class文件时读取保存在class文件中的Annotation。**

AnnotatedElement接口获取Annotation信息的方法：
```
<T extends Annotation> T getAnnotation(Class<T> annotationClass)：返回修饰该程序元素的指定类型的注解，不存在则返回 null。
<T extends Annotation> T getDeclaredAnnotation(Class<T> annotationClass)：返回直接修饰该程序元素的指定类型的注解，不存在则返回 null。 （java8新增）
Annotation[] getAnnotations()：返回此元素上存在的所有注解。
Annotation[] getDeclaredAnnotations()：返回直接存在于此元素上的所有注解。
boolean isAnnotationPresent (Class< ? extends Annotation> annotationClass)：如果指定类型的注解存在于此元素上，则返回 true，否则返回 false。
java8新增了重复注解功能，所以下面两个方法在java8之后才有：
<T extends Annotation> T[] getAnnotationsByType(Class<T> annotationClass)：返回修饰该程序元素的指定类型的多个注解，不存在则返回 null。
<T extends Annotation> T[] getDeclaredAnnotationsByType(Class<T> annotationClass)：返回直接修饰该程序元素的指定类型的多个注解，不存在则返回 null。
```
___
###案例
需求：获取Test类的info方法上的所有注解，并打印出来，如果包含MyTag注解，则再输出MyTag注解的元数据。

实现：正如我们所知，仅在程序中使用注解是不起任何作用的，必须使用注解处理工具来处理程序中的注解。下面就写一个注解处理类。处理注解的思路如下：通过反射获取Test的类描述类Class，然后在获取其info方法描述类Method，因为Method实现了AnnotatedElement接口，所以调用getAnnotations方法获取所有注解，在遍历打印。

MyTag注解处理器

```
public class MyTagAnnotationProcessor {
    public static void process(String className) throws ClassNotFoundException{
        try {
             Class clazz =Class.forName(className);
             Annotation[] aArray= clazz.getMethod("info").getAnnotations();
             for( Annotation an :aArray){
                 System.out.println(an);//打印注解
                 if( an instanceof MyTag){
                     MyTag tag = (MyTag) an;
                     System.out.println("tag.name():"+tag.name());
                     System.out.println("tag.age():"+tag.age());
                 }
             }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
```
场景测试
```
public static void main(String[] args) {
        try {
            MyTagAnnotationProcessor.process("annotation.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
```
测试结果
```
@annotation.MyTag(age=25, name=liang)
tag.name():cai
tag.age():25
```


具体更详细的可以看看简书：http://www.jianshu.com/p/28edf5352b63
