package com.example.squllitedtabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private Button btnAdd, btnView;
    private EditText edtxt1, edtxt2;
    TextView name1 , name2;

    SharedPreferences shrd;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt1=findViewById(R.id.editText1);
        edtxt2=findViewById(R.id.editText2);
        btnAdd=findViewById(R.id.addData);
        btnView=findViewById(R.id.viewdata);
        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 String fn = edtxt1.getText().toString();
                 String sn = edtxt2.getText().toString();

                 shrd = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();

                editor.putString("str", fn);
                editor.putString("str1", sn);

                editor.apply();
                name1.setText(fn) ;
                name2.setText(sn);


            }
        });

        //get the value of shared preferces back
        SharedPreferences getShared = getSharedPreferences("demo", MODE_PRIVATE);
        String value1 = getShared.getString("str", "name");
        String value2 = getShared.getString("str1", "name");
        name1.setText(value1);
        name2.setText(value2);


    }

}
