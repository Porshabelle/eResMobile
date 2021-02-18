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

    CardView btnBrowseAnnouncements, btnViewEventsCalender, btnViewComplains, btnWriteComplains, btnLogout;
    String portfolio = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_portfolio);


        btnBrowseAnnouncements = findViewById(R.id.btnBrowseAnnouncements);
        btnViewEventsCalender = findViewById(R.id.btnViewEventsCalender);
        btnViewComplains = findViewById(R.id.btnViewComplaints);
        btnWriteComplains = findViewById(R.id.btnViewEventsCalender);
        btnLogout = findViewById(R.id.btnViewEventsCalender);

        Intent intent = getIntent();
        portfolio = intent.getStringExtra("portfolio");

        btnBrowseAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choosePortfolio.this, BrowseAnnouncements.class);
                intent.putExtra("portfolio",portfolio);
                startActivity(intent);

            }
        });
        btnViewEventsCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(choosePortfolio.this, ViewEventsCalender.class));
            }
        });
        btnViewComplains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(choosePortfolio.this, ChatRoom.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.studentactionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

