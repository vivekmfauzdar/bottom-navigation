package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordActivity extends AppCompatActivity {


    EditText getemail;
    Button emailbtn;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
       mAuth = FirebaseAuth.getInstance();

        getemail=findViewById(R.id.getemail);
        emailbtn=findViewById(R.id.emailbtn);

        emailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usermail = getemail.getText().toString();
                if(usermail.equals(""))
                {
                    Toast.makeText(PasswordActivity.this, "Please enter your registered email", Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.sendPasswordResetEmail(usermail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(PasswordActivity.this, "Password reset email sent", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(PasswordActivity.this, HomeActivity.class));
                            }
                            else{
                                Toast.makeText(PasswordActivity.this, "Check your email", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
