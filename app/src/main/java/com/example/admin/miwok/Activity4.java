package com.example.admin.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {

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
        setContentView(R.layout.activity_4);

        // INVOKES BACK ARROW
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Black", "Mutswu", R.raw.color_1));
        words.add(new Word("White", "Mutshena", R.raw.color_2));
        words.add(new Word("Grey", "Musetha", R.raw.color_3));
        words.add(new Word("Blue", "Lutombo", R.raw.color_4));
        words.add(new Word("Green", "Mudala", R.raw.color_5));
        words.add(new Word("Yellow", "Tada", R.raw.color_6));
        words.add(new Word("Orange", "Swiri", R.raw.color_7));
        words.add(new Word("Red", "Mutswuku", R.raw.color_8));
        words.add(new Word("Maroon", "Meruni", R.raw.color_9));
        words.add(new Word("Brown", "Buraweni", R.raw.color_10));
        words.add(new Word("Pink", "Pinki", R.raw.color_11));




        //FINDS THE ORIGIN OF THE WHOLE LAYOUT
        WordAdapter adapter  = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.colors_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                // RELEASE MEDIA PLAYER IF IT CURRENTLY EXISTS BECAUSE WE ARE ABOUT TO
                // PLAY A DIFFERENT SOUND FILE
                releaseMediaPlayer();

                // CREATE A LINK FOR THE AUDIO RESOURCE ASSOCIATED WITH THE CURRENT WORD
                mMediaPlayer = MediaPlayer.create(Activity4.this, word.getmAudioResourceId());

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
