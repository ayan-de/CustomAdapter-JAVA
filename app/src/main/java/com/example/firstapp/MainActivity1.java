package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {

    private MediaPlayer mediaplayer;

    private AudioManager audiomanager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK) {
                //pause playback
                mediaplayer.pause();
                mediaplayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                //resume playback
                mediaplayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                //stop playback
                releaseMediaPlayer();
            }
        }
    };

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

        //1-start audio focus
        audiomanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


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
                releaseMediaPlayer();
                //2-Request Audio Focus
                int result = audiomanager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaplayer = MediaPlayer.create(MainActivity1.this, teamindia.getAudioResourceId());
                    mediaplayer.start();
                    mediaplayer.setOnCompletionListener(completionListener);
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaplayer != null) {
            mediaplayer.release();

            mediaplayer = null;
            audiomanager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}