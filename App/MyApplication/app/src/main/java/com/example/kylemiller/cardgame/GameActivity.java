package com.example.kylemiller.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    BlackjackGame game;
    BlackjackDealer dealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int numOfDecks = extras.getInt("decks");
        dealer = new BlackjackDealer(numOfDecks);
        game = new BlackjackGame(dealer);

        Participant player = new Player("Kyle");
        game.sitDownAtTable(player);
        dealer.startingDeal(game.getGameTable());

        if(game.checkBustAndBlackjack(player)){
            Intent intent1 = new Intent(this, EndGameActivity.class);
            intent1.putExtra("player", game);
            startActivity(intent1);
        }

    }

    public void onTwistButtonClicked(){
        game.playTurn("twist");

    }

    public void onStickButtonClicked(){
        game.playTurn("stick");


    }
}
