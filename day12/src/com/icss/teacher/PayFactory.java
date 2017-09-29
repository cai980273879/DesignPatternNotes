package com.icss.teacher;

import java.util.Properties;

/*
支付工厂
 */
public class PayFactory {

    /**
     * 银行卡支付
     */
    public static final String CARD = "card";

    /**
     * 现金支付
     */
    public static final String CASH ="cash";

    /**
     * 购物卡支付
     */
    public static final String VOUCHER = "voucher";

    public static IPay getPay(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "card":
                return new CreditCardPay();
            case "cash":
                return new CashPay();
            case "voucher":
                return new VoucherPay();
            default:
                return null;
        }
    }

    public static IPay getPay1(String type) {//在properties配置文件中使用type查找对应的classname并使用给出的classname反射使用对应的支付方式
        try {
            Properties config = new Properties();
            config.load(PayFactory.class.getResourceAsStream("config.properties"));
            type = type.toLowerCase();
            String className = config.getProperty(type);
            return (IPay)Class.forName(className).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
