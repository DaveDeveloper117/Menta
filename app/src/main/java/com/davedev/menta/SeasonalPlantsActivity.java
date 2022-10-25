package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SeasonalPlantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonal_plants);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SeasonalPlantsActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}