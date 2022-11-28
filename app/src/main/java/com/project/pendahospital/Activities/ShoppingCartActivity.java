package com.project.pendahospital.Activities;

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
import com.project.pendahospital.R;
import com.project.pendahospital.Adapters.TransactionAdapter;
import com.project.pendahospital.TransactionModel;

import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {
//    DBmain dBmain;
//    SQLiteDatabase sqLiteDatabase;
    RecyclerView shopping;
//    CartAdapter cartAdapter;
    TransactionAdapter transactionAdapter;
    ArrayList<TransactionModel>list;
    Query databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        shopping = findViewById(R.id.shoppingRV);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("TransactionDetails");
        shopping.setHasFixedSize(true);
        shopping.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        transactionAdapter = new TransactionAdapter(this,list);
        shopping.setAdapter(transactionAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    TransactionModel transactionModel  = dataSnapshot.getValue(TransactionModel.class);
                    list.add(transactionModel);
                }
                transactionAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        dBmain = new DBmain(this);
//        displayData();
    }

//    private void displayData() {
//        sqLiteDatabase = dBmain.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLENAME + "", null);
//        ArrayList<CartModel> list = new ArrayList<>();
//        while (cursor.moveToNext()) {
//            int id = cursor.getInt(0);
//            String product = cursor.getString(1);
//            String amount = cursor.getString(2);
//            list.add(new CartModel(id, product, amount));
//        }
//        cursor.close();
//        cartAdapter = new CartAdapter(this, list, sqLiteDatabase, R.layout.cart_item);
//        shopping.setAdapter(cartAdapter);
//    }

}