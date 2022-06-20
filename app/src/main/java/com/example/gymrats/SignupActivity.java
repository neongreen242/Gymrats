package com.example.gymrats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    public static final String TAG = "SignUpActivity";

    private EditText newUsername;
    private EditText newPassword;
    private Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        newUsername = findViewById(R.id.newUsername);
        newPassword = findViewById(R.id.newPassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick Register Button");

                String username = newUsername.getText().toString();
                String password = newPassword.getText().toString();

                ParseUser user = new ParseUser();

                //Sets field to be created for user
                user.setUsername(username);
                user.setPassword(password);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null){
                            Intent i = new Intent(SignupActivity.this , LoginActivity.class);
                            startActivity(i);
                        }else{
                            Log.e(TAG,"Signup was unsuccessful",e);
                            return;
                        }
                    }
                });


            }
        });
    }
}