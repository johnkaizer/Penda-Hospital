package com.project.pendahospital.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.pendahospital.Patient.DiagnosisActivity;
import com.project.pendahospital.R;
import com.project.pendahospital.Models.TestModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TestActivity extends AppCompatActivity {
    EditText patName1,patPhone,patDate,patTime;
    TextView testName,amount1;
    AppCompatButton submit;
    DatePickerDialog picker;
    TimePickerDialog picker1;
    DatabaseReference dataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        testName = findViewById(R.id.test_name);
        testName.setText(getIntent().getExtras().getString("title"));
        amount1 = findViewById(R.id.test_amount);
        amount1.setText(getIntent().getExtras().getString("amount"));
        patName1 = findViewById(R.id.pat_name);
        patPhone = findViewById(R.id.pat_phone);
        patTime = findViewById(R.id.pat_time);
        patDate = findViewById(R.id.date);
        submit= findViewById(R.id.submit_btn);
        dataRef= FirebaseDatabase.getInstance().getReference().child("TestBookingDetails");
        patDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day= calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(TestActivity.this,  new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        patDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                    }
                },year, month,day);
                picker.show();
            }
        });
        patTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour= calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);

                picker1 = new TimePickerDialog(TestActivity.this,  new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format= new SimpleDateFormat("k:mm a");
                        String time= format.format(c.getTime());
                        patTime.setText(time);

                    }
                },hour, min,false);
                picker1.show();
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitBooking();

            }
        });
    }

    private void submitBooking() {
        String title =  testName.getText().toString();
        String amount =  amount1.getText().toString();
        String patName =  patName1.getText().toString();
        String date =  patDate.getText().toString();
        String time =  patTime.getText().toString();

        TestModel test1 = new TestModel(title,amount,patName,date,time);
        dataRef.push().setValue(test1);
        Toast.makeText(this,"Successfully booked test",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(TestActivity.this, DiagnosisActivity.class);
        startActivity(intent);
        finish();
    }
}