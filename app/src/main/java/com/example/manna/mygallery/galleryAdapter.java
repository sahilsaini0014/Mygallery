package com.example.manna.mygallery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class galleryAdapter extends ArrayAdapter<Integer> {


    private Context context;
    private Integer[] resources;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){

            convertView=new ImageView(getContext());
        }

        ((ImageView)convertView).setImageResource(getItem(position));



        return convertView;
    }

    public galleryAdapter(@NonNull Context context, int resource, @NonNull Integer[] objects) {
        super(context, resource, objects);
        resources=objects;
        context=context;






    }

  }
