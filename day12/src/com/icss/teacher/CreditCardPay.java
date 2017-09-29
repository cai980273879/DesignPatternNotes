package com.icss.teacher;
/*
银行卡支付
 */
public class CreditCardPay implements IPay{

    @Override
    public void pay(int money) {
        System.out.println("这里使用银行卡支付了"+money);
    }
}
