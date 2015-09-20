package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.aliudurim.jokesdisplay.DisplayJokes;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
