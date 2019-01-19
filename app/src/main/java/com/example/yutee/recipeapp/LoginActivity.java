package com.example.yutee.recipeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText loginmail;
    private EditText loginPass;
    private Button loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);

        loginmail = (EditText)findViewById(R.id.loginMail);
        loginPass = (EditText)findViewById(R.id.loginPassword);
        loginBtn = (Button) findViewById(R.id.loginBtn);
    }

}
