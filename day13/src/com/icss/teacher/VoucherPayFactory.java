package com.icss.teacher;

/**
 * Created by taroballs on 17-9-29.
 */
public class VoucherPayFactory implements IPayFactory {
    @Override
    public IPay getPay() {
        return new VoucherPay();
    }
}
