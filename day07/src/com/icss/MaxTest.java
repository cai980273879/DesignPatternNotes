package com.icss;
/**
 * Created by taroballs on 17-9-26.
 */
public class MaxTest {
    /*
    写一个基本类型的排序方法，也可以用Array.sort(a,b)
     */
    public static int max(int... as){//求最大值 as为参数数组
        int x = as[0];
        for(int i=1;i<=as.length;i++){
            if(x<as[i]){
                x=as[i];
            }
        }
        return x;
    }
    /*紧接着
    类似与上面的a于b的比较
    写一个继承于MyComparator接口的方法对比Student
     */
    public static Student max(MyComparator comparator,Student... as){
        Student x = as[0];
        for(int i=1;i<as.length;i++){
            if(comparator.comparat(x,as[i])){
                x = as[i];
            }
        }
        return x;
    }




    public static void main(String[] args) {


        Student s1 = new Student("张三", 18, 160, 99.9F);
        Student s2 = new Student("张三封", 100, 180, 59.9F);
        Student s3 = new Student("赵封", 50, 150, 89.9F);

        /*
        测试自定义的max方法：
         */
        System.out.println(max(new MyComparator<Student>() {
            @Override
            public boolean comparat(Student s1, Student s2) {
                    return  s1.getResult()<s2.getResult();
            }
        },s1,s2,s3));//关键覆写

        /*
        Result:
        Student{name='张三', age=18, height=160, result=99.9}
        //张三的分数是最高的
         */
    }
}
