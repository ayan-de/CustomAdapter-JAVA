package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        ArrayList<TeamIndia> teamIndia = new ArrayList<TeamIndia>();

        teamIndia.add(new TeamIndia("Virat Kohli","Batsman",R.drawable.family_daughter));
        teamIndia.add(new TeamIndia("Shewag","Batsman",R.drawable.family_father));
        teamIndia.add(new TeamIndia("Sachin","Batsman",R.drawable.family_grandfather));
        teamIndia.add(new TeamIndia("Jadeja","All ROunder",R.drawable.family_grandmother));
        teamIndia.add(new TeamIndia("Zaheer","Steamer",R.drawable.family_mother));
        teamIndia.add(new TeamIndia("Praveen","Steamer",R.drawable.family_older_brother));
        teamIndia.add(new TeamIndia("Dhoni","WK",R.drawable.family_older_sister));
        teamIndia.add(new TeamIndia("Bhuvi","Steamer",R.drawable.family_son));
        teamIndia.add(new TeamIndia("Rishabh Pant","Batsman",R.drawable.family_younger_brother));
        teamIndia.add(new TeamIndia("Ganguly","Captain",R.drawable.family_younger_sister));

        TeamAdapter Adapter = new TeamAdapter(this,teamIndia);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
    }
}