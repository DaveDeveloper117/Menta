package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {
    TextView descTextView,  titleTextView, suppTextView, newAccTextView,registerTextView, forgotPassTextView;
    ImageView logoImageView, bgRightImageView, bgLeftImageView;
    TextInputLayout userTextField, passwordTextField, emailTextField, repeatPasswordTextField;
    RadioButton radioRememberButton;
    Button loginButton;
    FloatingActionButton facebookFab, googleFab, appleFab;
    Animation downMove, upMove, leftMove, rightMove, fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //TextView
        descTextView = findViewById(R.id.descTextView);
        titleTextView = findViewById(R.id.titleTextView);
        newAccTextView = findViewById(R.id.newAccTextView);
        registerTextView = findViewById(R.id.registerTextView);
        //ImageView
        logoImageView = findViewById(R.id.logoImageView);
        bgRightImageView = findViewById(R.id.bgRightImageView);
        bgLeftImageView = findViewById(R.id.bgLeftImageView);
        //TextInput
        userTextField = findViewById(R.id.userTextField);
        passwordTextField = findViewById(R.id.passwordTextField);
        emailTextField = findViewById(R.id.emailTextField);
        repeatPasswordTextField = findViewById(R.id.repeatPasswordTextField);
        //Button
        loginButton = findViewById(R.id.loginButton);
        //Animations
        downMove = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.down_move);
        upMove = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.up_move);
        leftMove = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.left_move);
        rightMove = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.right_move);
        fadeIn = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.fade_in);
        //Set Animations
        bgLeftImageView.setAnimation(fadeIn);
        bgRightImageView.setAnimation(fadeIn);
        logoImageView.setAnimation(downMove);
        descTextView.setAnimation(downMove);
        titleTextView.setAnimation(downMove);
        userTextField.setAnimation(leftMove);
        passwordTextField.setAnimation(rightMove);
        loginButton.setAnimation(upMove);
        newAccTextView.setAnimation(upMove);
        registerTextView.setAnimation(upMove);
        emailTextField.setAnimation(leftMove);
        repeatPasswordTextField.setAnimation(rightMove);

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}