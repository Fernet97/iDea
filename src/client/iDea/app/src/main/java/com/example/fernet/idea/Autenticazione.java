package com.example.fernet.idea;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Autenticazione extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autenticazione);
    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();
    }


    public void allaHome(View v){
        Intent intent = new Intent(Autenticazione.this, MainActivity.class);
        startActivity(intent);
    }




}
