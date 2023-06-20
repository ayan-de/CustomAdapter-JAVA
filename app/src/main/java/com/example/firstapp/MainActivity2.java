package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ArrayList<TeamIndia> teamIndia = new ArrayList<TeamIndia>();

        teamIndia.add(new TeamIndia("Viru", "Batsman",R.drawable.color_red));
        teamIndia.add(new TeamIndia("Sheru", "Batsman",R.drawable.color_black));
        teamIndia.add(new TeamIndia("Sachi", "Batsman",R.drawable.color_brown));
        teamIndia.add(new TeamIndia("Jaddu", "All ROunder",R.drawable.color_gray));
        teamIndia.add(new TeamIndia("Zah", "Steamer",R.drawable.color_green));
        teamIndia.add(new TeamIndia("veen", "Steamer",R.drawable.color_dusty_yellow));
        teamIndia.add(new TeamIndia("Mahi", "WK",R.drawable.color_white));
        teamIndia.add(new TeamIndia("Bhuvi", "Steamer",R.drawable.color_mustard_yellow));

        TeamAdapter Adapter = new TeamAdapter(this, teamIndia);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);


    }

}