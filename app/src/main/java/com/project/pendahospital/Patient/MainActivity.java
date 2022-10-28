package com.project.pendahospital.Patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.pendahospital.R;
import com.project.pendahospital.Activities.ShoppingCartActivity;
import com.project.pendahospital.UserActivity;

public class MainActivity extends AppCompatActivity {
    private CardView card1, card2, card3, card4, card5, card6;
    ImageView cart;
    ImageView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card1 = findViewById(R.id.c1);
        card2 = findViewById(R.id.c2);
        card3 = findViewById(R.id.c3);
        card4 = findViewById(R.id.c4);
        card5 = findViewById(R.id.c5);
        card6 = findViewById(R.id.c6);
        cart= findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ShoppingCartActivity.class);
                startActivity(intent);

            }
        });
        user=findViewById(R.id.cart_btn);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsActivity.class);
                startActivity(intent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiagnosisActivity.class);
                startActivity(intent);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HospitalsActivity.class);
                startActivity(intent);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhamarcyActivity.class);
                startActivity(intent);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsuranceActivity.class);
                startActivity(intent);
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EconsultActivity.class);
                startActivity(intent);
            }
        });

    }

}