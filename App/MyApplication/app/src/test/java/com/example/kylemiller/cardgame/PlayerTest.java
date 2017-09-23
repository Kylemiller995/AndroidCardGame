package com.example.kylemiller.cardgame;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kylemiller on 22/09/2017.
 */
public class PlayerTest {


    Player player;
    Card card;

    @Before
    public void setUp(){
        player = new Player("kyle");
        card = new Card(CardSuit.CLUBS, CardValue.ACE);
    }


    @Test
    public void getName() {
        assertEquals(player.getName(), "kyle" );

    }

    @Test
    public void getHand() {
        assertEquals(player.getHand().size(), 0);

    }

    @Test
    public void setName() {
        player.setName("michael");
        assertEquals(player.getName(), "michael");

    }

    @Test
    public void addCard(){
        player.addCard(card);
        assertEquals(player.getHand().size(), 1);

    }

}