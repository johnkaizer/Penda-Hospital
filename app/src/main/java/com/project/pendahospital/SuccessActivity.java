package com.project.pendahospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.pendahospital.Patient.MainActivity;

public class SuccessActivity extends AppCompatActivity {
    AppCompatButton done1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        done1= findViewById(R.id.done);
        done1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuccessActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}