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


    CardView btnGoToHCAcademics, btnGoToResManager,btnGoToHCSports,btnGoToDomestics,btnGoToCareTaker;
    String portfolio = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnGoToDomestics = findViewById(R.id.btnGoToDomestics);
        btnGoToHCAcademics = findViewById(R.id.btnGoToHCAcademics);
        btnGoToResManager = findViewById(R.id.btnGoToResManager);
        btnGoToHCSports = findViewById(R.id.btnGoToHCSports);
        btnGoToCareTaker = findViewById(R.id.btnGoToCareTaker);

        btnGoToDomestics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portfolio ="domestics";
                Intent intent = new Intent(StudentActivity.this,choosePortfolio.class);
                intent.putExtra("portfolio", portfolio);
                startActivity(intent);
            }
        });

        btnGoToHCAcademics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portfolio = "academics";
                Intent intent= new Intent(StudentActivity.this, choosePortfolio.class);
                intent.putExtra("portfolio", portfolio);
                startActivity(intent);

            }
        });

        btnGoToResManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portfolio = "ram";
                Intent intent = new Intent(StudentActivity.this, choosePortfolio.class);
                intent.putExtra("portfolio", portfolio);
                startActivity(intent);
            }
        });


        btnGoToHCSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portfolio = "sports";
                Intent intent = new Intent(StudentActivity.this, choosePortfolio.class);
                intent.putExtra("portfolio", portfolio);
                startActivity(intent);
            }
        });

        btnGoToCareTaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portfolio = "caretaker";
                Intent intent = new Intent(StudentActivity.this, choosePortfolio.class);
                intent.putExtra("portfolio", portfolio);
                startActivity(intent);

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

