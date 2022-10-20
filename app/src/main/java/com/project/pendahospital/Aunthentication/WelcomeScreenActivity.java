package com.project.pendahospital.Aunthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.pendahospital.R;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    public void sign_Up(View view) {
        startActivity(new Intent(WelcomeScreenActivity.this, SignUpActivity.class));
        finish();
    }

    public void login(View view) {
        startActivity(new Intent(WelcomeScreenActivity.this, LoginActivity.class));
        finish();
    }
}