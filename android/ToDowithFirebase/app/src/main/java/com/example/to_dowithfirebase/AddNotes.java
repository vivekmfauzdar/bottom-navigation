package com.example.to_dowithfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AddNotes extends AppCompatActivity {


     FirebaseDatabase firebaseDatabase;
     EditText title, description;
     Button save;
     ImageView image;

     private DatabaseReference mdatabase;

    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    int Image_Request_Code = 7;
    ProgressDialog progressDialog ;

    String titlesend, descsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mdatabase=FirebaseDatabase.getInstance().getReference();

        getSupportActionBar().setTitle("Add Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        save=findViewById(R.id.save);
         image = findViewById(R.id.image);
        storageReference = FirebaseStorage.getInstance().getReference("Images");
        databaseReference = FirebaseDatabase.getInstance().getReference("Images");
        progressDialog = new ProgressDialog(AddNotes.this);
    }

    public void addnotes(View view) {
        titlesend=title.getText().toString();
        descsend=description.getText().toString();


          // false
        if(TextUtils.isEmpty(titlesend) || TextUtils.isEmpty(descsend))
        {
            return;
        }

        AddNotesInDatabase(titlesend,descsend);

    }

    private void AddNotesInDatabase(String titlesend, String descsend) {

        String id = mdatabase.push().getKey();
        Notes notes = new Notes(id,titlesend,descsend);
        mdatabase.child("Notes").child(id).setValue(notes).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(AddNotes.this, "Note Added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                else{
                    Toast.makeText(AddNotes.this, "Try Again", Toast.LENGTH_SHORT).show();
                }

            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), Image_Request_Code);
            }
        });
    }


}
