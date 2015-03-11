package com.deeghayu.vibhavi.geoquiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.os.Vibrator;

/**
 * Created by Vibhavi on 3/11/2015.
 */
public class questionadd extends Activity {
    EditText question;
    RadioButton btntrue;
    RadioButton btnfalse;
    Button ok;
    boolean response;
    Context cnt=this;
    Vibrator vx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addquestion);
        ok=(Button)findViewById(R.id.submit);
        btntrue=(RadioButton)findViewById(R.id.radioButton);
        btnfalse=(RadioButton)findViewById(R.id.radioButton2);
        question=(EditText)findViewById(R.id.editText);
         vx = (Vibrator) this.cnt.getSystemService(Context.VIBRATOR_SERVICE);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((question.toString()!=null)||(question.toString()!=""))&&((btntrue.isChecked())||(btnfalse.isChecked())))
                {
                    if((btntrue.isChecked()))
                    {
                        response=false;
                    }else{
                        response=true;
                    }
                    DatabaseOperations db=new DatabaseOperations(cnt);
                    db.insertdata(db,""+question.getText(),""+response);
                    question.setText("");

                    Toast.makeText(questionadd.this, "Successfully Added To The Database", Toast.LENGTH_SHORT).show();
                    vx.vibrate(1000);



                }

            }
        });
    }
}
