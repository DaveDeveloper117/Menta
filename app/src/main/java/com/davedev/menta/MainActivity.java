package com.davedev.menta;

/*
 * Nombre del Proyecto: Menta
 * Desarrollador: David Butrón
 * Perfil de Github: https://github.com/DaveDeveloper117/
 * Diseñador UI/UX: Valam Matías https://github.com/OmniSk8
 * Diseñador UI/UX: Marco Malagon https://github.com/SpartanTerra69
 * Licencia: https://github.com/DaveDeveloper117/Menta/blob/master/LICENSE
 * URL del Repositorio: https://github.com/DaveDeveloper117/Menta.git
 */


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.davedev.menta.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    ImageView logoImageView;
    TextView titleTextView;
    Animation fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Logo Image
        logoImageView = findViewById(R.id.logoImageView);
        //Text Logo
        titleTextView = findViewById(R.id.titleTextView);
        //Animation
        fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        //Set Animations
        logoImageView.setAnimation(fadeIn);
        titleTextView.setAnimation(fadeIn);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, 1500);
    }
}