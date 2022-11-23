package com.project.pendahospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.pendahospital.Adapters.AdminDoctorsAdapter;
import com.project.pendahospital.Adapters.ProductManAdapter;
import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.Models.ProductsModel;

import java.util.ArrayList;

public class DoctorsManagement extends AppCompatActivity {
    AdminDoctorsAdapter adminDoctorsAdapter ;
    ArrayList<ConsultModel> list;
    RecyclerView docRec;
    Query databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_management);
        docRec=findViewById(R.id.doctors);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("DoctorsDetails");
        docRec.setHasFixedSize(true);
        docRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        adminDoctorsAdapter = new AdminDoctorsAdapter(this,list);
        docRec.setAdapter(adminDoctorsAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    ConsultModel consultModel  = dataSnapshot.getValue(ConsultModel.class);
                    list.add(consultModel);
                }
                adminDoctorsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}