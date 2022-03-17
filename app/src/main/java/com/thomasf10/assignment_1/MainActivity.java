package com.thomasf10.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button startups;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start button
        startups = findViewById(R.id.btn_start);
        startups.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,PlayTictac.class);
            startActivity(intent);
        });




    }
}