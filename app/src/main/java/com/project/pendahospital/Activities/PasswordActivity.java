package com.project.pendahospital.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project.pendahospital.R;

public class PasswordActivity extends AppCompatActivity {
    EditText password;
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        password = findViewById(R.id.pat_time);
        submit = findViewById(R.id.submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setText("");
                Toast.makeText(PasswordActivity.this,"Successfully submitted your details will be sent",Toast.LENGTH_SHORT).show();
            }
        });

    }
}