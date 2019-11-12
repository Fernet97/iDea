package com.example.fernet.idea;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import android.widget.LinearLayout;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;



public class InitialFragment extends Fragment {

    private LinearLayout layout;
    private SwipeButton swipeLogin;
    private SwipeButton swipeRegistrati;
    private CommunicatorInitial communicator;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.initial_fragment, container, false);

        layout = v.findViewById(R.id.autenticazione_layout);
        swipeLogin =  v.findViewById(R.id.Login);
        swipeRegistrati = v.findViewById(R.id.Registrati);

        swipeLogin.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                communicator.respondFromInitial("Login");
            }
        });

        swipeRegistrati.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                communicator.respondFromInitial("Registrazione");
            }
        });


        return v;
    }


    // Comunicatore ************
    public interface CommunicatorInitial {
        public void respondFromInitial(String swipescelto);
    }
    public void setCommunicator(CommunicatorInitial communicator) {
        this.communicator = communicator;
    }
    // *************************

}
