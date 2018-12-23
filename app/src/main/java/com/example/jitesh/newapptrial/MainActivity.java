package com.example.jitesh.newapptrial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * ......IT is function which executes after "Start Game" is clicked....
     */
    public void play_frogger(View view){
        Log.d("button","button clicked");
        Intent play=new Intent(this,GameActivity.class);
        startActivity(play);


    }
}
