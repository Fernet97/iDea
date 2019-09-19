package com.example.fernet.idea;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;


public class Autenticazione extends AppCompatActivity {

    private LinearLayout layout;
    private SwipeButton swipeLogin;
    private SwipeButton swipeRegistrati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autenticazione);

        swipeLogin =  findViewById(R.id.Login);
        swipeRegistrati = findViewById(R.id.Registrati);
        layout = findViewById(R.id.autenticazione_layout);

        SwipeListener listener= new SwipeListener();
        swipeLogin.setOnStateChangeListener(listener);
        swipeRegistrati.setOnStateChangeListener(listener);
    }


    @Override
    public void onBackPressed() {

            super.onBackPressed();
    }


    class SwipeListener implements OnStateChangeListener {

        @Override
        public void onStateChange(boolean active) {
            Intent intent = new Intent(Autenticazione.this, MainActivity.class);
            startActivity(intent);



            finish();
        }
    }




}








