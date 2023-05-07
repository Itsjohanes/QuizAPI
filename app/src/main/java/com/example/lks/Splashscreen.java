package com.example.lks;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Splashscreen extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        imageView = findViewById(R.id.imageView2);

        Glide.with(getApplicationContext()).load(R.drawable.news_avd_v02).into(imageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splashscreen.this, LoginActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 4500);
    }
}