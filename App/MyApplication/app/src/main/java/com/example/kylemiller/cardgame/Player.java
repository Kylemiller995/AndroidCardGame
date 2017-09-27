package com.example.kylemiller.cardgame;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kylemiller on 22/09/2017.
 */

public class Player implements Participant, Serializable{
    String name;
    ArrayList<Card> hand;
    int highScore;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.highScore = highScore;
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

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
