package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

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

        teamIndia.add(new TeamIndia("Viru", "Batsman",R.drawable.color_red,R.raw.color_red));
        teamIndia.add(new TeamIndia("Sheru", "Batsman",R.drawable.color_black,R.raw.color_black));
        teamIndia.add(new TeamIndia("Sachi", "Batsman",R.drawable.color_brown,R.raw.color_brown));
        teamIndia.add(new TeamIndia("Jaddu", "All ROunder",R.drawable.color_gray,R.raw.color_gray));
        teamIndia.add(new TeamIndia("Zah", "Steamer",R.drawable.color_green,R.raw.color_green));
        teamIndia.add(new TeamIndia("veen", "Steamer",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        teamIndia.add(new TeamIndia("Mahi", "WK",R.drawable.color_white,R.raw.color_white));
        teamIndia.add(new TeamIndia("Bhuvi", "Steamer",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        TeamAdapter Adapter = new TeamAdapter(this, teamIndia,R.color.Indigo);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TeamIndia teamindia = teamIndia.get(position);
                releaseMediaPlayer();
                mediaplayer = MediaPlayer.create(MainActivity2.this,teamindia.getAudioResourceId());
                mediaplayer.start();
                mediaplayer.setOnCompletionListener(completionListener);
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