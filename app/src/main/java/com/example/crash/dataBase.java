package com.example.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ranking.db";
    public static final String TABLE_NAME = "ranking_table";
    public static final String COL_ID = "ID";
    public static final String COL_NICKNAME = "NICKNAME";
    public static final String COL_SCORE = "SCORE";

    public dataBase(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("+ COL_ID +"INTEGER PRIMARY KEY , "+COL_NICKNAME+" TEXT ,"+COL_SCORE+" TEXT)");    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor SelectTopTen() {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor curs = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_SCORE + " DESC LIMIT 10", null);

        return curs;
    }

    public void Insert(String name, String points) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues content = new ContentValues();

        content.put(COL_NICKNAME, name);
        content.put(COL_SCORE, points);

        db.insert(TABLE_NAME, null, content);
    }
}

