package com.icss.teacher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties config = new Properties();
        config.load(PropertiesTest.class.getResourceAsStream("config.properties"));

        String name = config.getProperty("name");
        System.out.println(name);               //输出"value"

        String d = config.getProperty("d");
        System.out.println(d);                  //找不到这个key，输出"null"

        String e = config.getProperty("e","defaultValue");
        System.out.println(e);                  //找不到这个key，设置了默认值，输出“defaultValue”

        for(Object key:config.keySet()){
            System.out.println(key+"="+config.getProperty((String)key));
        }

        /*遍历输出：
        name=value
        a=\u5F20\u4E09
        b=1
        c=java
         */

        //=============================华丽的分割线==================================
        config.setProperty("age","24");
        config.setProperty("name","张师傅");

        config.store(new FileWriter("/home/taroballs/IdeaProjects/DesignPatternNotes/day09/src/com/icss/teacher/config.properties"),"This really a test!");
        /*PreResult:这是原来的配置文件：
        b=1
        a=张三
        name=value
        c=java

        ChangedPropertiesResult:改变之后的结果
        #This really a test!
        #Thu Sep 28 18:28:05 CST 2017
        b=1
        a=张三
        age=24
        name=张师傅
        c=java
         */
    }
}
