package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardActivity extends AppCompatActivity {
    FloatingActionButton fabLogo;
    TextView titleTextView;
    ScrollView scrollCards;
    MaterialCardView interiorPlants, exteriorPlants, seasonPlants;
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

        downMove = AnimationUtils.loadAnimation(DashboardActivity.this, R.anim.down_move);
        upMove = AnimationUtils.loadAnimation(DashboardActivity.this, R.anim.up_move);
        fadeIn = AnimationUtils.loadAnimation(DashboardActivity.this, R.anim.fade_in);

        fabLogo.setAnimation(downMove);
        titleTextView.setAnimation(upMove);
        scrollCards.setAnimation(fadeIn);

        interiorPlants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, InteriorPlantsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exteriorPlants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ExteriorPlantsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        seasonPlants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SeasonalPlantsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}