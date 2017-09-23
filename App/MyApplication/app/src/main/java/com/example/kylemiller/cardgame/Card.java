package com.example.kylemiller.cardgame;

/**
 * Created by kylemiller on 22/09/2017.
 */

public class Card {

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
