package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.inschlag.jokedisplay.Constants;
import com.inschlag.jokedisplay.JokeDisplayActivity;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        try {
            // Get a joke from the GCE module
            String joke = new EndpointAsyncTask().execute().get();

            if(joke != null && !joke.isEmpty()){
                // Call the Android lib 'jokedisplay' to show a joke
                Intent displayJoke = new Intent(this, JokeDisplayActivity.class);
                displayJoke.putExtra(Constants.KEY_JOKE, joke);
                startActivity(displayJoke);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
