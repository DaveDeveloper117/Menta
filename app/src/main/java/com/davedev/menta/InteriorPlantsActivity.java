package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class InteriorPlantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interior_plants);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(InteriorPlantsActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}