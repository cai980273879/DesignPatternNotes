package com.icss.teacher;

public class CardPay implements IPay{

    @Override
    public void pay(int money) {
        System.out.println("这里使用银行卡支付了："+money);
    }
}
