package com.example.kylemiller.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    TextView computerScore;
    TextView congrats;
    TextView scoreHuman;
    TextView computerMessage;
    TextView humanMessage;
    Button home;
    Button play_again;
    TextView bugCatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        home = (Button) findViewById(R.id.home_button);
        computerScore = (TextView) findViewById(R.id.computer_score);
        scoreHuman = (TextView) findViewById(R.id.human_score);
        computerMessage = (TextView) findViewById(R.id.computer_message);
        humanMessage = (TextView) findViewById(R.id.human_message);
        congrats = (TextView) findViewById(R.id.congrats);
        play_again = (Button) findViewById(R.id.home_button);
        bugCatcher = (TextView) findViewById(R.id.bug_catcher);


        Intent intent = getIntent();
        BlackjackGame game = (BlackjackGame) intent.getSerializableExtra("game");

        Participant winner = game.getWinner();
        Participant humanPlayer = game.getGameTable().get(0);
        Participant computerPlayer = game.getGameTable().get(1);

        congrats.setText(winner.getName()+ " wins!");

        computerMessage.setText("The dealer, " + computerPlayer.getName() + "'s, score was");
        computerScore.setText(String.valueOf(game.sumHand(computerPlayer)));
        scoreHuman.setText(String.valueOf(game.sumHand(humanPlayer)));
        bugCatcher.setText(computerPlayer.getHand().get(0).cardNumtoString() + computerPlayer.getHand().get(1).cardNumtoString());
    }

    public void onHomeButtonClicked(View button){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void onPlayAgainButtonClicked(View button){
        Intent intent = new Intent(this, GameSettingsActivity.class);
        startActivity(intent);
    }


}
