package com.example.kylemiller.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    TextView computerScore;
    TextView winningName;
    TextView congrats;
    TextView scoreHuman;
    TextView scoreComputer;
    Button home;
    Button play_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        home = (Button) findViewById(R.id.home_button);
        computerScore = (TextView) findViewById(R.id.computer_score);
        scoreHuman = (TextView) findViewById(R.id.human_output_score);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        BlackjackGame game = (BlackjackGame) intent.getSerializableExtra("game");

        Participant winner = game.getWinner();
        Participant humanPlayer = game.getGameTable().get(0);
        Participant computerPlayer = game.getGameTable().get(1);

        computerScore.setText(String.valueOf(game.sumHand(humanPlayer)));
        scoreHuman.setText(String.valueOf(game.sumHand(computerPlayer)));

    }
}
