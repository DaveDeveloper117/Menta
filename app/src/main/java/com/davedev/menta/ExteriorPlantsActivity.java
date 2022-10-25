package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ExteriorPlantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exterior_plants);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ExteriorPlantsActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}