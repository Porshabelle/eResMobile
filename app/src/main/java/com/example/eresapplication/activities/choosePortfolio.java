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

public class choosePortfolio extends AppCompatActivity {

    CardView btnBrowseAnnouncements,btnViewEventsCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_portfolio);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Welcome To eRes");
        actionBar.setSubtitle("Yami@stud.com");
        actionBar.setIcon(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        btnBrowseAnnouncements = findViewById(R.id.btnBrowseAnnouncements);
        btnViewEventsCalender = findViewById(R.id.btnViewEventsCalender);

        btnBrowseAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(choosePortfolio.this, BrowseAnnouncements.class));
            }
        });

        btnViewEventsCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(choosePortfolio.this, ViewEventsCalender.class));
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

        switch(item.getItemId())
        {
            case R.id.studentActionBar:
                startActivity(new Intent(choosePortfolio.this, StudentActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    //END ActionBars
}
