package com.example.gymrats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;

public class StartingActivity extends AppCompatActivity {

    private Button btnStartSignIn;
    private Button btnStartSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_starting);

        if (ParseUser.getCurrentUser() != null){
            goMainActivity();
        }

        btnStartSignIn = findViewById(R.id.btnStartSignIn);
        btnStartSignUp = findViewById(R.id.btnStartSignUp);

        btnStartSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartingActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

        btnStartSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartingActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}