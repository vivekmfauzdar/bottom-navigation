package com.example.to_dowithfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewNotes extends AppCompatActivity {

    EditText title, description;
    Button update, delete;

   Intent i = new Intent();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference mdatabase;
     String titlesend, descsend;
    String getid, gettitle, getdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);

        firebaseDatabase=FirebaseDatabase.getInstance();
        mdatabase=FirebaseDatabase.getInstance().getReference();

        getSupportActionBar().setTitle("Update Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);


       gettitle=getIntent().getStringExtra("title");
       getdesc=getIntent().getStringExtra("desc");
       final String id = getIntent().getStringExtra("id");

     title.setText(gettitle);
     description.setText(getdesc);


     update.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             UpdatesNotes(id);
         }
     });

     delete.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             deleteNote(id);
         }
     });

    }

    private void UpdatesNotes(String id) {

        titlesend = title.getText().toString();
        descsend = description.getText().toString();

        Notes notes = new Notes(id, titlesend, descsend);
        mdatabase.child("Notes").child(id).setValue(notes).
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ViewNotes.this, "Notes Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });

    }
    private void deleteNote(String id) {

        mdatabase.child("Notes").child(id).removeValue()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ViewNotes.this, "Notes deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    }
                });

    }

}
