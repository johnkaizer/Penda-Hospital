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
import com.project.pendahospital.Adapters.DiagnosisAdapter;
import com.project.pendahospital.Models.DiagnosisModel;
import com.project.pendahospital.R;
import com.project.pendahospital.Activities.ShoppingCartActivity;
import com.project.pendahospital.Adapters.TestAdapter;
import com.project.pendahospital.Models.TestModel;

import java.util.ArrayList;

public class DiagnosisActivity extends AppCompatActivity {
    DiagnosisAdapter diagnosisAdapter;
    RecyclerView diagnosis;
    ArrayList<DiagnosisModel> diagnosisModels;
    ImageView cart;
    //BOOKINGS
    TestAdapter testAdapter ;
    RecyclerView testRV;
    ArrayList<TestModel> list;
    Query databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        diagnosis= findViewById(R.id.diagnostic_recyclerView);
        testRV= findViewById(R.id.testRV);
        diagnosisModels = new ArrayList<>();
        diagnosisModels.add(new DiagnosisModel(R.drawable.cancert,"Cancer RT-CPR","Abnormal cells divide uncontrollably and destroy body tissue","KSH 4000"));
        diagnosisModels.add(new DiagnosisModel(R.drawable.hivt,"HIV/AIDS Test","A rapid antibody test, done with oral fluid, results are ready in 30 minutes or less","KSH 4000"));
        diagnosisModels.add(new DiagnosisModel(R.drawable.typhoidt,"TYPHOID Test","Performing a culture test ","KSH 1000"));
        diagnosisModels.add(new DiagnosisModel(R.drawable.covid19,"COVID-19 Test","Nose swabs ","KSH 1"));
        diagnosisModels.add(new DiagnosisModel(R.drawable.malariat,"Malaria Test","Examining under the microscope a drop of the patient's blood","KSH 7000"));

        diagnosisAdapter = new DiagnosisAdapter(this, diagnosisModels, this);
        diagnosis.setAdapter(diagnosisAdapter);
        diagnosis.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        diagnosis.setHasFixedSize(true);
        diagnosis.setNestedScrollingEnabled(false);

        cart= findViewById(R.id.cart_btn);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DiagnosisActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
                finish();
            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference().child("TestBookingDetails");
        testRV.setHasFixedSize(true);
        testRV.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        testAdapter = new TestAdapter(list, this);
        testRV.setAdapter(testAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    TestModel testModel  = dataSnapshot.getValue(TestModel.class);
                    list.add(testModel);
                }
                testAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}