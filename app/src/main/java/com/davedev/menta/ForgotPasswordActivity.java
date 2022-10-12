package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {
    TextView descTextView,  titleTextView, suppTextView, newAccTextView,registerTextView, forgotPassTextView;
    ImageView logoImageView, bgRightImageView, bgLeftImageView;
    TextInputLayout userTextField;
    TextInputEditText emailTextInputEditText;
    Button loginButton;
    Animation downMove, upMove, leftMove, rightMove, fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        //TextView
        descTextView = findViewById(R.id.descTextView);
        titleTextView = findViewById(R.id.titleTextView);
        newAccTextView = findViewById(R.id.newAccTextView);
        registerTextView = findViewById(R.id.registerTextView);
        //ImageView
        logoImageView = findViewById(R.id.logoImageView);
        bgRightImageView = findViewById(R.id.bgRightImageView);
        bgLeftImageView = findViewById(R.id.bgLeftImageView);
        //EditText
        emailTextInputEditText = findViewById(R.id.emailTextInputEditText);
        //TextInput
        userTextField = findViewById(R.id.userTextField);
        //Button
        loginButton = findViewById(R.id.loginButton);
        //Animations
        downMove = AnimationUtils.loadAnimation(ForgotPasswordActivity.this, R.anim.down_move);
        upMove = AnimationUtils.loadAnimation(ForgotPasswordActivity.this, R.anim.up_move);
        leftMove = AnimationUtils.loadAnimation(ForgotPasswordActivity.this, R.anim.left_move);
        rightMove = AnimationUtils.loadAnimation(ForgotPasswordActivity.this, R.anim.right_move);
        fadeIn = AnimationUtils.loadAnimation(ForgotPasswordActivity.this, R.anim.fade_in);
        //Set Animations
        bgLeftImageView.setAnimation(fadeIn);
        bgRightImageView.setAnimation(fadeIn);
        logoImageView.setAnimation(downMove);
        descTextView.setAnimation(downMove);
        titleTextView.setAnimation(downMove);
        userTextField.setAnimation(leftMove);
        loginButton.setAnimation(upMove);
        newAccTextView.setAnimation(upMove);
        registerTextView.setAnimation(upMove);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateField();
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public  void validateField(){
        String email = Objects.requireNonNull(emailTextInputEditText.getText()).toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //userTextInputEditText.setError("Ingresa un correo válido");
            userTextField.setError("Ingresa un correo válido");

        } else {
            userTextField.setError(null);
            userTextField.setErrorEnabled(false);
        }

    }
}