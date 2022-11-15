package com.davedev.menta.content.blog;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.davedev.menta.R;
import com.davedev.menta.menu.DashboardActivity;

public class BlogExteriorPlantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_exterior_plants);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BlogExteriorPlantsActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
    //unos besos en la cola o que
}