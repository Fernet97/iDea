package com.example.fernet.idea;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

import java.util.ArrayList;

public class LoginFragment extends Fragment {

    private CommunicatorLogin communicator;
    private SwipeButton swipeAccedi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login, container, false);
        Animation anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fade_in);
        FrameLayout frame = v.findViewById(R.id.frameLogin);
        frame.startAnimation(anim);

        swipeAccedi =  v.findViewById(R.id.Accedi);
        swipeAccedi.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                communicator.respondFromLogin(new ArrayList<String>());
            }
        });


        return v;
    }

    // Comunicatore ************
    public interface CommunicatorLogin{
        public void respondFromLogin(ArrayList<String> InfoLogin);
    }
    public void setCommunicator(CommunicatorLogin communicator) {
        this.communicator = communicator;
    }
    // *************************


}
