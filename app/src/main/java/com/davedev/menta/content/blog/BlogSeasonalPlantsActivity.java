package com.davedev.menta.content.blog;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.davedev.menta.R;
import com.davedev.menta.menu.DashboardActivity;

public class BlogSeasonalPlantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_seasonal_plants);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BlogSeasonalPlantsActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}