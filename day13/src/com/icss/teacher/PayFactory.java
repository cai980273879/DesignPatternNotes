package com.icss.teacher;

import java.util.Properties;

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
                return new CardPay();
            case "cash":
                return new CashPay();
            case "voucher":
                return new VoucherPay();
            default:
                return null;
        }
    }

    public static IPay getPay1(String type) {
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

    public static IPayFactory getPayFactory(String type) {
        try {
            Properties config = new Properties();
            config.load(PayFactory.class.getResourceAsStream("config-factory.properties"));
            type = type.toLowerCase();
            String className = config.getProperty(type);
            return (IPayFactory)Class.forName(className).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static IPay getPay3(String type) {
        try {
            Properties config = new Properties();
            config.load(PayFactory.class.getResourceAsStream("config-factory.properties"));
            type = type.toLowerCase();
            String className = config.getProperty(type);
            return ((IPayFactory)Class.forName(className).newInstance()).getPay();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
