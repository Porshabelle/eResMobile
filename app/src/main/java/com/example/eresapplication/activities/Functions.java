package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.eresapplication.R;


public class Functions extends AppCompatActivity {

    LinearLayout resManagerLayout,studLayout;
    String Role = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);


        resManagerLayout = findViewById(R.id.resManLayout);
        studLayout = findViewById(R.id.studentLayout);


    }
}