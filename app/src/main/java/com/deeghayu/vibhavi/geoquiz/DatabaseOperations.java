package com.deeghayu.vibhavi.geoquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

/**
 * Created by Vibhavi on 3/10/2015.
 */
public class DatabaseOperations extends SQLiteOpenHelper{
    public String createquery="create table "+ TableData.tableinfo.table+"("+ TableData.tableinfo.Question+" Text,"+ TableData.tableinfo.answer+" Text);";

    public DatabaseOperations(Context context) {

        super(context, TableData.tableinfo.dbname,null,1);
        Log.d("Database Operations","Table created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(createquery);
        Log.d("Database Operations","Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertdata(DatabaseOperations dop,String question,String answer)
    {
        SQLiteDatabase SQ=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TableData.tableinfo.Question,question);
        cv.put(TableData.tableinfo.answer,answer);
        SQ.insert(TableData.tableinfo.table,null,cv);
        Log.d("Database Operations","One Row Inserted");



    }

    public Cursor getdata(DatabaseOperations dop)
    {
        SQLiteDatabase SQ=dop.getReadableDatabase();
        String[] columns={TableData.tableinfo.Question,TableData.tableinfo.answer};
        Cursor CR=SQ.query(TableData.tableinfo.table,columns,null,null,null,null,null);
        return CR;


    }

}
