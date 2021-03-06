package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.durimaliu.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by DurimAliu on 20/09/15.
 */
public class JokeTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private JokesCallBack jokeListener;

    public JokeTask(JokesCallBack jokeListener) {
        this.jokeListener = jokeListener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    // if using genymotion it seems to have the address of 10.0.3.2 instead of 10.0.2.2
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")

                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.sayHi("name").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        jokeListener.onJokeResult(result);
    }


    public interface JokesCallBack {
        void onJokeResult(String joke);
    }
}
