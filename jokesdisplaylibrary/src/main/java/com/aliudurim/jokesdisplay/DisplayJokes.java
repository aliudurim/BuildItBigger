package com.aliudurim.jokesdisplay;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by DurimAliu on 20/09/15.
 */
public class DisplayJokes extends Activity {

    public static final String JOKE_INTENT_KEY = "JOKE_INTENT_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_jokes);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            TextView jokesView = (TextView) findViewById(R.id.txtDisplayJokes);
            jokesView.setText(extras.getString(JOKE_INTENT_KEY));
        }
    }
}
