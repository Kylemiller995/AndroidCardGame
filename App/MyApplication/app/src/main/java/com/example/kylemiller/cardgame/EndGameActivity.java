package com.example.kylemiller.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    TextView computerScore;
//    TextView winningName;
    TextView congrats;
    TextView scoreHuman;
    TextView computerMessage;
    TextView humanMessage;
    Button home;
    Button play_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        home = (Button) findViewById(R.id.home_button);
        computerScore = (TextView) findViewById(R.id.computer_score);
        scoreHuman = (TextView) findViewById(R.id.human_score);

        computerMessage = (TextView) findViewById(R.id.computer_message);
        humanMessage = (TextView) findViewById(R.id.human_message);

//        winningName = (TextView) findViewById(R.id.winning_name);
        congrats = (TextView) findViewById(R.id.congrats);



        Intent intent = getIntent();
        BlackjackGame game = (BlackjackGame) intent.getSerializableExtra("game");

        Participant winner = game.getWinner();
        Participant humanPlayer = game.getGameTable().get(0);
        Participant computerPlayer = game.getGameTable().get(1);

        congrats.setText(winner.getName());

        computerMessage.setText("The dealer, " + computerPlayer.getName() + ", score was");
        computerScore.setText(String.valueOf(game.sumHand(computerPlayer)));
        scoreHuman.setText(String.valueOf(game.sumHand(humanPlayer)));

    }
}
