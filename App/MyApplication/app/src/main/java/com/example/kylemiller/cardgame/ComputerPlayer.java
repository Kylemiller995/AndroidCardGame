package com.example.kylemiller.cardgame;

import java.util.ArrayList;

/**
 * Created by kylemiller on 22/09/2017.
 */

public class ComputerPlayer implements Participant {

    String name;
    ArrayList<Card> hand;

    public ComputerPlayer() {
        this.name = getRandomName();
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getRandomName(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Jay");
        names.add("Harrison");
        names.add("Craig");
        names.add("Alex");
        names.add("Rick");
        names.add("Stewart");
        String randomName = names.get(RandomNumberGenerator.genRanNum(names.size()));
        return randomName;
    }

    public void addCard(Card card){
        hand.add(card);
    }

}
