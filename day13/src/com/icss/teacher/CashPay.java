package com.icss.teacher;

public class CashPay implements IPay {
    @Override
    public void pay(int money) {
        System.out.println("这里使用现金支付了："+money);
    }
}
