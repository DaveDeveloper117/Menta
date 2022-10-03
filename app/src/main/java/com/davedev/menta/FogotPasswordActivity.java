package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FogotPasswordActivity extends AppCompatActivity {
    TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fogot_password);

        registerTextView = findViewById(R.id.registerTextView);

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FogotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}