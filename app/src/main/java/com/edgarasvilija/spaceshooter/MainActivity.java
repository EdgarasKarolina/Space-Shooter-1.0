package com.edgarasvilija.spaceshooter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs;
        SharedPreferences.Editor editor;

        prefs = getSharedPreferences("HiScores", MODE_PRIVATE);

        final TextView textFastestTime = (TextView)findViewById(R.id.textView);

        int bestResult = prefs.getInt("highestScore", 1);
        textFastestTime.setText("Best Result:  " + bestResult);

        //get reference to button in layout
        final Button playButton = (Button)findViewById(R.id.playButton);

        //listen for clicks
        playButton.setOnClickListener(this);
    }

    //here we say what happends when playButton is clicked
    @Override
    public void onClick(View view)
    {

        //Intent object will let us swich between activities
        Intent intent = new Intent(this, GameActivity.class);
        //here we will start the new activity
        startActivity(intent);

        //here we will finish  this(layout) activity
        finish();
    }
}
