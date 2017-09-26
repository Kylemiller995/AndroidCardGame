package com.example.kylemiller.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    BlackjackGame game;
    BlackjackDealer dealer;
    Button twistButton;
    Button stickButton;
    TextView output;
    Participant player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        twistButton = (Button) findViewById(R.id.twist_button);
        stickButton = (Button) findViewById(R.id.stick_button);
        output = (TextView) findViewById(R.id.displayScore);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int numOfDecks = extras.getInt("decks");
        dealer = new BlackjackDealer(numOfDecks);
        game = new BlackjackGame(dealer);

        player = new Player("Kyle");
        game.sitDownAtTable(player);
        dealer.startingDeal(game.getGameTable());

        if(game.checkBustAndBlackjack(player)){
            Intent intent1 = new Intent(this, EndGameActivity.class);
            intent1.putExtra("player", game);
            startActivity(intent1);
        }
        output.setText(String.valueOf(game.sumHand(player)));
    }

    public void onTwistButtonClicked(View button){
        game.playTurn("twist");
        if (game.checkBustAndBlackjack(game.getGameTable().get(0))){
            Intent intent1 = new Intent(this, EndGameActivity.class);
            intent1.putExtra("player", game);
            startActivity(intent1);
        }

        output.setText(String.valueOf(game.sumHand(player)));
    }


    public void onStickButtonClicked(View button){
        game.playTurn("stick");
        Intent intent1 = new Intent(this, EndGameActivity.class);
        intent1.putExtra("player", game);
        startActivity(intent1);
    }

}
