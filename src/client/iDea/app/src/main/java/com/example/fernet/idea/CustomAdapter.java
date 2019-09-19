package com.example.fernet.idea;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Post> {
    private int resource;
    private LayoutInflater inflater;


    public CustomAdapter(Context context, int resourceId, List<Post> objects) {
            super(context, resourceId, objects);
            resource = resourceId;
            inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
    		if (v == null) {
    			Log.d("DEBUG","Inflating view");
    			v = inflater.inflate(R.layout.list_elem_post, null);
            }

            Post c = getItem(position);
       
			Log.d("DEBUG","contact c="+c);
			
            TextView Data;
           // Data = v.findViewById(R.id.data_post);
        	//Log.d("DEBUG","data="+Data);

            //Data.setText(c.getDateHourBorn().toString());

            return v;
    }
}

