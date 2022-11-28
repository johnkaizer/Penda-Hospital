package com.project.pendahospital.Patient;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
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
import com.project.pendahospital.Activities.CoverActivity;
import com.project.pendahospital.Adapters.InsuranceAdapter;
import com.project.pendahospital.Models.InsuranceModel;
import com.project.pendahospital.R;
import com.project.pendahospital.Activities.ShoppingCartActivity;

import java.util.ArrayList;

public class InsuranceActivity extends AppCompatActivity {
    ImageView cart;
    AppCompatButton Add;

    InsuranceAdapter insuranceAdapter;
    ArrayList<InsuranceModel> list;
    RecyclerView insRec;
    Query databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
        cart= findViewById(R.id.cart_btn);
        insRec=findViewById(R.id.insuranceRV);
        Add = findViewById(R.id.add_details);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsuranceActivity.this, CoverActivity.class));
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InsuranceActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
                finish();
            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference().child("InsuranceDetails");
        insRec.setHasFixedSize(true);
        insRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        insuranceAdapter = new InsuranceAdapter(this,list);
        insRec.setAdapter(insuranceAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    InsuranceModel insuranceModel = dataSnapshot.getValue(InsuranceModel.class);
                    list.add(insuranceModel);
                }
                insuranceAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}