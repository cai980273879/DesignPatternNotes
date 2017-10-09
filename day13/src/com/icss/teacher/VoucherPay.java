package com.icss.teacher;

public class VoucherPay implements IPay{
    @Override
    public void pay(int money) {
        System.out.println("这里使用购物卡支付了："+money);
    }
}
