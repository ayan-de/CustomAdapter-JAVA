package com.example.firstapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class TeamAdapter extends ArrayAdapter<TeamIndia> {

    private int colorResourceId;

    public TeamAdapter(Activity context, ArrayList<TeamIndia> teamIndia, int colorresourceid) {
        super(context, 0, teamIndia);
        colorResourceId = colorresourceid;
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

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentPlayer.hasImage()) {
            imageView.setImageResource(currentPlayer.getImage());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);
        
        return listItemView;
    }
}
