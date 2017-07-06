package com.example.admin.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class Activity5 extends AppCompatActivity {

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
        setContentView(R.layout.activity_5);

      final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("One", "Thihi", R.raw.number_1));
        words.add(new Word("Two", "Mbili", R.raw.number_2));
        words.add(new Word("Three", "Tharu", R.raw.number_3));
        words.add(new Word("Four", "Ina", R.raw.number_4));
        words.add(new Word("Five", "Thanu", R.raw.number_5));
        words.add(new Word("Six", "Rathi", R.raw.number_6));
        words.add(new Word("Seven", "Sumbe", R.raw.number_7));
        words.add(new Word("Eight", "Malo", R.raw.number_8));
        words.add(new Word("Nine", "Tahe", R.raw.number_9));
        words.add(new Word("Ten", "Fumi", R.raw.number_10));



        //FINDS THE ORIGIN OF THE WHOLE LAYOUT
        WordAdapter adapter  = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.numbers_list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                // RELEASE MEDIA PLAYER IF IT CURRENTLY EXISTS BECAUSE WE ARE ABOUT TO
                // PLAY A DIFFERENT SOUND FILE
                releaseMediaPlayer();

                // CREATE A LINK FOR THE AUDIO RESOURCE ASSOCIATED WITH THE CURRENT WORD
                mMediaPlayer = MediaPlayer.create(Activity5.this, word.getmAudioResourceId());

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


        //WHILE LOOP
        // GETS WORDS FROM THE <ArrayList> CONNOTATED BY INDEX WHICH IS AN ARRAY POSITION
        //FOR LOOP IS SHORTER THAN WHILE SO WE USE FOR LOOP
        //PRINTS LOG STATEMENTS
//        while (index<words.size()){
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            activity_5.addView(wordView);
//
//            //UPDATE COUNTER VARIABLE
//            index++;
//
//        //FOR LOOP
//          for (int index = 0; index <words.size(); index++)
//          {
//              TextView wordView = new TextView(this);
//              wordView.setText(words.get(index));
//              activity_5.addView(wordView);



