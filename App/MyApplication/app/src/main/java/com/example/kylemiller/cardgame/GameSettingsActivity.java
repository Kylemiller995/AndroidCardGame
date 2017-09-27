package com.example.kylemiller.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameSettingsActivity extends AppCompatActivity {

    Button dealCardsButton;
    TextView nOfDecksInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);
        dealCardsButton = (Button) findViewById(R.id.startGameButton);
        nOfDecksInput = (TextView) findViewById(R.id.amount_of_decks_input);
    }



    public void onDealCardsButtonClicked(View button){
        Intent intent = new Intent(this, GameActivity.class );
        int decks = Integer.parseInt(nOfDecksInput.getText().toString());
        intent.putExtra("decks", decks);
        startActivity(intent);
    }



}
