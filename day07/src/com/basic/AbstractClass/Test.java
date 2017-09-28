package com.basic.AbstractClass;

public class Test {
    public static void main(String[] args) {
        Animal a1 = new Dog();// 抽象类引用指向子类实例
        Animal a2 = new Cat();

        a1.cry();
        a2.cry();
    }
}
/*Result:
Dog Cry!
Cat Cry!
 */
/*Analyse:
由输出结果可以知道，使用a1,a2调用cry方法调用的是子类的cry方法，这是动态绑定，是实现多态的一种机制。
 */
