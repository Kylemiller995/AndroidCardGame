package com.example.kylemiller.cardgame;

import java.util.ArrayList;

/**
 * Created by kylemiller on 23/09/2017.
 */

public class BlackjackGame implements CardGame {

    ArrayList<Participant> gameTable;
    BlackjackDealer blackjackDealer;


    public BlackjackGame(BlackjackDealer blackjackDealer) {
        this.gameTable = new ArrayList<>();
        this.blackjackDealer = blackjackDealer;
    }

    public ArrayList<Participant> getGameTable() {
        return gameTable;
    }

    public void addPlayer(Participant player){
        gameTable.add(player);
    }

    public Dealer getBlackjackDealer() {
        return blackjackDealer;
    }

    public void playTurn(String choice){
        switch(choice.toLowerCase()){
            case "twist":
                blackjackDealer.deal(gameTable.get(0));
                break;
            case "stick":
                dealerTurn();
                break;
        }

    }


    public void dealerTurn(){
        Participant dealer = gameTable.get(1);
        int handValue = sumHand(dealer);
        while(handValue < 14 ){
            blackjackDealer.deal(dealer);
            handValue += sumHand(dealer);
        }
    }

    public int sumHand(Participant player){
       ArrayList<Card> hand = player.getHand();
        int sum = 0;
        for(Card card: hand){
            sum += card.getCardValue().getNumericValue();
        }
        return sum;
    }

    public Participant getWinner(){
        int playerHandValue = sumHand(gameTable.get(0));
        int dealerHandValue = sumHand(gameTable.get(1));
        if( playerHandValue <= dealerHandValue){
            return gameTable.get(1);
        }
        else return gameTable.get(0);
    }

    public boolean checkBust(Participant player){
        if( sumHand(player) >=22){
            return true;
        }
        else return false;
    }


    public Participant checkBlackjack(){
        for(Participant player: gameTable){
            int handValueSum = sumHand(player);
            if(handValueSum == 21 || player.getHand().size() >= 5){
                return player;
            }
        }
        return null;
    }



}










