package com.icss.teacher;
/*题外话：getComponentType()方法尝试
java.lang.Class.getComponentType() 方法返回的类来表示数组的组件类型。如果该类不表示数组类此方法返回null。
声明:public Class<?> getComponentType()
返回值:此方法返回的类来表示这个类的组件类型，如果这个类是一个数组。
例子:
 */
import java.lang.*;
public class SimpleComponentType {
    public static void main(String[] args) {

        String[] arr = new String[]{"taroballs"};

        // returns the Class representing the component type
        Class arrClass = arr.getClass();
        Class componentType = arrClass.getComponentType();
        if(componentType != null){
            System.out.println("ComponentType = " + componentType.getName());
        } else {
            System.out.println("ComponentType is null");
        }
        /*Result:
        ComponentType = java.lang.String
        Consolution:Java的反射机制中通过Class类的getComponentType()方法可以取得一个数组的Class对象
         */
    }
}
