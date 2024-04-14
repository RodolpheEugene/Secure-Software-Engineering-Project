package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameScreen2 extends AppCompatActivity {
    Button answerChoice;
    int timesWrong = 0;
    boolean completed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen_2);

        //finding all buttons and TextViews
        Button answerChoice1 = findViewById(R.id.answerChoice1);
        Button answerChoice2 = findViewById(R.id.answerChoice2);
        Button answerChoice3 = findViewById(R.id.answerChoice3);
        Button answerChoice4 = findViewById(R.id.answerChoice4);
        Button submitButton = findViewById(R.id.submitButton);
        Button prevButton = findViewById(R.id.prevButton);
        Button pauseButton = findViewById(R.id.pauseButton);
        TextView systemPrompt = findViewById(R.id.systemPrompt);

        //setting question number
        TextView questionNumber = findViewById(R.id.questionNumberText);
        questionNumber.setText("Question 2 of 2");

        prevButton.setOnClickListener(e ->{
            getOnBackPressedDispatcher().onBackPressed();
        });
        pauseButton.setOnClickListener(e ->{
            Intent intent = new Intent(this, PauseScreen.class);
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
                completed = true;
                answerChoice3.setBackgroundColor(Color.GREEN);
                answerChoice.setBackgroundColor(Color.RED);
                answerChoice.setTextColor(Color.WHITE);
                systemPrompt.setText("The correct answer was C. You should always understand what is happening to your data before giving anyone/anything permission to handle it.");
            }
            else if(answerChoice != answerChoice3){
                timesWrong++;
                answerChoice.setBackgroundColor(Color.RED);
                answerChoice.setTextColor(Color.WHITE);
                systemPrompt.setText("Wrong! Please try again and pick another answer.");
            }
            else{
                completed = true;
                answerChoice.setBackgroundColor(Color.GREEN);
                systemPrompt.setText("Correct! You should always understand what is happening to your data before giving anyone/anything permission to handle it.");
            }
        });
    }
}