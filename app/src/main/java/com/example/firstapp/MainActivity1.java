package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {

    private MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        final ArrayList<TeamIndia> teamIndia = new ArrayList<TeamIndia>();

        teamIndia.add(new TeamIndia("Virat Kohli", "Batsman", R.drawable.number_one, R.raw.number_one));
        teamIndia.add(new TeamIndia("Shewag", "Batsman", R.drawable.number_two, R.raw.number_two));
        teamIndia.add(new TeamIndia("Sachin", "Batsman", R.drawable.number_three, R.raw.number_three));
        teamIndia.add(new TeamIndia("Jadeja", "All ROunder", R.drawable.number_four, R.raw.number_four));
        teamIndia.add(new TeamIndia("Zaheer", "Steamer", R.drawable.number_five, R.raw.number_five));
        teamIndia.add(new TeamIndia("Praveen", "Steamer", R.drawable.number_six, R.raw.number_six));
        teamIndia.add(new TeamIndia("Dhoni", "WK", R.drawable.number_seven, R.raw.number_seven));
        teamIndia.add(new TeamIndia("Bhuvi", "Steamer", R.drawable.number_eight, R.raw.number_eight));
        teamIndia.add(new TeamIndia("Rishabh Pant", "Batsman", R.drawable.number_nine, R.raw.number_nine));
        teamIndia.add(new TeamIndia("Ganguly", "Captain", R.drawable.number_ten, R.raw.number_ten));

        TeamAdapter Adapter = new TeamAdapter(this, teamIndia, R.color.black);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TeamIndia teamindia = teamIndia.get(position);
                mediaplayer = MediaPlayer.create(MainActivity1.this, teamindia.getAudioResourceId());
                mediaplayer.start();
                mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaplayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });

    }

    private void releaseMediaPlayer() {
        if (mediaplayer != null) {
            mediaplayer.release();

            mediaplayer = null;
        }
    }

}