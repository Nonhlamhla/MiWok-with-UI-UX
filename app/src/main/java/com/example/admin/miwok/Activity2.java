package com.example.admin.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    // CLEANS MEDIA RESOURCES AS SOON AS USER IS DONE
    private MediaPlayer.OnCompletionListener mCompletionListener =  new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // INVOKES BACK ARROW
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("legal", "Mulayo", R.raw.legal_1));
        words.add(new Word("questionnaire", "mbudzisombekanywa", R.raw.legal_2));
        words.add(new Word("marital status", "tshimo tsha vhudzekani", R.raw.legal_3));
        words.add(new Word("single", "u sa dzhiwa", R.raw.legal_4));
        words.add(new Word("relationship", "vhushaka", R.raw.legal_5));
        words.add(new Word("partner", "mufarisi", R.raw.legal_6));
        words.add(new Word("married", "vhingwa", R.raw.legal_7));
        words.add(new Word("separated", "fhandekanaho", R.raw.legal_8));
        words.add(new Word("divorced", "talana", R.raw.legal_9));
        words.add(new Word("widow", "tshilikadzi", R.raw.legal_10));
        words.add(new Word("widower", "munna o felwaho", R.raw.legal_11));
        words.add(new Word("place of birth", "hethu ha mabebo", R.raw.legal_12));
        words.add(new Word("residence", "vhudzulo", R.raw.legal_13));
        words.add(new Word("occupation", "mushumo", R.raw.legal_14));
        words.add(new Word("employed", "hirwaho", R.raw.legal_15));
        words.add(new Word("race", "murafho", R.raw.legal_16));
        words.add(new Word("religion", "vhurereli", R.raw.legal_17));
        words.add(new Word("population group", "lushaka", R.raw.legal_18));
        words.add(new Word("gender", "mbeu", R.raw.legal_19));
        words.add(new Word("investigation", "tsenguludzo", R.raw.legal_20));
        words.add(new Word("plaintiff", "muhweleli", R.raw.legal_21));
        words.add(new Word("resolved case", "fhungoladzwa", R.raw.legal_22));
        words.add(new Word("unresolved case", "fhungo tshayandadzwa", R.raw.legal_23));
        words.add(new Word("proxy", "muimeli", R.raw.legal_24));
        words.add(new Word("vote", "mugaganyo", R.raw.legal_25));



        //FINDS THE ORIGIN OF THE WHOLE LAYOUT
        WordAdapter adapter  = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.legal_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                // RELEASE MEDIA PLAYER IF IT CURRENTLY EXISTS BECAUSE WE ARE ABOUT TO
                // PLAY A DIFFERENT SOUND FILE
                releaseMediaPlayer();

                // CREATE A LINK FOR THE AUDIO RESOURCE ASSOCIATED WITH THE CURRENT WORD
                mMediaPlayer = MediaPlayer.create(Activity2.this, word.getmAudioResourceId());

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
