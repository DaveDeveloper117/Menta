package com.davedev.menta.content.blog;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.davedev.menta.R;
import com.davedev.menta.menu.DashboardActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BlogExteriorPlantsActivity extends AppCompatActivity {

    FloatingActionButton fabBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_exterior_plants);

        fabBack = findViewById(R.id.fabBack);
        fabBack.setOnClickListener(v -> onBackPressed());

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BlogExteriorPlantsActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}