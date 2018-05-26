package com.inschlag.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        TextView textView = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey(Constants.KEY_JOKE)){
            textView.setText(bundle.getString(Constants.KEY_JOKE));
        }
    }
}
