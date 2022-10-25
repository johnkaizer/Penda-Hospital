package com.project.pendahospital.Patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.pendahospital.Adapters.PharmacyAdapter;
import com.project.pendahospital.Models.PharmacyModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class PhamarcyActivity extends AppCompatActivity {
    PharmacyAdapter pharmacyAdapter;
    ArrayList<PharmacyModel> pharmacyModels;
    RecyclerView pharmacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phamarcy);
        pharmacy=findViewById(R.id.pharmacy);
        pharmacyModels=new ArrayList<>();

        pharmacyModels.add(new PharmacyModel(R.drawable.card1,"1","Chat with us via WhatsApp on +254207640471 or call us via +254207909045"));
        pharmacyModels.add(new PharmacyModel(R.drawable.card2,"2","Our certified medical provider will get back to you."));
        pharmacyModels.add(new PharmacyModel(R.drawable.card3,"3","Get your medication delivered to you at your preferred address."));
        pharmacyModels.add(new PharmacyModel(R.drawable.card4,"4","Or at a small extra fee, let us collect your sample from your home for further diagnostics"));

        pharmacyAdapter = new PharmacyAdapter(this, pharmacyModels, this);
        pharmacy.setAdapter(pharmacyAdapter);
        pharmacy.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        pharmacy.setHasFixedSize(true);
        pharmacy.setNestedScrollingEnabled(false);
    }
}