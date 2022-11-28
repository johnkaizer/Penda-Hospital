package com.project.pendahospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class TestActivity extends AppCompatActivity {
    EditText pateName,patPhone,patDate,patTime;
    TextView testName,amount;
    AppCompatButton submit;
    DatabaseReference dataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        testName = findViewById(R.id.doc_name);
        testName.setText(getIntent().getExtras().getString("title"));
        amount = findViewById(R.id.test_amount);
        amount.setText(getIntent().getExtras().getString("amount"));
    }
}