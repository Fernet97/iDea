package com.example.fernet.idea;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

import java.util.ArrayList;

public class RegistrazioneFragment  extends Fragment {

    private CommunicatorRegistrazione communicator;
    private SwipeButton swipeReg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.registrazione, container, false);
        Animation anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fade_in);
        FrameLayout frame = v.findViewById(R.id.frameRegistrazione);
        frame.startAnimation(anim);

        swipeReg =  v.findViewById(R.id.registrati);
        swipeReg.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                communicator.respondFromRegistrazione(new ArrayList<String>());
            }
        });

        return v;
    }


    // Comunicatore ************
    public interface CommunicatorRegistrazione{
        public void respondFromRegistrazione(ArrayList<String> InfoRegistrazione);
    }
    public void setCommunicator(CommunicatorRegistrazione communicator) {
        this.communicator = communicator;
    }
    // *************************

}
