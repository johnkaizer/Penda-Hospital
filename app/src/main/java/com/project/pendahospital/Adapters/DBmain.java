package com.project.pendahospital.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {
    public static final String DBNAME = "penda.db";
    public static final String TABLENAME = "cart";
    public static final int VER = 1;
    public DBmain(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+TABLENAME+" (id integer primary key,product text, amount int)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="drop table if exists "+TABLENAME+" ";
        db.execSQL(query);

    }

    public int sumPriceCartItems() {
        int result = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select sum(amount) from " + TABLENAME, null);
        if (cursor.moveToFirst()) result = cursor.getInt(0);
        cursor.close();
        db.close();
        return result;
    }
    public String CartItems() {
        String result = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select product from " + TABLENAME, null);
        if (cursor.moveToFirst()) result = cursor.getString(0);
        cursor.close();
        db.close();
        return result;
    }
}
