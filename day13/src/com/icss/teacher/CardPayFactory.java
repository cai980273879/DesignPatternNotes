package com.icss.teacher;

public class CardPayFactory implements IPayFactory{

    @Override
    public IPay getPay() {
        return new CashPay();
    }
}
