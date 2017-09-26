package com.example.kylemiller.cardgame;

import java.util.ArrayList;

/**
 * Created by kylemiller on 22/09/2017.
 */

public interface Participant {
    ArrayList<Card> getHand();
    void addCard(Card card);
    String getName();
}
