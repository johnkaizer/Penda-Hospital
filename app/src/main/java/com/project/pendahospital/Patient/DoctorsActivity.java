package com.project.pendahospital.Patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.pendahospital.R;
import com.project.pendahospital.ShoppingCartActivity;

public class DoctorsActivity extends AppCompatActivity {
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        cart= findViewById(R.id.cart_btn);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorsActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}