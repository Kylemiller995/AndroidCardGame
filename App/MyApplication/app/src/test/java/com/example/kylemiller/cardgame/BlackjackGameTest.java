package com.example.kylemiller.cardgame;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kylemiller on 25/09/2017.
 */
public class BlackjackGameTest {

    BlackjackGame blackjack;
    BlackjackDealer blackjackDealer;
    Participant humanPlayer;
    Participant computerPlayer;

    @Before
    public void setUp(){
        blackjackDealer = new BlackjackDealer(1);
        blackjack = new BlackjackGame(blackjackDealer);
        humanPlayer = new Player("kyle");
        computerPlayer = new ComputerPlayer();

    }

    @Test
    public void getGameTable() {
        assertEquals(blackjack.getGameTable().size(), 0);
    }


    @Test
    public void canAddPlayer(){
        blackjack.addPlayer(humanPlayer);
        assertEquals(blackjack.getGameTable().size(), 1);

    }
    @Test
    public void checkBlackjack() {
        blackjackDealer.deal(humanPlayer);
        blackjackDealer.deal(humanPlayer);
        blackjackDealer.deal(humanPlayer);
        blackjackDealer.deal(humanPlayer);
        blackjackDealer.deal(humanPlayer);
        blackjack.addPlayer(humanPlayer);
        assertEquals(blackjack.checkBlackjack(), humanPlayer);
    }

    @Test
    public void addPlayer() {
        blackjack.addPlayer(humanPlayer);
        assertEquals(blackjack.getGameTable().size(), 1);
    }

    @Test
    public void getBlackjackDealer() {
        assertEquals(blackjack.getBlackjackDealer(), blackjackDealer);

    }

    @Test
    public void playTurn() {
        blackjack.addPlayer(humanPlayer);
        blackjack.addPlayer(computerPlayer);
        blackjack.playTurn("twist");
        blackjack.playTurn("twist");
        assertEquals(humanPlayer.getHand().size(), 2);
    }

    @Test
    public void dealerGetsCards() {
        blackjack.addPlayer(humanPlayer);
        blackjack.addPlayer(computerPlayer);
        blackjackDealer.startingDeal(blackjack.getGameTable());
        blackjack.playTurn("stick");
        assertEquals(blackjack.getGameTable().get(1).getHand().size(), 2 );
//needs work
    }

    @Test
    public void dealerTurnTest(){
        blackjack.addPlayer(humanPlayer);
        blackjack.addPlayer(computerPlayer);
        Card card1 = new Card(CardSuit.CLUBS,CardValue.EIGHT);
        Card card2 = new Card(CardSuit.CLUBS,CardValue.THREE);
        computerPlayer.getHand().add(card1);
        computerPlayer.getHand().add(card2);
//        blackjack.blackjackDealer.getDeck().add(new Card(CardSuit.CLUBS, CardValue.FOUR));
        blackjack.playTurn("stick");
        assertEquals(blackjack.getGameTable().get(1).getHand().size(), 3);


    }

    @Test
    public void sumHand() {
        Card card1 = new Card(CardSuit.CLUBS,CardValue.EIGHT);
        Card card2 = new Card(CardSuit.CLUBS,CardValue.EIGHT);
        humanPlayer.getHand().add(card1);
        humanPlayer.getHand().add(card2);
        assertEquals(blackjack.sumHand(humanPlayer), 16);

    }

    @Test
    public void getWinner() {
        blackjack.addPlayer(humanPlayer);
        blackjack.addPlayer(computerPlayer);
        Card card1 = new Card(CardSuit.CLUBS,CardValue.EIGHT);
        Card card2 = new Card(CardSuit.CLUBS,CardValue.THREE);
        humanPlayer.getHand().add(card1);
        humanPlayer.getHand().add(card2);
        Card card3 = new Card(CardSuit.CLUBS,CardValue.FIVE);
        Card card4 = new Card(CardSuit.CLUBS,CardValue.QUEEN);
        computerPlayer.getHand().add(card3);
        computerPlayer.getHand().add(card4);
        assertEquals(blackjack.getWinner(), computerPlayer);


    }

    @Test
    public void checkBust(){
        blackjack.addPlayer(humanPlayer);
        Card card1 = new Card(CardSuit.CLUBS,CardValue.EIGHT);
        Card card2 = new Card(CardSuit.CLUBS,CardValue.EIGHT);
        Card card3 = new Card(CardSuit.CLUBS,CardValue.EIGHT);
        Card card4 = new Card(CardSuit.CLUBS,CardValue.THREE);
        humanPlayer.getHand().add(card3);
        humanPlayer.getHand().add(card4);
        blackjack.checkBust(humanPlayer);



    }


}