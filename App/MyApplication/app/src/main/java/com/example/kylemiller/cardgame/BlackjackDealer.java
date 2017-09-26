package com.example.kylemiller.cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kylemiller on 22/09/2017.
 */

public class BlackjackDealer implements Dealer {

    int amountOfDecks;
    ArrayList<Card> deck;


    public BlackjackDealer(int amountOfDecks) {
        this.amountOfDecks = amountOfDecks;
        this.deck = populateDeck(amountOfDecks);
    }

    public ArrayList<Card> populateDeck(int amountOfDecks){
        ArrayList<Card> localDeck = new ArrayList<>();
        for(int i = 0; i < amountOfDecks; i++){
            for(CardSuit suit: CardSuit.values()){
                for(CardValue value: CardValue.values()){
                    Card card = new Card(suit, value);
                    localDeck.add(card);
                }
            }
        }
        Collections.shuffle(localDeck);
        return localDeck;
    }

    public void startingDeal(ArrayList<Participant> players) {
        for(Participant player: players){
            for(int i = 0; i < 2 ; i++){
                player.addCard(deck.remove(0));
            }
        }
    }

    public void deal(Participant player){
        player.addCard(deck.remove(0));
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }



}


