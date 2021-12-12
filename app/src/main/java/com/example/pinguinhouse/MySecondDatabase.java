package com.example.pinguinhouse;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class MySecondDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_FILE_NAME = "anotherdatabase";
    private static final String DATABASE_TABLE_NAME = "anotherdatabase";
    private static final String PKEY = "pkey";
    private static final String COL1 = "SEARCH";


    public MySecondDatabase(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String DATABASE_TABLE_CREATE = "CREATE TABLE " + DATABASE_TABLE_NAME + " (" +
                PKEY + " INTEGER PRIMARY KEY," +
                COL1 + " TEXT);";
        db.execSQL(DATABASE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(String s1)
    {
        Log.i("JFL"," Insert in database");
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(COL1, s1);
        Log.i("JFL",s1);
        db.insertOrThrow(DATABASE_TABLE_NAME, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    @SuppressLint("Range")
    public void readData()
    {
        Log.i("JFL", "Reading database...");
        String select = new String("SELECT * from " + DATABASE_TABLE_NAME);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        Log.i("JFL", "Number of entries: " + cursor.getCount());
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Log.i("JFL", "Reading: " + cursor.getString(cursor.getColumnIndex(COL1))+ cursor.getString(cursor.getColumnIndex(PKEY)));
            } while (cursor.moveToNext());
        }
    }

    public void deleteData(long data) {
        Log.i("JFL", "Deleting from database");
        String delete = new String("DELETE from " + DATABASE_TABLE_NAME + " WHERE id=" + data);
        SQLiteDatabase db = getReadableDatabase();
        db.rawQuery(delete, null);
    }

    @SuppressLint("Range")
    public void printData(ArrayAdapter<String> tableau) {
        String select = new String("SELECT * from " + DATABASE_TABLE_NAME);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.getCount() > 0) {
            cursor.moveToLast();
            do {
                tableau.add(cursor.getString(cursor.getColumnIndex(PKEY)) + "/" + cursor.getString(cursor.getColumnIndex(COL1)));
            } while (cursor.moveToPrevious());
        }
    }

    public int getId(int position) {
        String select = new String("SELECT * from " + DATABASE_TABLE_NAME);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);

        return 0;
    }
}
