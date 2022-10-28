package com.project.pendahospital.Patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.pendahospital.Adapters.PharmacyAdapter;
import com.project.pendahospital.Adapters.ProductsAdapter;
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
    ArrayList<ProductsModel> productsModels;
    RecyclerView products;

    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phamarcy);
        pharmacy=findViewById(R.id.pharmacy);
        products= findViewById(R.id.products);
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

        ///products
        productsModels=new ArrayList<>();

        productsModels.add(new ProductsModel(R.drawable.formula,"Dietary Supplement health Products","KSH 750"));
        productsModels.add(new ProductsModel(R.drawable.med1,"Kidney Restore And cleaning Products","KSH 750"));
        productsModels.add(new ProductsModel(R.drawable.med2,"Dietary Supplement For Kids","KSH 950"));
        productsModels.add(new ProductsModel(R.drawable.med3," Supplement Diet Products","KSH 1700"));
        productsModels.add(new ProductsModel(R.drawable.med4,"Softcare Sanitary Towels","KSH 120"));
        productsModels.add(new ProductsModel(R.drawable.med5,"Kortex-Ultra  Sanitary Pads","KSH 200"));
        productsModels.add(new ProductsModel(R.drawable.med6,"P-ALAXIN Malaria Drugs","KSH 550"));
        productsModels.add(new ProductsModel(R.drawable.med7,"Bharat Typhoid Vaccine 82% effective","KSH 1050"));
        productsModels.add(new ProductsModel(R.drawable.med8,"Blood Pressure Drugs","KSH 900"));
        productsModels.add(new ProductsModel(R.drawable.med9,"Excedrin Migraine Pain Reliever Caplets","KSH 500"));

        productsAdapter = new ProductsAdapter(this, productsModels, this);
        products.setAdapter(productsAdapter);
        products.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        products.setHasFixedSize(true);
        products.setNestedScrollingEnabled(false);
    }
}