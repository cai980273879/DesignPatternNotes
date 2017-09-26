package com.icss.game;

import java.util.Random;

/**
 * Created by taroballs on 17-9-26.
 */
public class Die {
    private int faceValue;
    private Random random = new Random();
    public void roll(){
        System.out.println("投掷");
        faceValue = random.nextInt(6)+1;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
