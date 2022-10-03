package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView logoImageView;
    TextView titleTextView;
    Animation fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Logo Image
        logoImageView = findViewById(R.id.logoImageView);
        //Text Logo
        titleTextView = findViewById(R.id.titleTextView);
        //Animation
        fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);

        //Set Animations
        logoImageView.setAnimation(fadeIn);
        titleTextView.setAnimation(fadeIn);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}