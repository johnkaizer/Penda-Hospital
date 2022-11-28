package com.project.pendahospital.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.pendahospital.Models.InsuranceModel;
import com.project.pendahospital.Patient.MainActivity;
import com.project.pendahospital.R;

public class CoverActivity extends AppCompatActivity {
    EditText name,number;
    AppCompatButton submit;
    DatabaseReference dataRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        name= findViewById(R.id.pat_name);
        number= findViewById(R.id.pat_no);
        submit= findViewById(R.id.submit_btn);
        dataRef= FirebaseDatabase.getInstance().getReference().child("InsuranceDetails");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitDetails();
            }
        });


    }

    private void submitDetails() {
        String patName =  name.getText().toString();
        String patNo =  number.getText().toString();

        InsuranceModel details = new InsuranceModel(patName,patNo);
        dataRef.push().setValue(details);
        Toast.makeText(this,"Successfully submitted your details",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CoverActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}