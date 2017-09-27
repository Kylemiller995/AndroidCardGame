package com.example.kylemiller.cardgame;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kylemiller on 22/09/2017.
 */
public class CardTest {

    Card card;

    @Before
    public void setup(){
        card = new Card(CardSuit.CLUBS, CardValue.TWO);
    }


    @Test
    public void getCardSuit() {
        assertEquals(card.getCardSuit(), CardSuit.CLUBS);

    }

    @Test
    public void getCardValue() {
        assertEquals(card.getCardValue(), CardValue.TWO);

    }

    @Test
    public void getCardNumValue(){
        assertEquals(card.getCardValue().getNumericValue(), 2);
    }

    @Test
    public void cardstring(){
        assertEquals(card.cardSuitToString(), "clubs");
    }

    @Test
    public void cardeurifhwj(){
        assertEquals(card.cardNumtoString(), "2");
    }
}