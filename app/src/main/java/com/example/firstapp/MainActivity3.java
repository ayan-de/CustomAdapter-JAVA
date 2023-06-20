package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        final ArrayList<TeamIndia> teamIndia = new ArrayList<TeamIndia>();

        teamIndia.add(new TeamIndia("Virat Kohli","Batsman",R.drawable.family_daughter,R.raw.family_daughter));
        teamIndia.add(new TeamIndia("Shewag","Batsman",R.drawable.family_father,R.raw.family_father));
        teamIndia.add(new TeamIndia("Sachin","Batsman",R.drawable.family_grandfather,R.raw.family_grandfather));
        teamIndia.add(new TeamIndia("Jadeja","All ROunder",R.drawable.family_grandmother,R.raw.family_grandmother));
        teamIndia.add(new TeamIndia("Zaheer","Steamer",R.drawable.family_mother,R.raw.family_mother));
        teamIndia.add(new TeamIndia("Praveen","Steamer",R.drawable.family_older_brother,R.raw.family_older_brother));
        teamIndia.add(new TeamIndia("Dhoni","WK",R.drawable.family_older_sister,R.raw.family_older_sister));
        teamIndia.add(new TeamIndia("Bhuvi","Steamer",R.drawable.family_son,R.raw.family_son));
        teamIndia.add(new TeamIndia("Rishabh Pant","Batsman",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        teamIndia.add(new TeamIndia("Ganguly","Captain",R.drawable.family_younger_sister,R.raw.family_younger_sister));

        TeamAdapter Adapter = new TeamAdapter(this,teamIndia,R.color.blue);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TeamIndia teamindia = teamIndia.get(position);
                mediaplayer = MediaPlayer.create(MainActivity3.this,teamindia.getAudioResourceId());
                mediaplayer.start();
            }
        });
    }
}