package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        ArrayList<TeamIndia> teamIndia = new ArrayList<TeamIndia>();

        teamIndia.add(new TeamIndia("Viru", "Batsman"));
        teamIndia.add(new TeamIndia("Sheru", "Batsman"));
        teamIndia.add(new TeamIndia("Sachi", "Batsman"));
        teamIndia.add(new TeamIndia("Jaddu", "All ROunder"));
        teamIndia.add(new TeamIndia("Zah", "Steamer"));
        teamIndia.add(new TeamIndia("veen", "Steamer"));
        teamIndia.add(new TeamIndia("Mahi", "WK"));
        teamIndia.add(new TeamIndia("Bhuvi", "Steamer"));

        TeamAdapter Adapter = new TeamAdapter(this, teamIndia);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
    }
}