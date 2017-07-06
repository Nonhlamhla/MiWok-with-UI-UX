package com.example.admin.miwok;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if(listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);
        TextView text1TextView = (TextView) listItemView.findViewById(R.id.text1);
        text1TextView.setText(currentWord.getMiwokTranslation());

        TextView text2TextView = (TextView) listItemView.findViewById(R.id.text2);
        text2TextView.setText(currentWord.getDefaultTranslation());

        return listItemView;
        }
    }
