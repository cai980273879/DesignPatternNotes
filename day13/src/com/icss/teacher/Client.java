package com.icss.teacher;

public class Client {
    public static void main(String[] args) {
        IPay pay = null;
        pay = new CashPay();//传统做法

		/*
		 * 简单工厂演示
		 */
        pay = PayFactory.getPay(PayFactory.VOUCHER);//使用设计模式
//		pay = PayFactory.getPay("card");
        pay = PayFactory.getPay1(PayFactory.CASH);

		/*
		 * 工厂方法
		 */
        IPayFactory factory = null;

        factory = new VoucherPayFactory();
        //工厂方法结合简单工厂
        factory = PayFactory.getPayFactory(PayFactory.CARD);

        pay = factory.getPay();

        //工厂方法结合简单工厂 增强版
        pay = PayFactory.getPay3(PayFactory.CARD);


        pay.pay(1000);
    }
//    这里的代码有点乱。先不管了，
}
