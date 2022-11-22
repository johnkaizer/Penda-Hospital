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
import com.project.pendahospital.Adapters.PharmacyAdapter;
import com.project.pendahospital.Adapters.ProductsAdapter;
import com.project.pendahospital.Models.ConsultModel;
import com.project.pendahospital.Models.PharmacyModel;
import com.project.pendahospital.Models.ProductsModel;
import com.project.pendahospital.R;
import com.project.pendahospital.Activities.ShoppingCartActivity;

import java.util.ArrayList;

public class PhamarcyActivity extends AppCompatActivity {
    PharmacyAdapter pharmacyAdapter;
    ArrayList<PharmacyModel> pharmacyModels;
    RecyclerView pharmacy;

    //Wellness Products
    ProductsAdapter productsAdapter;
    ArrayList<ProductsModel> list;
    RecyclerView products;
    Query databaseReference;

    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phamarcy);
        pharmacy=findViewById(R.id.pharmacy);
        products= findViewById(R.id.products);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("ProductDetails");
        products.setHasFixedSize(true);
        products.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        list = new ArrayList<>();
        productsAdapter = new ProductsAdapter(this,list);
        products.setAdapter(productsAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    ProductsModel productsModel = dataSnapshot.getValue(ProductsModel.class);
                    list.add(productsModel);
                }
                productsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        cart=findViewById(R.id.cart_btn);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PhamarcyActivity.this,ShoppingCartActivity.class);
                startActivity(intent);
                finish();

            }
        });
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