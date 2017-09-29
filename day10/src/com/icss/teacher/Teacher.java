package com.icss.teacher;

/**
 * 为上次的Teacher类增加注释，进行测试
 * 添加自定义的Annotation
 */
@MyDefinedAnnotation("taroballs")
@Name(value = "教师")
public class Teacher {

    @Name(value = "工号,order=1")
    private String id;
    @Name(value = "姓名")
    private String name;
    private String brithdate;
    private String sex;
    private String age;
    private String level;

    @MyDefinedAnnotation("taroballs")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrithdate() {
        return brithdate;
    }

    public void setBrithdate(String brithdate) {
        this.brithdate = brithdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
