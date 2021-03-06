package com.icss.teacher;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

import com.icss.teacher.Name;

public class SimpleDataBaseSystemAnnotation {

    private static File root = new File("~/Documents");

    private static Scanner sc;

    public static void main(String[] args) {

        printMenu();
        sc = new Scanner(System.in);
        String cmd = null;
        while(true) {
            cmd = sc.nextLine();
            if(cmd.equalsIgnoreCase("exit")) {
                return;
            }

            if(cmd.equalsIgnoreCase("menu")) {
                printMenu();
                continue;
            }

            if(cmd.startsWith("add ")) {
                try{
                    add(cmd.substring(3).trim());
                }catch(Exception ex){
                    System.out.println("添加失败："+ex.getMessage());
                }
                continue;
            }

            String regex = "^read +([^ ]+) +([^ ]+)$";
            if(cmd.matches(regex)) {
                try{
                    Object obj = readObjectFromProperties(cmd.replaceAll(regex, "$1"), cmd.replaceAll(regex, "$2"));
                    printObject(obj);
                }catch(Exception ex){
                    System.out.println("读取失败："+ex.getMessage());
                }
                continue;
            }

            System.out.println("未知的命令");
            System.out.println();

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



    private static void add(String className)throws Exception {

        /**
         * 获取要添加的类
         */
        Class<?> cls = null;
        try{
            cls = Class.forName("com.icss."+className);
        }catch(Exception ex){
            System.out.println("类com.icss."+className+"不存在");
        }

        /**
         * 实例化要添加的对象
         */
        Object obj = cls.newInstance();

//		int a = Integer.valueOf(arg0)

        //遍历所有公开的方法
        for(Method m : cls.getMethods()){
            //获取setter方法
            if(m.getName().startsWith("set")&&m.getParameterTypes().length==1){
                String name = m.getName();//获取方法名
                name = name.substring(3);//获取对应的字段名
                name = name.substring(0, 1).toLowerCase()+name.substring(1);
                Field f = cls.getDeclaredField(name);//找到setter方法所对应的成员变量
                if(f.isAnnotationPresent(Name.class)) {
                    Name nameAnnotation = f.getAnnotation(Name.class);
                    name = nameAnnotation.value();
                }

                System.out.println("请输入"+name+":");
                String value = sc.nextLine().trim();
                m.invoke(obj, value);//执行setter
            }

        }

        try{
            saveObjectToProperties(obj);
            System.out.println("保存数据成功");
            printObject(obj);
        }catch(Exception ex){
            System.out.println("保存数据失败："+ex.getMessage());
        }




    }

    /**
     * 保存一个对象到配置文件中
     * @param obj
     */
    private static void saveObjectToProperties(Object obj)throws Exception{
        File path = new File(root,obj.getClass().getSimpleName());
        path.mkdir();

        Class<?> cls = obj.getClass();

        Method getId = cls.getMethod("getId");//获取主键方法
        String id = (String)getId.invoke(obj);//获取主键

        if(id==null){
            throw new Exception("主键不能为空");
        }

        if(new File(path,id).exists()){
            throw new Exception("该数据已经存在");
        }

        Properties one = new Properties();

        //遍历所有公开的方法
        for(Method m : obj.getClass().getMethods()){
            //获取getter方法
            if(m.getName().startsWith("get")&&m.getParameterTypes().length==0){

                String name = m.getName();//获取方法名
                if(name.equals("getClass")){//不需要输出class属性
                    continue;
                }
                name = name.substring(3);//获取对应的字段名
                name = name.substring(0, 1).toLowerCase()+name.substring(1);

                String value = (String)m.invoke(obj);//执行getter
                one.setProperty(name, value);
            }
        }
        one.store(new FileWriter(new File(path,id)), null);
    }

    private static Object readObjectFromProperties(String className,String id)throws Exception{
        /**
         * 获取要添加的类
         */
        Class<?> cls = null;
        try{
            cls = Class.forName("com.icss."+className);
        }catch(Exception ex){
            System.out.println("类com.icss."+className+"不存在");
        }

        /**
         * 实例化要添加的对象
         */
        Object obj = cls.newInstance();

        Properties one = new Properties();
        one.load(new FileReader(new File(root,className+"/"+id)));

        //遍历所有公开的方法
        for(Method m : cls.getMethods()){
            //获取setter方法
            if(m.getName().startsWith("set")&&m.getParameterTypes().length==1){
                String name = m.getName();//获取方法名
                name = name.substring(3);//获取对应的字段名
                name = name.substring(0, 1).toLowerCase()+name.substring(1);

                String value = one.getProperty(name);
                m.invoke(obj, value);//执行setter
            }

        }
        return obj;
    }

    private static void printObject(Object obj)throws Exception{
        System.out.println("--------------------------------");
        System.out.println("\t数据名称："+obj.getClass().getSimpleName());
        //遍历所有公开的方法
        for(Method m : obj.getClass().getMethods()){
            //获取getter方法
            if(m.getName().startsWith("get")&&m.getParameterTypes().length==0){

                String name = m.getName();//获取方法名
                if(name.equals("getClass")){//不需要输出class属性
                    continue;
                }
                name = name.substring(3);//获取对应的字段名
                name = name.substring(0, 1).toLowerCase()+name.substring(1);

                Object value = m.invoke(obj);//执行getter
                System.out.println("\t"+name+":"+value);
            }
        }
        System.out.println("--------------------------------");

    }
}