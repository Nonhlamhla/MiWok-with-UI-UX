package com.example.admin.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    // ASSOCIATED WITH THE RELEASE METHOD
    private MediaPlayer.OnCompletionListener mCompletionListener =  new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // INVOKES BACK ARROW
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("January", "Phando", R.raw.month_1));
        words.add(new Word("February", "Luhuhi", R.raw.month_2));
        words.add(new Word("March", "Thafamuhwe", R.raw.month_3));
        words.add(new Word("April", "Lambamai", R.raw.month_4));
        words.add(new Word("May", "Shundunthule", R.raw.month_5));
        words.add(new Word("June", "Fulwi", R.raw.month_6));
        words.add(new Word("July", "Fulwana", R.raw.month_7));
        words.add(new Word("August", "Thangule", R.raw.month_8));
        words.add(new Word("September", "Khubvumedzi", R.raw.month_9));
        words.add(new Word("October", "Tshimedzi", R.raw.month_10));
        words.add(new Word("November", "Lara", R.raw.month_11));
        words.add(new Word("December", "Nyendavhusiku", R.raw.month_12));



        //FINDS THE ORIGIN OF THE WHOLE LAYOUT
        WordAdapter adapter  = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.months_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                // RELEASE MEDIA PLAYER IF IT CURRENTLY EXISTS BECAUSE WE ARE ABOUT TO
                // PLAY A DIFFERENT SOUND FILE
                releaseMediaPlayer();

                // CREATE A LINK FOR THE AUDIO RESOURCE ASSOCIATED WITH THE CURRENT WORD
                mMediaPlayer = MediaPlayer.create(Activity3.this, word.getmAudioResourceId());

                // START THE AUDIO FILE
                mMediaPlayer.start();

                // SETUP A LISTENER ON THE MEDIA PLAYER SO THAT WE CAN STOP AND RELEASE
                // THE MEDIA PLAYER ONCE THE SOUNDS HAVE FINISHED PLAYING
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        // WHEN ACTIVITY IS STOPPED APP WILL RELEASE THE MEDIA PLAYER RESOURCES
        releaseMediaPlayer();
    }
    // CLEANS UP MEDIA FLIES
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
