package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        ArrayList<TeamIndia> teamIndia = new ArrayList<TeamIndia>();

        teamIndia.add(new TeamIndia("Virat Kohli","Batsman"));
        teamIndia.add(new TeamIndia("Shewag","Batsman"));
        teamIndia.add(new TeamIndia("Sachin","Batsman"));
        teamIndia.add(new TeamIndia("Jadeja","All ROunder"));
        teamIndia.add(new TeamIndia("Zaheer","Steamer"));
        teamIndia.add(new TeamIndia("Praveen","Steamer"));
        teamIndia.add(new TeamIndia("Dhoni","WK"));
        teamIndia.add(new TeamIndia("Bhuvi","Steamer"));
        teamIndia.add(new TeamIndia("Rishabh Pant","Batsman"));
        teamIndia.add(new TeamIndia("Ganguly","Captain"));
        teamIndia.add(new TeamIndia("Ishant Sharma","Steamer"));
        teamIndia.add(new TeamIndia("Chahal","Spinner"));
        teamIndia.add(new TeamIndia("Kumble","Spinner"));

        TeamAdapter Adapter = new TeamAdapter(this,teamIndia);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);



    }

}