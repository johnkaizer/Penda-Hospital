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
import com.project.pendahospital.Adapters.AdminAppointmentAdapter;
import com.project.pendahospital.Adapters.ProductManAdapter;
import com.project.pendahospital.Models.AppointmentModel;
import com.project.pendahospital.Models.ProductsModel;

import java.util.ArrayList;

public class ProductsManagement extends AppCompatActivity {
    ProductManAdapter productManAdapter;
    ArrayList<ProductsModel> list;
    RecyclerView prodRec;
    Query databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_management);
        prodRec=findViewById(R.id.products);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("ProductDetails");
        prodRec.setHasFixedSize(true);
        prodRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        productManAdapter = new ProductManAdapter(this,list);
        prodRec.setAdapter(productManAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    ProductsModel productsModel  = dataSnapshot.getValue(ProductsModel.class);
                    list.add(productsModel);
                }
                productManAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}