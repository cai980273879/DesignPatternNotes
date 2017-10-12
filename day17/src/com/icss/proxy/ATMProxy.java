package com.icss.proxy;
/*
Proxy: 代理主题角色
 */
public class ATMProxy implements ATM {
    private ATM atm;

    public ATMProxy(ATM atm) {
        super();
        this.atm = atm;
    }

    @Override
    public void save(int money) {
        if(money<0) {
            throw new RuntimeException("存款金額不能為負數："+money);
        }
        atm.save(money);
    }

    @Override
    public void pay(int money) {
        if(atm.getMoney()>money&&money>0) {
            atm.pay(money);
        }else {
            throw new RuntimeException("取款失败，余额不足。余额："+atm.getMoney()+",取款："+money);
        }
    }

    @Override
    public int getMoney() {
        return atm.getMoney();
    }
}
