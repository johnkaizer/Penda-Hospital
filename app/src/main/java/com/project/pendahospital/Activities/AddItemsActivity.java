package com.project.pendahospital.Activities;

import static com.project.pendahospital.Adapters.DBmain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.pendahospital.Adapters.DBmain;
import com.project.pendahospital.R;

public class AddItemsActivity extends AppCompatActivity {
    TextView title1,amount1;
    AppCompatButton AddBtn;
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    int id =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
        title1 = findViewById(R.id.cart_item);
        amount1 = findViewById(R.id.textView52);
        dBmain = new DBmain(this);

        AddBtn = findViewById(R.id.add_btn);
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("product",title1.getText().toString());
                cv.put("amount",amount1.getText().toString());
                sqLiteDatabase= dBmain.getWritableDatabase();
                Long recinsert = sqLiteDatabase.insert(TABLENAME,null,cv);
                if (recinsert!= null){
                    Toast.makeText(AddItemsActivity.this,"Item Added to Cart successfully",Toast.LENGTH_SHORT).show();
                    finish();

                }
            }
        });
        title1.setText(getIntent().getExtras().getString("title"));
        amount1.setText(getIntent().getExtras().getString("amount"));

    }
}