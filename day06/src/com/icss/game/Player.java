package com.icss.game;

/**
 * Created by taroballs on 17-9-26.
 */
public class Player {
    private String name;
    private Die die;

    public Player(String name, Die die) {
        super();
        this.name = name;
        this.die = die;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void play(){
        System.out.println("玩家"+name+"开始游戏");
        die.roll();
    }

    public Die getDie() {
        return die;
    }
}
