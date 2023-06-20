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

        teamIndia.add(new TeamIndia("Virat Kohli","Batsman",R.drawable.number_one));
        teamIndia.add(new TeamIndia("Shewag","Batsman",R.drawable.number_two));
        teamIndia.add(new TeamIndia("Sachin","Batsman",R.drawable.number_three));
        teamIndia.add(new TeamIndia("Jadeja","All ROunder",R.drawable.number_four));
        teamIndia.add(new TeamIndia("Zaheer","Steamer",R.drawable.number_five));
        teamIndia.add(new TeamIndia("Praveen","Steamer",R.drawable.number_six));
        teamIndia.add(new TeamIndia("Dhoni","WK",R.drawable.number_seven));
        teamIndia.add(new TeamIndia("Bhuvi","Steamer",R.drawable.number_eight));
        teamIndia.add(new TeamIndia("Rishabh Pant","Batsman",R.drawable.number_nine));
        teamIndia.add(new TeamIndia("Ganguly","Captain",R.drawable.number_ten));

        TeamAdapter Adapter = new TeamAdapter(this,teamIndia);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);



    }

}