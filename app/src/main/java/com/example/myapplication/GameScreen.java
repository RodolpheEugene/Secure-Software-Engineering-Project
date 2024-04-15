package com.example.myapplication;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameScreen extends AppCompatActivity {
    Button answerChoice;
    int timesWrong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //finding all buttons and TextViews
        Button answerChoice1 = findViewById(R.id.answerChoice1);
        Button answerChoice2 = findViewById(R.id.answerChoice2);
        Button answerChoice3 = findViewById(R.id.answerChoice3);
        Button answerChoice4 = findViewById(R.id.answerChoice4);
        Button submitButton = findViewById(R.id.submitButton);
        Button nextButton = findViewById(R.id.nextButton);
        Button pauseButton = findViewById(R.id.pauseButton);
        ImageButton achievementsButton = findViewById(R.id.achievementsButton);
        ImageButton settingsButton = findViewById(R.id.settingsButton);
        TextView systemPrompt = findViewById(R.id.systemPrompt);

        //setting question number
        TextView questionNumber = findViewById(R.id.questionNumberText);
        questionNumber.setText("Question 1 of 2");

        nextButton.setOnClickListener(e ->{
            Intent intent = new Intent(this, GameScreen2.class);
            startActivity(intent);
        });
        pauseButton.setOnClickListener(e ->{
            Intent intent = new Intent(this, PauseScreen.class);
            startActivity(intent);
        });
        achievementsButton.setOnClickListener(e ->{
            Intent intent = new Intent(this, AchievementsScreen.class);
            startActivity(intent);
        });
        settingsButton.setOnClickListener(e ->{
            Intent intent = new Intent(this, SettingsScreen.class);
            startActivity(intent);
        });

        answerChoice1.setOnClickListener(e ->{
            answerChoice = answerChoice1;
            Toast toast = Toast.makeText(this, "Answer Choice 1 Pressed", Toast.LENGTH_SHORT);
            toast.show();
        });
        answerChoice2.setOnClickListener(e ->{
            answerChoice = answerChoice2;
            Toast toast = Toast.makeText(this, "Answer Choice 2 Pressed", Toast.LENGTH_SHORT);
            toast.show();
        });
        answerChoice3.setOnClickListener(e ->{
            answerChoice = answerChoice3;
            Toast toast = Toast.makeText(this, "Answer Choice 3 Pressed", Toast.LENGTH_SHORT);
            toast.show();
        });
        answerChoice4.setOnClickListener(e ->{
            answerChoice = answerChoice4;;
            Toast toast = Toast.makeText(this, "Answer Choice 4 Pressed", Toast.LENGTH_SHORT);
            toast.show();
        });

        submitButton.setOnClickListener(e ->{
            if(timesWrong == 2 && answerChoice != answerChoice3){
                answerChoice3.setBackgroundColor(Color.GREEN);
                answerChoice.setBackgroundColor(Color.RED);
                answerChoice.setTextColor(Color.WHITE);
                systemPrompt.setText("The correct answer was C. You should always understand what is happening to your data before giving anyone/anything permission to handle it.");
                submitButton.setVisibility(View.GONE);
            }
            else if(answerChoice != answerChoice3){
                timesWrong++;
                answerChoice.setBackgroundColor(Color.RED);
                answerChoice.setTextColor(Color.WHITE);
                systemPrompt.setText("Wrong! Please try again and pick another answer.");
            }
            else{
                answerChoice.setBackgroundColor(Color.GREEN);
                systemPrompt.setText("Correct! You should always understand what is happening to your data before giving anyone/anything permission to handle it.");
                submitButton.setVisibility(View.GONE);
            }
        });


    }
}