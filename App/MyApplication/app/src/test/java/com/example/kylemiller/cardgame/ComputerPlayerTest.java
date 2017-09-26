package com.example.kylemiller.cardgame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kylemiller on 22/09/2017.
 */
public class ComputerPlayerTest {

    ComputerPlayer computerPlayer;

    @Before
    public void setUp(){
        computerPlayer = new ComputerPlayer();
    }



    @Test
    public void getName() {
        ArrayList<String> name = new ArrayList<>();
        name.add(computerPlayer.getName());
        assertEquals(name.size(), 1);
    }

    @Test
    public void getHand() {
        assertEquals(computerPlayer.getHand().size(), 0);

    }

    @Test
    public void canAddCard(){
        Card card = new Card(CardSuit.CLUBS, CardValue.ACE);
        computerPlayer.addCard(card);
        assertEquals(computerPlayer.getHand().size(), 1);
    }

}