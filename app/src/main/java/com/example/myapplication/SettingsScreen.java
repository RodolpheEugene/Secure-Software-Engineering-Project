package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsScreen extends AppCompatActivity {

    // Declare variables
     Button settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings_screen);

        // Find the Button
        settingsBtn = (Button) findViewById(R.id.returnButton);

        // Navigate back to game screen
        settingsBtn.setOnClickListener(e ->{
            Intent intent = new Intent(this, GameScreen.class);
            startActivity(intent);
        });


    }
}