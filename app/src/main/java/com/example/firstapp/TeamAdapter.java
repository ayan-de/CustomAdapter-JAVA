package com.example.firstapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TeamAdapter extends ArrayAdapter<TeamIndia> {

    public TeamAdapter(Activity context, ArrayList<TeamIndia> teamIndia)
    {
        super(context,0,teamIndia);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TeamIndia currentPlayer = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);

        nameTextView.setText(currentPlayer.getName());


        TextView roleTextView = (TextView) listItemView.findViewById(R.id.role);

        roleTextView.setText(currentPlayer.getRole());

        return listItemView;
    }
}
