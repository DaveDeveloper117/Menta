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
import android.widget.Toast;

import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    TextView descTextView,  titleTextView, suppTextView, newAccTextView,registerTextView, forgotPassTextView;
    ImageView logoImageView, bgRightImageView, bgLeftImageView;
    TextInputLayout userTextField, passwordTextField;
    TextInputEditText userTextInputEditText, passwordTextInputEditText;
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
        //EditText
        userTextInputEditText = findViewById(R.id.userTextInputEditText);
        passwordTextInputEditText = findViewById(R.id.passwordTextInputEditText);
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
        leftDivider.setAnimation(leftMove);
        rightDivider.setAnimation(rightMove);


        forgotPassTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateField();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }
    public  void validateField(){
        String email = Objects.requireNonNull(userTextInputEditText.getText()).toString().trim();
        String password = Objects.requireNonNull(passwordTextInputEditText.getText()).toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //userTextInputEditText.setError("Ingresa un correo válido");
            userTextField.setError("Ingresa un correo válido");

        } else {
            //userTextInputEditText.setError(null);
            userTextField.setErrorEnabled(false);
            userTextField.setError(null);
            //startSession(email, password);
        }

        if (password.isEmpty() || password.length() < 8) {
           // passwordTextInputEditText.setError("Mínimo 8 caracteres");
            passwordTextField.setError("Mínimo 8 caracteres");
        } else if (!Pattern.compile("[0-9]").matcher(password).find()) {
            //passwordTextInputEditText.setError("Mínimo un número");
            passwordTextField.setError("Mínimo un número");
        } else {
            //passwordTextInputEditText.setError(null);
            passwordTextField.setErrorEnabled(false);
            passwordTextField.setError(null);
            //startSession(email, password);
        }
        startSession(email, password);
    }

    public void startSession(String email, String password){
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(LoginActivity.this, "Ocurrió un error intente nuevamente", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        }
    }

}