package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PauseScreen extends AppCompatActivity {

    // Declare variables
    Button resumeButton, quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pause_screen);

        // Find the the buttons using findViewById
        resumeButton = (Button) findViewById(R.id.resumeButton);
        quitButton = (Button) findViewById(R.id.quitButton);

        // launching game after clicking new game (MODIFY for next screen)
        resumeButton.setOnClickListener(e -> {
                getOnBackPressedDispatcher().onBackPressed();
        });

        // continue game
        quitButton.setOnClickListener(e ->{
                Intent intent = new Intent(this, MenuScreen.class);
                startActivity(intent);
        });
    }
}