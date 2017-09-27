package com.example.kylemiller.cardgame;

import java.util.ArrayList;

/**
 * Created by kylemiller on 22/09/2017.
 */

public interface Dealer {
    void startingDeal(ArrayList<Participant> players);
    void deal(Participant player);
    ArrayList<Card> getDeck();
}
