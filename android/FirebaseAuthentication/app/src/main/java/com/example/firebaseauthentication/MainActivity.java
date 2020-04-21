package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login, signup;
    TextView forgot;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();

        forgot=findViewById(R.id.forgot);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(i);

            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PasswordActivity.class));
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getemail = email.getText().toString();
                String getpassword = password.getText().toString();
                loginMethod(getemail, getpassword);


            }
        });
    }

    private  void loginMethod(String getmail, String getpassword)
    {

        mAuth.signInWithEmailAndPassword(getmail,getpassword)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(i);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "SignUp Filed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
   protected void onStart() {

        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if(firebaseUser != null)
        {
            finish();
            Intent i  =new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(i);
        }

        super.onStart();
    }

}


