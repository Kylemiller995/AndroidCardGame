package com.example.kylemiller.cardgame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 * Created by kylemiller on 22/09/2017.
 */
public class BlackjackDealerTest {
    BlackjackDealer blackjackDealer;
    Card card;
    Participant player;
    Participant player1;


    @Before
    public void setUp(){
        blackjackDealer = new BlackjackDealer(1);
        card = new Card(CardSuit.CLUBS, CardValue.TWO);
        player = new Player("kyle");
        player1 = new Player("bob");
    }



    @Test
    public void populateDeck() {
        assertEquals(blackjackDealer.getDeck().size(), 52);

    }

    @Test
    public void shuffle() {
        assertNotSame(blackjackDealer.getDeck().get(0), card);

    }

    @Test
    public void startingDeal() {
        ArrayList<Participant> players = new ArrayList<>();
        players.add(player);
        players.add(player1);
        blackjackDealer.startingDeal(players);
        assertEquals(players.get(0).getHand().size(), 2);

    }

    @Test
    public void deal() {
        blackjackDealer.deal(player);
        assertEquals(player.getHand().size(), 1);
    }

}