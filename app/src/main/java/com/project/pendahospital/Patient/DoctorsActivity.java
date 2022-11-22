package com.project.pendahospital.Patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.pendahospital.Adapters.DoctorsAdapter;
import com.project.pendahospital.Adapters.HealthAdapter;
import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.Models.HealthModel;
import com.project.pendahospital.R;
import com.project.pendahospital.Activities.ShoppingCartActivity;

import java.util.ArrayList;

public class DoctorsActivity extends AppCompatActivity {
    ImageView cart;
    RecyclerView healthrec;
    HealthAdapter healthAdapter;
    ArrayList<HealthModel> healthModels;
    //Doctor
    DoctorsAdapter doctorsAdapter;
    ArrayList<ConsultModel>list;
    RecyclerView docRec;
    Query databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        docRec=findViewById(R.id.doctor_recyclerview);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("DoctorsDetails");
        docRec.setHasFixedSize(true);
        docRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        doctorsAdapter = new DoctorsAdapter(this,list);
        docRec.setAdapter(doctorsAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    ConsultModel consultModel = dataSnapshot.getValue(ConsultModel.class);
                    list.add(consultModel);
                }
                doctorsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        healthrec= findViewById(R.id.health_recycler);
        healthModels= new ArrayList<>();
        healthModels.add(new HealthModel(R.drawable.cold,"Cold and Cough","KSH 400"));
        healthModels.add(new HealthModel(R.drawable.facial,"Face Acne","KSH 1800"));
        healthModels.add(new HealthModel(R.drawable.imjury,"Injuries","KSH 1500+"));
        healthModels.add(new HealthModel(R.drawable.immunity,"Children Immunisation","KSH 900"));
        healthModels.add(new HealthModel(R.drawable.uterus,"Irregular Periods","KSH 2000"));
        healthModels.add(new HealthModel(R.drawable.stomachache,"Stomach Ache","KSH 500"));

        healthAdapter = new HealthAdapter(this, healthModels, this);
        healthrec.setAdapter(healthAdapter);
        healthrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        healthrec.setHasFixedSize(true);
        healthrec.setNestedScrollingEnabled(false);


        cart= findViewById(R.id.cart_btn);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorsActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}