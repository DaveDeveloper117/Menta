package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.davedev.menta.login.LoginActivity;

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
        //bgImageView = findViewById(R.id.bgImageView);
        //Text Logo
        titleTextView = findViewById(R.id.titleTextView);
        //Animation
        fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        //fadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);

        //Set Animations
        //bgImageView.setAnimation(fadeOut);
        logoImageView.setAnimation(fadeIn);
        titleTextView.setAnimation(fadeIn);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, 1500);
    }
}