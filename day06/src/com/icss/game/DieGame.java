package com.icss.game;

/**
 * Created by taroballs on 17-9-26.
 */
public class DieGame {
    private Player player1,player2;

    public DieGame(Player player1, Player player2) {
        super();
        this.player1 = player1;
        this.player2 = player2;
    }
    public void printWinner(){
        Player player = isWinner();
        if (player == null){
            System.out.println("平局");
        }
        else {
            System.out.println("获胜者是" + player.getName());
        }
    }
    private Player isWinner(){
        System.out.println("玩家"+player1.getName()+"的点数："+player1.getDie().getFaceValue());
        System.out.println("玩家"+player2.getName()+"的点数："+player2.getDie().getFaceValue());
        if(player1.getDie().getFaceValue()>player2.getDie().getFaceValue()) {
            return player1;
        }else if(player1.getDie().getFaceValue()<player2.getDie().getFaceValue()) {
            return player2;
        }else {
            return null;
        }
    }
}
