package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import jp.wasabeef.blurry.Blurry;

public class LoginActivity extends AppCompatActivity {
    TextView descTextView,  titleTextView, suppTextView, newAccTextView,registerTextView, forgotPassTextView;
    ImageView logoImageView, bgRightImageView, bgLeftImageView;
    TextInputLayout userTextField, passwordTextField;
    RadioButton radioRememberButton;
    Button loginButton;
    FloatingActionButton facebookFab, googleFab, appleFab;
    Animation downMove, upMove, leftMove, rightMove, fadeIn;
    MaterialDivider leftDivider, rightDivider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //TextView
        descTextView = findViewById(R.id.descTextView);
        titleTextView = findViewById(R.id.titleTextView);
        suppTextView = findViewById(R.id.suppTextView);
        newAccTextView = findViewById(R.id.newAccTextView);
        forgotPassTextView = findViewById(R.id.forgotPassTextView);
        registerTextView = findViewById(R.id.registerTextView);
        //ImageView
        logoImageView = findViewById(R.id.logoImageView);
        bgRightImageView = findViewById(R.id.bgRightImageView);
        bgLeftImageView = findViewById(R.id.bgLeftImageView);
        //TextInput
        userTextField = findViewById(R.id.userTextField);
        passwordTextField = findViewById(R.id.passwordTextField);
        //RadioButton
        radioRememberButton = findViewById(R.id.radioRememberButton);
        //Button
        loginButton = findViewById(R.id.loginButton);
        //Dividers
        leftDivider = findViewById(R.id.leftMaterialDivider);
        rightDivider = findViewById(R.id.rightMaterialDivider2);
        //FABs
        facebookFab = findViewById(R.id.facebookFab);
        googleFab = findViewById(R.id.googleFab);
        appleFab = findViewById(R.id.appleFab);
        //Animations
        downMove = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.down_move);
        upMove = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.up_move);
        leftMove = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.left_move);
        rightMove = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.right_move);
        fadeIn = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fade_in);
        //Set Animations
        bgLeftImageView.setAnimation(fadeIn);
        bgRightImageView.setAnimation(fadeIn);
        logoImageView.setAnimation(downMove);
        descTextView.setAnimation(downMove);
        titleTextView.setAnimation(downMove);
        userTextField.setAnimation(leftMove);
        passwordTextField.setAnimation(rightMove);
        radioRememberButton.setAnimation(leftMove);
        forgotPassTextView.setAnimation(rightMove);
        loginButton.setAnimation(upMove);
        suppTextView.setAnimation(upMove);
        facebookFab.setAnimation(leftMove);
        googleFab.setAnimation(upMove);
        appleFab.setAnimation(rightMove);
        newAccTextView.setAnimation(upMove);
        registerTextView.setAnimation(upMove);



        forgotPassTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, FogotPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }
}