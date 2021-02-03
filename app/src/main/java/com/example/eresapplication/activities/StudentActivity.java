package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.eresapplication.Classes.Student;
import com.example.eresapplication.R;

public class StudentActivity extends AppCompatActivity {


    CardView btnGoToHCAcademics, btnGoToSocial,btnGoToHCSports,btnGoToDomestics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Welcome To eRes");
        actionBar.setSubtitle("Yami@stud.com");
        actionBar.setIcon(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.show();


        btnGoToDomestics = findViewById(R.id.btnGoToDomestics);
        btnGoToHCAcademics = findViewById(R.id.btnGoToHCAcademics);
        btnGoToSocial = findViewById(R.id.btnGoToSocial);
        btnGoToHCSports = findViewById(R.id.btnGoToHCSports);

        btnGoToDomestics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentActivity.this,writeComplaintsAndSuggestions.class);
            }
        });

        btnGoToHCAcademics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, choosePortfolio.class));

            }
        });

        btnGoToSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, choosePortfolio.class));
            }
        });

        btnGoToHCSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, choosePortfolio.class));
            }
        });
    }
    //ACTION BARS
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.studentactionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.studentActionBar:
                startActivity(new Intent(StudentActivity.this, Login.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

