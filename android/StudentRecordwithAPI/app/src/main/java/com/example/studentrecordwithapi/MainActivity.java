package com.example.studentrecordwithapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editid, name, email , coursenumber;
    Button addtodatabse, delete, update, view, viewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editid=findViewById(R.id.id);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        coursenumber = findViewById(R.id.coursenumber);

        addtodatabse=findViewById(R.id.addtodatabase);
        delete=findViewById(R.id.delete);
        update=findViewById(R.id.update);
        view=findViewById(R.id.viewcurrent);
        viewall=findViewById(R.id.viewall);

        AddData();
        getData();
        deleteData();
        updataData();


    }

    public  void AddData()
    {
        addtodatabse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper myDB = new DataBaseHelper(MainActivity.this);

                boolean isInserted = myDB.insertData(name.getText().toString(), email.getText().toString(), coursenumber.getText().toString());
                  if(isInserted == true)
                  {
                      Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();

                  }else{

                      Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
                  }


            }
        });
    }
    public void getData()
    {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editid.getText().toString();

                if(id.equals(String.valueOf(""))){
                    editid.setError("Enter ID");
                }

                DataBaseHelper myDB = new DataBaseHelper(MainActivity.this);
                Cursor cursor = myDB.getData(id);
                String data = null;

                if(cursor.moveToNext()){
                    data = "ID: " + cursor.getString(0) + "\n" +
                            "Name: " + cursor.getString(1) + "\n" +
                            "Eamil: " + cursor.getString(2) + "\n" +
                            "Course Count: " + cursor.getString(3) + "\n";
                }
                showMessage("Data: " , data);
            }
        });
    }

    private void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

   public void updataData()
   {
       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               DataBaseHelper myDB = new DataBaseHelper(MainActivity.this);

                 String str1= name.getText().toString();
                  String str2=email.getText().toString();
                  String str3=coursenumber.getText().toString();
               boolean isupdate  = myDB.updateData(editid.getText().toString(),str1,str2,str3);

                  if(isupdate == true){
                      Toast.makeText(MainActivity.this, "Uploaded Successfully", Toast.LENGTH_SHORT).show();

                  }else{
                      Toast.makeText(MainActivity.this, "OOPPPSS" , Toast.LENGTH_SHORT).show();
                  }
           }
       });
   }

   public void deleteData()
   {

       delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               //TODO: ID SHOULD NOT BE EMPTY
               DataBaseHelper myDB = new DataBaseHelper(MainActivity.this);

               Integer deleteRow = myDB.deleteData(editid.getText().toString());

               if(deleteRow > 0) {
                   Toast.makeText(MainActivity.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(MainActivity.this, "OPPPPSSSS !" , Toast.LENGTH_SHORT).show();
               }
           }
       });
   }

   public  void viewAll()
   {
       viewall.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               DataBaseHelper myDB = new DataBaseHelper(MainActivity.this);

               Cursor cursor = myDB.getAllData();

               //small test
               if(cursor.getCount() == 0 )
               {
                   showMessage("Error", "Nothing found in DB");
                   return;
               }

               StringBuffer buffer = new StringBuffer();

               while (cursor.moveToNext()){
                   buffer.append("ID: " + cursor.getString(0) + "\n");
                   buffer.append("Name: " + cursor.getString(1) + "\n");
                   buffer.append("Email: " + cursor.getString(2) + "\n");
                   buffer.append("Cc: " + cursor.getString(3) + "\n");
               }
               showMessage("All data" , buffer.toString());
           }
       });
   }

}
