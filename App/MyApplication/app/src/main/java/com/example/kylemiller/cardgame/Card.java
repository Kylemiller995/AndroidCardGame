package com.example.kylemiller.cardgame;

import java.io.Serializable;

/**
 * Created by kylemiller on 22/09/2017.
 */

public class Card implements Serializable {

    CardSuit cardSuit;
    CardValue cardValue;

    public Card(CardSuit cardSuit, CardValue cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

}
