package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardActivity extends AppCompatActivity {
    FloatingActionButton fabLogo;
    TextView titleTextView;
    ScrollView scrollCards;
    MaterialCardView interiorPlants, exteriorPlants, seasonPlants;

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
    }
}