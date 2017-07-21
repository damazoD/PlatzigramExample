package com.rodrigo.damazod.platzigram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rodrigo.damazod.platzigram.view.ContainerActivity;
import com.rodrigo.damazod.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View v){
        startActivity(new Intent(this,CreateAccountActivity.class));
    }

    public void login(View v){
        startActivity(new Intent(this,ContainerActivity.class));
    }
}
