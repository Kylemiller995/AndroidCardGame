package com.example.kylemiller.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    BlackjackGame game;
    BlackjackDealer dealer;
    Button twistButton;
    Button stickButton;
    TextView output;
    Participant player;
    ImageView dealerCard2;
    ImageView humanCard1;
    ImageView humanCard2;
    ImageView humanCard3;
    ImageView humanCard4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        twistButton = (Button) findViewById(R.id.twist_button);
        stickButton = (Button) findViewById(R.id.stick_button);
        output = (TextView) findViewById(R.id.displayScore);
        dealerCard2 = (ImageView) findViewById(R.id.dealer_card_2);
        humanCard1 = (ImageView) findViewById(R.id.human_card_1);
        humanCard2 = (ImageView) findViewById(R.id.human_card_2);
        humanCard3 = (ImageView) findViewById(R.id.human_card_3);
        humanCard4 = (ImageView) findViewById(R.id.human_card_4);

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
            intent1.putExtra("game", game);
            startActivity(intent1);
        }

        //will be deleted after fix cards and images
        output.setText(String.valueOf(game.sumHand(player)));

    }

    public void onTwistButtonClicked(View button){
        game.playTurn("twist");

        if (game.checkBustAndBlackjack(game.getGameTable().get(0))){
            Intent intent1 = new Intent(this, EndGameActivity.class);
            intent1.putExtra("game", game);
            startActivity(intent1);
        }
        output.setText(String.valueOf(game.sumHand(player)));
    }

    public void onStickButtonClicked(View button){
        game.playTurn("stick");
        Intent intent1 = new Intent(this, EndGameActivity.class);
        intent1.putExtra("game", game);
        startActivity(intent1);
    }

}
