
package com.icss.teacher;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;


/**
 编写一个学生类（学号、姓名、出生日期、性别、身高、考试成绩）

 编写一个教师类（工号、姓名、出生日期、性别、工龄、绩效等级）

 创建多个（>2）学生对象，并保存成配置文件
 创建多个(>1)教师对象，并保存成配置文件

 编写一个方法，使用反射，调用对象的setter方法，设置对象属性

 编写一个方法，将各配置文件读取成学生对象和教师对象
 */

public class SimpleDataBaseSystem {
    private static File root = new File("~/");
    private static Scanner sc;

    public static void main(String[] args) {
        printMenu();
        sc = new Scanner(System.in);
        String cmd = null;
        while (true){
            cmd = sc.nextLine();
            if(cmd.equalsIgnoreCase("exit")){
                return;
            }
            if(cmd.equalsIgnoreCase("meau")){
                printMenu();
                continue;
            }
            if(cmd.startsWith("add ")){
                try{

                }catch (Exception e){
                    System.out.println("添加失败"+e.getMessage());
                }
                continue;
            }

            String regex = "^read +([^ ]+) +([^ ]+)$";
            if(cmd.matches(regex)){
                try {
                    Object obj = readObjectFromProperties();
                }
            }
        }
    }
    private static void printMenu() {
        System.out.println("-------------------------");
        System.out.println("\tmenu:打印菜单");
        System.out.println("\tadd [类名]:添加一个对象");
        System.out.println("\tread [类名] [标识]：读取一个编号为id的什么对象");
        System.out.println("\texit:退出");
        System.out.println("-------------------------");
    }

    private static void add(String className)throws Exception{

        //获取需要添加的类


        Class<?> cls = null;
        try{
            cls = Class.forName("com.icss.teacher."+className);
        }catch (Exception e){
            System.out.println("类com.icss."+className+"不存在");
        }


        /*实例化要添加的对象*/
        Object obj = cls.newInstance();//无参构造
        int x = Integer.valueOf(arg0);


        /*遍历所有公开的方法*/
        for (Method m : cls.getMethods()){
            if(m.getName().startsWith("set")&&m.getParameterTypes().length==1){
                String name = m.getName();//获取方法名
                name = name.substring(3);//获取"setXXXX"中的"XXXX"
                name = name.substring(0,1).toLowerCase()+name.substring(1);
                System.out.println("请输入"+name+":");
                String value = sc.nextLine();
                m.invoke(obj,value);//执行setter
            }
        }
        try{
            saveObjectToProperties(obj);
            System.out.println("保存数据成功");
            printObject(obj);
        }catch (Exception e){
            saveObjectToProperties("保存数据失败"+e.getMessage());
        }

    }


    /**
     * 保存一个对象到配置文件中
     * @param obj
     */
    private static void saveObjectToProperties(Object obj) throws Exception{
        File path = new File(root,obj.getClass().getSimpleName());
        path.mkdir();

        Class<?> cls = obj.getClass();

        Method getId = cls.getMethod("getId");//获取主键方法
        String id = (String)getId.invoke(obj);//获取主键

        if(id == null){
            throw new Exception("主键不能为空");
        }
        if(new File(path,id).exists()){
            throw new Exception("数据已经存在");
        }

        Properties config = new Properties();
        //生成properties对象

        //遍历所有公开的方法
        for(Method m : obj.getClass().getMethods()){
            //获取getter方法
            if(m.getName().startsWith("get")&&m.getParameterTypes().length==0){
                String name = m.getName();//获取方法名
                if(name.equals("getClass")){
                    continue;
                }//不需要输出class属性
                name = name.substring(3);//比如说是getXXX那么获取到的就是XXX
                name = name.substring(0,1).toLowerCase()+name.substring(1);

                String value = (String)m.invoke(obj);//执行getter方法
                config.setProperty(name,value);//
            }
        }
        config.store(new FileWriter(new File(path,id)),null);
    }
}