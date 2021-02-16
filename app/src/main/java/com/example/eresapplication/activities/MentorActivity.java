package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.eresapplication.R;
import com.google.firebase.auth.FirebaseAuth;

public class MentorActivity extends AppCompatActivity {


    FirebaseAuth mFireBaseAuth;
    CardView btnUpdateEventsCalender, btnSetAppointments, btnLogOut, btnManageProfile, btnViewAnnouncements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);

        btnViewAnnouncements = findViewById(R.id.btnViewAnnouncements);
        btnSetAppointments = findViewById(R.id.btnSetAppointments);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnManageProfile = findViewById(R.id.btnManageProfile);

        btnSetAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MentorActivity.this, setAppointments.class);
                startActivity(intent);
            }
        });

        btnViewAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MentorActivity.this,BrowseAnnouncements.class);
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MentorActivity.this, "Please wait!!!Signing out", Toast.LENGTH_SHORT).show();
            }
        });

        btnManageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MentorActivity.this, ManageProfile.class);
                startActivity(intent);
            }
        });

    }
}