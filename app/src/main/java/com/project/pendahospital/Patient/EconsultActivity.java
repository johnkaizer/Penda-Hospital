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
import com.project.pendahospital.Adapters.ConsultAdapter;
import com.project.pendahospital.Adapters.DoctorsAdapter;
import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.R;
import com.project.pendahospital.Activities.ShoppingCartActivity;

import java.util.ArrayList;

public class EconsultActivity extends AppCompatActivity {
    ImageView cart;
    RecyclerView consultRv;
    ConsultAdapter consultAdapter;
    ArrayList<ConsultModel> list;
    Query databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_econsult);
        consultRv= findViewById(R.id.consults_rv);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("DoctorsDetails");
        consultRv.setHasFixedSize(true);
        consultRv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        consultAdapter = new ConsultAdapter(this,list);
        consultRv.setAdapter(consultAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    ConsultModel consultModel = dataSnapshot.getValue(ConsultModel.class);
                    list.add(consultModel);
                }
                consultAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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