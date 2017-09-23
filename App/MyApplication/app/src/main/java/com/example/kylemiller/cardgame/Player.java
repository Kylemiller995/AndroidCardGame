package com.example.kylemiller.cardgame;

import java.util.ArrayList;

/**
 * Created by kylemiller on 22/09/2017.
 */

public class Player implements Participant{
    String name;
    ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCard(Card card){
        hand.add(card);
    }

}
