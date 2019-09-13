package com.example.fernet.idea;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class Feed extends Fragment implements View.OnClickListener {

    private ListView posts;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.feed, container, false);

        //Post visualizzati sul feed
        posts = v.findViewById(R.id.posts);
        CustomAdapter customAdapter = new CustomAdapter(v.getContext(), R.layout.list_elem_post, new ArrayList<Post>());

        for (int i=0; i<5; i++) {
            Post c = new Post(4323454, 5672456, "La risata produce una sensazione di benessere attraverso lo stimolo di processi organici vitali; un'emozione che muove gli intestini e il diaframma; in una parola una sensazione di salute ben percepibile da ognuno: in questo modo noi possiamo raggiungere il corpo attraverso l'anima e servirci di quest'ultima come medico del primo", 34, 18, "2015-08-04T10:11:30", new ArrayList<String>());
            customAdapter.add(c);
        }


        posts.setAdapter(customAdapter);

        posts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = posts.getItemAtPosition(position).toString();
                //Fai qualcosa
            }
        });



        return v;
    }


    @Override
    public void onClick(View v) {

    }
}
