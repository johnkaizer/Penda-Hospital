package com.project.pendahospital.Patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.pendahospital.Adapters.ConsultAdapter;
import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.R;
import com.project.pendahospital.Activities.ShoppingCartActivity;

import java.util.ArrayList;

public class EconsultActivity extends AppCompatActivity {
    ImageView cart;
    RecyclerView consultRv;
    ConsultAdapter consultAdapter;
    ArrayList<ConsultModel> consultModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_econsult);
        consultRv= findViewById(R.id.consults_rv);
        consultModels= new ArrayList<>();

        consultModels.add(new ConsultModel(R.drawable.image_24,"10Am-02PM","0782345678","Dentist"));
        consultModels.add(new ConsultModel("Dr July Milton","08Am-02PM","07827373736","Dentist"));
        consultModels.add(new ConsultModel("Dr June Ethiopia","10Am-02PM","0782345678","Dentist"));
        consultModels.add(new ConsultModel("Dr Josh Jack","10Am-02PM","0782345678","Dentist"));
        consultModels.add(new ConsultModel("Dr Jelly Bean","10Am-02PM","0782345678","Dentist"));

        consultAdapter = new ConsultAdapter(this, consultModels, this);
        consultRv.setAdapter(consultAdapter);
        consultRv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        consultRv.setHasFixedSize(true);
        consultRv.setNestedScrollingEnabled(false);



        cart= findViewById(R.id.cart_btn);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EconsultActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}