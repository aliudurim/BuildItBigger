package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.aliudurim.jokesdisplay.DisplayJokes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAd();
    }


    private void setupAd() {
        AdView mAdView = (AdView) findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    public void tellJoke(View view) {
        new JokeTask(new JokeRetrievalHandler()).execute();
    }

    private class JokeRetrievalHandler implements JokeTask.JokesCallBack {


        @Override
        public void onJokeResult(String joke) {
            Intent intent = new Intent(MainActivity.this, DisplayJokes.class);
            intent.putExtra(DisplayJokes.JOKE_INTENT_KEY, joke);
            startActivity(intent);
        }
    }

}
