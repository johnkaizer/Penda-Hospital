package com.project.pendahospital.Activities;

import static com.project.pendahospital.DBmain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.project.pendahospital.Adapters.CartAdapter;
import com.project.pendahospital.DBmain;
import com.project.pendahospital.Models.CartModel;
import com.project.pendahospital.R;

import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView shopping;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        shopping = findViewById(R.id.shoppingRV);
        shopping.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        dBmain = new DBmain(this);
        displayData();
    }

    private void displayData() {
        sqLiteDatabase = dBmain.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLENAME + "", null);
        ArrayList<CartModel> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String product = cursor.getString(1);
            String amount = cursor.getString(2);
            list.add(new CartModel(id, product, amount));
        }
        cursor.close();
        cartAdapter = new CartAdapter(this, list, sqLiteDatabase, R.layout.cart_item);
        shopping.setAdapter(cartAdapter);
    }

}