package com.example.admin.miwok;


public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mAudioResourceId;

    public Word (String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }
    //GET THE DEFAULT TRANSLATION OF THE WORD
    public String getDefaultTranslation(){
        return  mDefaultTranslation;
    }
    //GET THE MIWOK TRANSLATION OF THE WORD
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getmAudioResourceId(){ return mAudioResourceId;}
}
