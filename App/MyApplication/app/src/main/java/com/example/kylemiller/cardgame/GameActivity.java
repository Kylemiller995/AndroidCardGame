package com.example.kylemiller.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class GameActivity extends AppCompatActivity {

    BlackjackGame game;
    BlackjackDealer dealer;
    Button twistButton;
    Button stickButton;
    Participant player;


    ImageView human_card1_suit;
    ImageView human_card2_suit;
    ImageView human_card3_suit;
    ImageView human_card4_suit;
    ImageView dealer_card2_suit;

    TextView human_card1_num;
    TextView human_card2_num;
    TextView human_card3_num;
    TextView human_card4_num;
    TextView dealer_card2_num;

    ImageView human_card_3;
    ImageView human_card_4;

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        twistButton = (Button) findViewById(R.id.twist_button);
        stickButton = (Button) findViewById(R.id.stick_button);

        human_card_3 = (ImageView) findViewById(R.id.human_card_3);
        human_card_4 = (ImageView) findViewById(R.id.human_card_4);

        human_card1_suit = (ImageView) findViewById(R.id.human_card1_suit);
        human_card2_suit = (ImageView) findViewById(R.id.human_card2_suit);
        human_card3_suit = (ImageView) findViewById(R.id.human_card3_suit);
        human_card4_suit = (ImageView) findViewById(R.id.human_card4_suit);
        dealer_card2_suit = (ImageView) findViewById(R.id.dealer_card2_suit);

        human_card1_num = (TextView) findViewById(R.id.human_card1_num);
        human_card2_num = (TextView) findViewById(R.id.human_card2_num);
        human_card3_num = (TextView) findViewById(R.id.human_card3_num);
        human_card4_num = (TextView) findViewById(R.id.human_card4_num);
        dealer_card2_num = (TextView) findViewById(R.id.dealer_card2_num);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int numOfDecks = extras.getInt("decks");

        dealer = new BlackjackDealer(numOfDecks);
        game = new BlackjackGame(dealer);
        player = new Player("Kyle");
        game.sitDownAtTable(player);
        dealer.startingDeal(game.getGameTable());

        HashMap<CardSuit, String> setUpSuit = new HashMap<>();
        setUpSuit.put(CardSuit.CLUBS, "@drawable/clubs");
        setUpSuit.put(CardSuit.HEARTS, "@drawable/hearts");
        setUpSuit.put(CardSuit.DIAMONDS, "@drawable/diamonds");
        setUpSuit.put(CardSuit.SPADES, "@drawable/spades");

        HashMap<CardValue, String> setUpValue = new HashMap<>();
        setUpValue.put(CardValue.TWO, "2");
        setUpValue.put(CardValue.THREE, "3");
        setUpValue.put(CardValue.FOUR, "4");
        setUpValue.put(CardValue.FIVE, "5");
        setUpValue.put(CardValue.SIX, "6");
        setUpValue.put(CardValue.SEVEN, "7");
        setUpValue.put(CardValue.EIGHT, "8");
        setUpValue.put(CardValue.NINE, "9");
        setUpValue.put(CardValue.TEN, "10");
        setUpValue.put(CardValue.JACK, "J");
        setUpValue.put(CardValue.QUEEN, "Q");
        setUpValue.put(CardValue.KING, "K");
        setUpValue.put(CardValue.ACE, "A");

        int humanCard1Suit = getResources().getIdentifier(setUpSuit.get(game.getGameTable().get(0).getHand().get(0).getCardSuit()), null, getPackageName());
        human_card1_suit.setImageResource(humanCard1Suit);
        human_card1_num.setText(setUpValue.get(game.getGameTable().get(0).getHand().get(0).getCardValue()));

        int humanCard2Suit = getResources().getIdentifier(setUpSuit.get(game.getGameTable().get(0).getHand().get(1).getCardSuit()), null, getPackageName());
        human_card2_suit.setImageResource(humanCard2Suit);
        human_card2_num.setText(setUpValue.get(game.getGameTable().get(0).getHand().get(1).getCardValue()));

        int dealerCard2Suit = getResources().getIdentifier(setUpSuit.get(game.getGameTable().get(1).getHand().get(1).getCardSuit()), null, getPackageName());
        dealer_card2_suit.setImageResource(dealerCard2Suit);
        dealer_card2_num.setText(setUpValue.get(game.getGameTable().get(1).getHand().get(1).getCardValue()));

        Card card3 = game.getBlackjackDealer().getDeck().get(0);
        Card card4 = game.getBlackjackDealer().getDeck().get(1);

        int card3suit = getResources().getIdentifier(setUpSuit.get(card3.getCardSuit()),null, getPackageName());
        human_card3_suit.setImageResource(card3suit);
        human_card3_num.setText(setUpValue.get(card3.getCardValue()));

        int card4suit = getResources().getIdentifier(setUpSuit.get(card4.getCardSuit()),null, getPackageName());
        human_card4_suit.setImageResource(card4suit);
        human_card4_num.setText(setUpValue.get(card4.getCardValue()));

//        if(game.checkBustAndBlackjack(player)){
//            Intent intent1 = new Intent(this, EndGameActivity.class);
//            intent1.putExtra("game", game);
//            startActivity(intent1);
//        }
        counter = 0;
        human_card3_suit.setVisibility(View.INVISIBLE);
        human_card3_num.setVisibility(View.INVISIBLE);
        human_card_3.setVisibility(View.INVISIBLE);

        human_card4_suit.setVisibility(View.INVISIBLE);
        human_card4_num.setVisibility(View.INVISIBLE);
        human_card_4.setVisibility(View.INVISIBLE);

    }

    public void onTwistButtonClicked(View button){
        game.playTurn("twist");
        if (game.checkBust(game.getGameTable().get(0))){
            Intent intent1 = new Intent(this, EndGameActivity.class);
            intent1.putExtra("game", game);
            startActivity(intent1);
        }

        human_card3_suit.setVisibility(View.VISIBLE);
        human_card3_num.setVisibility(View.VISIBLE);
        human_card_3.setVisibility(View.VISIBLE);

        if( counter == 1){
            human_card4_suit.setVisibility(View.VISIBLE);
            human_card4_num.setVisibility(View.VISIBLE);
            human_card_4.setVisibility(View.VISIBLE);

        }
        counter += 1;
    }

    public void onStickButtonClicked(View button){
        game.playTurn("stick");
        Intent intent1 = new Intent(this, EndGameActivity.class);
        intent1.putExtra("game", game);
        startActivity(intent1);
    }


}
