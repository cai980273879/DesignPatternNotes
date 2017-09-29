package com.icss.teacher;

public class Client {
    public static void main(String[] args) {
        IPay pay = null;
       //1. pay = new CreditCashPay();//传统做法
       /*2. pay = PayFactory.getPay(PayFactory.VOUCHER);//使用设计模式：静态方法，以及静态变量
        pay.pay(2017);
        //Result:这里使用购物卡支付了2017
        */

       /*
        3. pay = PayFactory.getPay("cash");//或者你也可以直接指定类型
        pay.pay(20000);
        //Result:这里使用现金支付了20000
        */
        pay = PayFactory.getPay1(PayFactory.CASH);
        pay.pay(30000);//这里使用现金支付了30000,在配置文件中查找方法

    }
}
