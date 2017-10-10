package com.example.kylemiller.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button playButton;
    Button highScores;
    Button profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        playButton = (Button) findViewById(R.id.play_button_home);
        profiles = (Button) findViewById(R.id.profiles_button_home);
        highScores = (Button) findViewById(R.id.highscore_button_home);
    }

    public void onPlayButtonClicked(View button){
        Intent intent = new Intent(this, GameSettingsActivity.class);
        startActivity(intent);
    }

    public void onProfileButtonClicked(View button){
        Intent intent = new Intent(this, UserProfileCreationActivity.class);
        startActivity(intent);
    }

    public void onHighScoreButtonClicked(View button){
        Intent intent = new Intent(this, HichScoresActivity.class);
    }



}
