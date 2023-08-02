package com.example.sqlite_with_login_signup.db_Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, Constant.DB_NAME, null, Constant.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Constant.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS " + Constant.TABLE_NAME);
    onCreate(db);
    }

    public  long insertRecord(String name, String address, String image, String email, String phone){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        //insert Data
        contentValues.put("name",name);
        contentValues.put("address",address);
        contentValues.put("image",image);
        contentValues.put("email",email);
        contentValues.put("phone",phone);

        long id=sqLiteDatabase.insert(Constant.TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return (id);
    }
}
