package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public dbc1 obj1 = new dbc1(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void funstore(View view){
        EditText v1 = (EditText)findViewById(R.id.e1);
        EditText v2 = (EditText)findViewById(R.id.e2);
        EditText v3 = (EditText)findViewById(R.id.e3);
        String s1 = v1.getText().toString();
        String s2 = v2.getText().toString();
        Integer m = Integer.parseInt(v3.getText().toString());
        if(!s1.equals("") && (!s2.equals(""))) {
            if (obj1.storedata(s1, s2, m)) {
                Toast.makeText(this, "Data Added", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Data Error", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"Fields can't be empty",Toast.LENGTH_LONG).show();
        }
    }

    public void funget(View view){
        TextView t1 = (TextView)findViewById(R.id.t1);
        Cursor c1 = obj1.fetchdata();
        StringBuilder str1= new StringBuilder();
        if(c1 != null && c1.getCount()>0){
            c1.moveToFirst();
            do {
                String c2 = c1.getString(0);
                String c3 = c1.getString(1);
                String c4 = c1.getString(2);
                String c5 = c1.getString(3);
                str1.append(c2).append(" ").append(c3).append(" ").append(c4).append(" ").append(c5).append("\n");
            }while (c1.moveToNext());
            t1.setText(str1.toString());
        }
        else{
            Toast.makeText(this,"Fetch Error",Toast.LENGTH_LONG).show();
        }
    }

}