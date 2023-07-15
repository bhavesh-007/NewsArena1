package com.example.newsarena;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class sp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(sp.this);
                Intent intent=new Intent(sp.this,MainActivity.class);
                startActivity(intent,activityOptions.toBundle());
                finish();

            }
        },3000);
    }
}