package com.example.yutee.recipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogIn();

            }
        });
    }

    public void doLogIn(){
        if(!validate()) {
            Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    public boolean validate() {

        String inputMail = loginmail.getText().toString();
        String inPutPassWord = loginPass.getText().toString();


        if (inputMail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(inputMail).matches()) {

            loginmail.setError("Invalid email");
            return false;
        }

        if (inPutPassWord.isEmpty() || inPutPassWord.length() < 4 || inPutPassWord.equals(" ")) {

            loginPass.setError("It has to be alphanumeric character");
            return false;
        }

        return true;


    }


}


