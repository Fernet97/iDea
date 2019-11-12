package com.example.fernet.idea;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import android.app.Fragment;

import java.util.ArrayList;


public class Autenticazione extends AppCompatActivity implements  InitialFragment.CommunicatorInitial, LoginFragment.CommunicatorLogin, RegistrazioneFragment.CommunicatorRegistrazione {

    private Animation anim;
    private Fragment initial;
    private boolean  initialCaricata;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autenticazione);

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        // Frammento iniziale
        initial = new InitialFragment();
        ft.add(R.id.frame, initial, "initial");
        ((InitialFragment) initial).setCommunicator(this);
        ft.commit();
        initialCaricata = true;
    }

    @Override
    public void onBackPressed() {
        if(initialCaricata) super.onBackPressed();
        else {
            //Ripristina il frame iniziale
            initial = new InitialFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.frame, initial);
            ((InitialFragment) initial).setCommunicator(this);
            fragmentTransaction.commit();

            //Animazione in entrata
            FrameLayout frame = findViewById(R.id.frame);
            anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            frame.startAnimation(anim);
            initialCaricata = true;
        }
    }

    //Risposta dal frammento initiale che mi dice quale swipe ho scelto
    @Override
    public void respondFromInitial(final String swipescelto) {
        anim = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Fragment fr = null;
                //replacament con fragment login
                if(swipescelto.equals("Login")) {
                    fr = new LoginFragment();
                    ((LoginFragment) fr).setCommunicator(Autenticazione.this);
                }

                //replacement con fragment Registrazione
                if(swipescelto.equals("Registrazione")){
                    fr = new RegistrazioneFragment();
                    ((RegistrazioneFragment) fr).setCommunicator(Autenticazione.this);
                }

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.frame, fr);
                fragmentTransaction.commit();
                initialCaricata = false;
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        frame = findViewById(R.id.frame);
        frame.startAnimation(anim);
    }

    //Risposta dal frammento login dà le info inserite del login
    @Override
    public void respondFromLogin(ArrayList<String> InfoLogin) {
        //Prendi info poi:
        anim = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        frame.startAnimation(anim);
        Intent intent = new Intent(Autenticazione.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Risposta dal frammento login dà le info inserite della registrazione
    @Override
    public void respondFromRegistrazione(ArrayList<String> InfoRegistrazione) {
        //Prendi info poi:
        anim = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        frame.startAnimation(anim);
        Intent intent = new Intent(Autenticazione.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}






