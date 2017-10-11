package com.icss.proxy;

public interface ATM{
    /**
     * 存钱
     * @param money
     */
    void save(int money);

    /**
     * 取钱
     * @param money
     */
    void pay(int money);

    /**
     * 获取余额
     * @return
     */
    int getMoney();

}
