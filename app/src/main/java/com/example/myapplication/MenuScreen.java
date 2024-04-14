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

public class MenuScreen extends AppCompatActivity {

    // Declare variables
    Button newGameBtn, continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_screen);

        // Find the the buttons using findViewById
        newGameBtn = (Button) findViewById(R.id.newGameButton);
        continueBtn = (Button) findViewById(R.id.continueButton);

        // launching game after clicking new game (MODIFY for next screen)
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to start next activity
                Intent intent = new Intent(MenuScreen.this, GameScreen.class);
                startActivity(intent);
            }
        });

        // continue game
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to start next activity
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }
}