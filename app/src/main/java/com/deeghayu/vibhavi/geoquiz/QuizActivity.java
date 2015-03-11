package com.deeghayu.vibhavi.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;
import java.util.concurrent.ExecutionException;


public class QuizActivity extends ActionBarActivity {

    Button btntrue;
    Button btnfalse;
    TextView displaytext;
    TextView stat;
    int attempt;
    String data[]=new String[50];
    Button btnadd;
    //datbase stuff

    Context cnt=this;
    String question;
    String answer;
    int dbsize;
    int number=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        btntrue=(Button)findViewById(R.id.btn_true);
        btnfalse=(Button)findViewById(R.id.btn_false);
        displaytext=(TextView)findViewById(R.id.dsp_text);
        stat=(TextView)findViewById(R.id.status);
        attempt=0;
        btnadd =(Button)findViewById(R.id.btn_add);

        Toast.makeText(QuizActivity.this,"Successfully Loaded The Database",Toast.LENGTH_SHORT).show();
        DatabaseOperations db=new DatabaseOperations(cnt);

         Cursor cs = db.getdata(db);
        if(cs.getCount()!=0){
         cs.moveToFirst();
         dbsize = 0;
         int i = 0;


         do {


             data[i++] = cs.getString(0);
             data[i++] = cs.getString(1);


             dbsize++;


         } while (cs.moveToNext());

         Random r = new Random();
         int Low = 1;
         int High = dbsize + 1;
         int R = r.nextInt(High - Low) + Low;
         number = R - 1;

         if (number % 2 == 0) {
             displaytext.setText(data[number]);

         } else {
             displaytext.setText(data[number - 1]);

         }

         Toast.makeText(QuizActivity.this, "random genate is " + number, Toast.LENGTH_SHORT).show();
            click_btn();
     }

        click_btn();
    }

    public void click_btn()
    {
            btntrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempt++;
                stat.setText(("No of Attempts "+attempt));

                if(data[number+1].equals("True"))
                Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();

            }
        });

        btnfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempt++;
                stat.setText(("No of Attempts "+attempt));
                if(data[number+1].equals("False"))
                Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent("android.intent.action.CLEARSCREEN"));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
