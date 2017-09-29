package com.icss.teacher;
/*
现金支付
 */
public class CashPay implements IPay {
    @Override
    public void pay(int money) {
        System.out.println("这里使用现金支付了"+money);
    }
}
