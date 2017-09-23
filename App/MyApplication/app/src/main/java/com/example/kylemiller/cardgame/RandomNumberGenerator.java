package com.example.kylemiller.cardgame;

import java.util.Random;

/**
 * Created by kylemiller on 22/09/2017.
 */

public class RandomNumberGenerator {

    public static int genRanNum(int upperLimit) {
        Random random = new Random();
        int randomNumber = random.nextInt(upperLimit);
        return randomNumber;
    }
}
