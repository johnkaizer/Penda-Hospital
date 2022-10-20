package com.project.pendahospital.Aunthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.pendahospital.Patient.MainActivity;
import com.project.pendahospital.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    public void sign_Up(View view) {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        finish();
    }
}