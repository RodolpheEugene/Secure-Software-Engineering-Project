package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    // Declare variables
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // use FindViewById to find buttons in XML file
        loginBtn = (Button) findViewById(R.id.loginButton);

        // launching game menu after clicking login
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // to start next activity
                Intent intent = new Intent(LoginScreen.this, MenuScreen.class);
                startActivity(intent);
            }
        });


    }
}