package com.project.pendahospital.Patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.pendahospital.Adapters.DiagnosisAdapter;
import com.project.pendahospital.Adapters.PharmacyAdapter;
import com.project.pendahospital.Models.DiagnosisModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class DiagnosisActivity extends AppCompatActivity {
    DiagnosisAdapter diagnosisAdapter;
    RecyclerView diagnosis;
    ArrayList<DiagnosisModel> diagnosisModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        diagnosis= findViewById(R.id.diagnostic_recyclerView);
        diagnosisModels = new ArrayList<>();
        diagnosisModels.add(new DiagnosisModel(R.drawable.cancert,"Cancer RT-CPR","Abnormal cells divide uncontrollably and destroy body tissue","KSH 4000"));
        diagnosisModels.add(new DiagnosisModel(R.drawable.hivt,"Cancer RT-CPR","Abnormal cells divide uncontrollably and destroy body tissue","KSH 4000"));
        diagnosisModels.add(new DiagnosisModel(R.drawable.typhoidt,"Cancer RT-CPR","Abnormal cells divide uncontrollably and destroy body tissue","KSH 4000"));
        diagnosisModels.add(new DiagnosisModel(R.drawable.malariat,"Cancer RT-CPR","Abnormal cells divide uncontrollably and destroy body tissue","KSH 4000"));

        diagnosisAdapter = new DiagnosisAdapter(this, diagnosisModels, this);
        diagnosis.setAdapter(diagnosisAdapter);
        diagnosis.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        diagnosis.setHasFixedSize(true);
        diagnosis.setNestedScrollingEnabled(false);




    }
}