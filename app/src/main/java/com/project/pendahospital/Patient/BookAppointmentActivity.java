package com.project.pendahospital.Patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.pendahospital.Models.AppointmentModel;
import com.project.pendahospital.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class BookAppointmentActivity extends AppCompatActivity {
    TextView docName,Category;
    EditText patName, patPhone,patDate,patTime;
    AppCompatButton submit;
    private DatePickerDialog picker;
    TimePickerDialog picker1;
    int hour;
    int min;
    DatabaseReference dataRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        docName = findViewById(R.id.doc_name);
        Category = findViewById(R.id.doc_category);
        patName = findViewById(R.id.pat_name);
        patPhone = findViewById(R.id.pat_phone);
        patDate = findViewById(R.id.date);
        patTime = findViewById(R.id.pat_time);
        submit= findViewById(R.id.submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });

        dataRef= FirebaseDatabase.getInstance().getReference().child("BookingDetails");
        //Picking date
        patDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day= calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                picker = new DatePickerDialog(BookAppointmentActivity.this,  new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        patDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                    }
                },year, month,day);
                picker.show();
            }
        });
        //Picking time
        patTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour= calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);

                picker1 = new TimePickerDialog(BookAppointmentActivity.this,  new TimePickerDialog.OnTimeSetListener() {
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

    }

    private void placeOrder() {
        String DocName =  docName.getText().toString();
        String DocCategory =  Category.getText().toString();
        String PatName =  patName.getText().toString();
        String PatPhone =  patPhone.getText().toString();
        String PatTime =  patTime.getText().toString();
        String PatDate =  patDate.getText().toString();
        AppointmentModel appointmentModel = new AppointmentModel(DocName,DocCategory,PatName,PatPhone,PatTime,PatDate);
        dataRef.push().setValue(appointmentModel);
        Toast.makeText(BookAppointmentActivity.this,"Appointment Successfully Booked",Toast.LENGTH_SHORT);
       patName.setText("");
       patPhone.setText("");
       patTime.setText("");
       patDate.setText("");


    }
}