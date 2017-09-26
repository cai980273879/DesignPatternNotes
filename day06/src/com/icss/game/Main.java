package com.icss.game;

/**
 * Created by taroballs on 17-9-26.
 * 骰子游戏简单代码
 */
public class Main {
    public static void main(String[] args) {
        Die die = new Die();
        Player player1 = new Player("刘大傻",die);
        Player player2 = new Player("熊二",new Die());
        DieGame dieGame = new DieGame(player1,player2);
        player1.play();
        player2.play();
        dieGame.printWinner();

    }
}
/*
Result:
玩家刘大傻开始游戏
投掷
玩家熊二开始游戏
投掷
玩家刘大傻的点数：5
玩家熊二的点数：1
获胜者是刘大傻
 */
