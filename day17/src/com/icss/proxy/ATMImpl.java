package com.icss.proxy;
/*
RealSubject:真实主题角色
 */
public class ATMImpl implements ATM{
    private int money = 1000;

    @Override
    public void save(int money) {
        this.money += money;
        System.out.println("存入"+money);
    }

    @Override
    public void pay(int money) {
        this.money -= money;
        System.out.println("取出"+money);
    }

    @Override
    public int getMoney() {
        return money;
    }
}
