package com.example.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    FirebaseAuth m;
    TextView name , txtemail;
    Button logout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtemail=findViewById(R.id.txtemail);
        logout = findViewById(R.id.logout);
        name = findViewById(R.id.name);

        m = FirebaseAuth.getInstance();



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                m.signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = m.getCurrentUser();
        if(user!=null)
        {
            String email = user.getEmail();
            Log.d("email", String.valueOf(email));
            name.setText(email);
        }

    }
}
