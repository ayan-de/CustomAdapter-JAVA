package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    private MediaPlayer mediaplayer;

    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaplayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        final ArrayList<TeamIndia> teamIndia = new ArrayList<TeamIndia>();

        teamIndia.add(new TeamIndia("Viru", "Batsman",R.raw.phrase_are_you_coming));
        teamIndia.add(new TeamIndia("Sheru", "Batsman",R.raw.phrase_are_you_coming));
        teamIndia.add(new TeamIndia("Sachi", "Batsman",R.raw.phrase_are_you_coming));
        teamIndia.add(new TeamIndia("Jaddu", "All ROunder",R.raw.phrase_are_you_coming));
        teamIndia.add(new TeamIndia("Zah", "Steamer",R.raw.phrase_are_you_coming));
        teamIndia.add(new TeamIndia("veen", "Steamer",R.raw.phrase_are_you_coming));
        teamIndia.add(new TeamIndia("Mahi", "WK",R.raw.phrase_are_you_coming));
        teamIndia.add(new TeamIndia("Bhuvi", "Steamer",R.raw.phrase_are_you_coming));

        TeamAdapter Adapter = new TeamAdapter(this, teamIndia,R.color.green);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TeamIndia teamindia = teamIndia.get(position);
                releaseMediaPlayer();
                mediaplayer = MediaPlayer.create(MainActivity4.this,teamindia.getAudioResourceId());
                mediaplayer.start();
                mediaplayer.setOnCompletionListener(completionListener);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaplayer != null) {
            mediaplayer.release();

            mediaplayer = null;
        }
    }
}