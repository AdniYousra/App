package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t=findViewById(R.id.textView);
        Intent intent = getIntent();
        String f=intent.getStringExtra("TextView");
        t.setText(f);

    }
}