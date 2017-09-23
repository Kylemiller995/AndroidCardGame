package com.example.kylemiller.cardgame;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kylemiller on 22/09/2017.
 */
public class RandomNumberGeneratorTest {
    @Test
    public void genRanNum() throws Exception {
        int one = RandomNumberGenerator.genRanNum(1);
        assertEquals(one, 0);
    }

}