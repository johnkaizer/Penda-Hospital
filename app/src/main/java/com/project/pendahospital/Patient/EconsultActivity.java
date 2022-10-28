package com.project.pendahospital.Patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.pendahospital.R;
import com.project.pendahospital.Activities.ShoppingCartActivity;

public class EconsultActivity extends AppCompatActivity {
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_econsult);
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