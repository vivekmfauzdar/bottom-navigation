package com.example.squllitedtabase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class listActivity extends AppCompatActivity {

    TextView name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        name = findViewById(R.id.name1);

        Intent i = getIntent();
        String name2 = i.getStringExtra("name");
        name.setText(name2);




    }
}
