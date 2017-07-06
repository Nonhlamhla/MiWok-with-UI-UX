package com.example.admin.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {


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
                setContentView(R.layout.activity_1);

                // INVOKES BACK ARROW
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Hello", "Aa 'female', Ndaa 'male'", R.raw.phrase_1));
        words.add(new Word("Morning", "Ndi macheloni avhudi", R.raw.phrase_2));
        words.add(new Word("Afternoon", "Ndi masiari", R.raw.phrase_3));
        words.add(new Word("Good evening", "Ndi madekwana", R.raw.phrase_4));
        words.add(new Word("Me", "Nne", R.raw.phrase_5));
        words.add(new Word("How are you?", "Vho vuwa hani?", R.raw.phrase_6));
        words.add(new Word("I'am fine, thank you", "Ne ndo takala vhukuma", R.raw.phrase_7));
        words.add(new Word("Good and you?", "Zwavhudi vhone?", R.raw.phrase_8));
        words.add(new Word("Thank you", "Ro livhuwa / Ndo livhuwa", R.raw.phrase_9));
        words.add(new Word("What's your name?", "Dzina lavho ndi nnyi?", R.raw.phrase_10));
        words.add(new Word("My name is...", "Dzina langa ndi...", R.raw.phrase_11));
        words.add(new Word("Goodbye", "Kha vha sale zwavhudi", R.raw.phrase_12));
        words.add(new Word("Dear...", "Ha...'formal letter or email'", R.raw.phrase_13));
        words.add(new Word("Yours Sincerely...", "Wavho a Funeaho", R.raw.phrase_14));
        words.add(new Word("Merry Christmas", "Duvha la mabebo a Murena lavhudi", R.raw.phrase_15));
        words.add(new Word("Season's Greetings", "Ni vhe na nwaha wavhudi", R.raw.phrase_16));


        //FINDS THE ORIGIN OF THE WHOLE LAYOUT
        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.phrases_list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                // RELEASE MEDIA PLAYER IF IT CURRENTLY EXISTS BECAUSE WE ARE ABOUT TO
                // PLAY A DIFFERENT SOUND FILE
                releaseMediaPlayer();

                // CREATE A LINK FOR THE AUDIO RESOURCE ASSOCIATED WITH THE CURRENT WORD
                mMediaPlayer = MediaPlayer.create(Activity1.this, word.getmAudioResourceId());

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