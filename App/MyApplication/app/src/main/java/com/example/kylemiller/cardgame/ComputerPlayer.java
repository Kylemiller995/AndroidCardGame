package com.example.kylemiller.cardgame;

import java.util.ArrayList;

/**
 * Created by kylemiller on 22/09/2017.
 */

public class ComputerPlayer implements Participant {

    String name;
    ArrayList<Card> hand;
    String choice;

    public ComputerPlayer() {
        this.name = getRandomName();
        this.hand = new ArrayList<>();
        this.choice = "";
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

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}
