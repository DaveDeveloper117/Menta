package com.davedev.menta.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.davedev.menta.R;
import com.davedev.menta.onboarding.IntroActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    TextView descTextView,  titleTextView, newAccTextView,registerTextView;
    ImageView logoImageView, bgRightImageView, bgLeftImageView;
    TextInputLayout userTextField, passwordTextField, emailTextField, repeatPasswordTextField;
    TextInputEditText nameTextInputEditText, passTextInputEditText, confirmPassTextInputEditText, emailTextInputEditText;
    Button loginButton;
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
        //EditText
        nameTextInputEditText = findViewById(R.id.nameTextInputEditText);
        emailTextInputEditText = findViewById(R.id.emailTextInputEditText);
        passTextInputEditText = findViewById(R.id.passTextInputEditText);
        confirmPassTextInputEditText = findViewById(R.id.confirmPassTextInputEditText);
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

        loginButton.setOnClickListener(view -> validateField());

        registerTextView.setOnClickListener(view -> {
            Intent intent=new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public  void validateField(){
        String name = Objects.requireNonNull(nameTextInputEditText.getText()).toString().trim();
        String email = Objects.requireNonNull(emailTextInputEditText.getText()).toString().trim();
        String password = Objects.requireNonNull(passTextInputEditText.getText()).toString().trim();
        String confirmPassword = Objects.requireNonNull(confirmPassTextInputEditText.getText()).toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //userTextInputEditText.setError("Ingresa un correo válido");
            emailTextField.setError("Ingresa un correo válido");
        } else {
            emailTextField.setError(null);
            emailTextField.setErrorEnabled(false);
        }

        if (name.isEmpty() || !Pattern.compile("[a-z]").matcher(name).find()) {
            //userTextInputEditText.setError("Ingresa un correo válido");
            userTextField.setError("Ingresa un nombre válido");

        } else {
            userTextField.setError(null);
            userTextField.setErrorEnabled(false);
        }

        if (password.isEmpty() || password.length() < 8) {
            // passwordTextInputEditText.setError("Mínimo 8 caracteres");
            passwordTextField.setError("Mínimo 8 caracteres");
        } else if (!Pattern.compile("[0-9]").matcher(password).find()) {
            //passwordTextInputEditText.setError("Mínimo un número");
            passwordTextField.setError("Mínimo un número");
        } else {
            passwordTextField.setError(null);
            passwordTextField.setErrorEnabled(false);
        }

        if (confirmPassword.isEmpty() || !confirmPassword.equals(password)) {
            // passwordTextInputEditText.setError("Mínimo 8 caracteres");
            repeatPasswordTextField.setError("La contraseña no coincide");
        } else {
            repeatPasswordTextField.setError(null);
            repeatPasswordTextField.setErrorEnabled(false);
        }
        startSession(email, password);
    }
    public void startSession(String email, String password){
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(SignUpActivity.this, "Falló el registro", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(SignUpActivity.this, IntroActivity.class);
            startActivity(intent);
            finish();
        }
    }
}