package com.davedev.menta.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;

import com.davedev.menta.content.ExteriorPlantsActivity;
import com.davedev.menta.content.FlowersActivity;
import com.davedev.menta.content.InteriorPlantsActivity;
import com.davedev.menta.R;
import com.davedev.menta.content.SeasonalPlantsActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardActivity extends AppCompatActivity {
    FloatingActionButton fabLogo;
    TextView titleTextView;
    ScrollView scrollCards;
    MaterialCardView interiorPlants, exteriorPlants, seasonPlants, cardFlowers;
    Animation downMove, upMove, fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        fabLogo = findViewById(R.id.fabLogo);
        titleTextView = findViewById(R.id.titleTextView);
        scrollCards = findViewById(R.id.scrollCards);
        interiorPlants = findViewById(R.id.cardInterior);
        exteriorPlants = findViewById(R.id.cardExterior);
        seasonPlants = findViewById(R.id.cardSeason);
        cardFlowers = findViewById(R.id.cardFlowers);

        downMove = AnimationUtils.loadAnimation(DashboardActivity.this, R.anim.down_move);
        upMove = AnimationUtils.loadAnimation(DashboardActivity.this, R.anim.up_move);
        fadeIn = AnimationUtils.loadAnimation(DashboardActivity.this, R.anim.fade_in);

        fabLogo.setAnimation(upMove);
        titleTextView.setAnimation(upMove);
        scrollCards.setAnimation(fadeIn);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false);

        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        fabLogo.setOnClickListener(v -> {
            if (isDarkModeOn) {
                // if dark mode is on it
                // will turn it off
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                // it will set isDarkModeOn
                // boolean to false
                editor.putBoolean("isDarkModeOn", false);
                editor.apply();
            }
            else {
                // if dark mode is off
                // it will turn it on
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                // it will set isDarkModeOn
                // boolean to true
                editor.putBoolean("isDarkModeOn", true);
                editor.apply();
            }
        });

        interiorPlants.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, InteriorPlantsActivity.class);
            startActivity(intent);
            finish();
        });

        exteriorPlants.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ExteriorPlantsActivity.class);
            startActivity(intent);
            finish();
        });

        seasonPlants.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, SeasonalPlantsActivity.class);
            startActivity(intent);
            finish();
        });

        cardFlowers.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, FlowersActivity.class);
            startActivity(intent);
            finish();
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}