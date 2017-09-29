package com.icss.teacher;
/*
购物卡支付
 */
public class VoucherPay implements IPay{
    @Override
    public void pay(int money) {
        System.out.println("这里使用购物卡支付了"+money);
    }
}
