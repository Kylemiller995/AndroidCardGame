package com.example.kylemiller.cardgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserProfileCreationActivity extends AppCompatActivity {
    Button saveButton;
    EditText profileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_creation);
        saveButton = (Button) findViewById(R.id.save_name);
        profileName = (EditText) findViewById(R.id.user_profile_name);
    }

    public void onSaveClicked(View button){
        String name = String.valueOf(profileName.getText());
        Player player = new Player(name);

    }




}
