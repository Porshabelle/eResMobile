package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.eresapplication.R;
import com.google.firebase.auth.FirebaseAuth;

public class HCActivity extends AppCompatActivity {

    FirebaseAuth mFireBaseAuth;

    CardView btnUpdateEventsCalender, btnRespondComplaints, btnViewComplaints, btnLogOut, btnManageProfile, btnPostAnnouncements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_c);

        btnRespondComplaints = findViewById(R.id.btnRespondComplaints);
        btnPostAnnouncements = findViewById(R.id.btnPostAnnouncements);
        btnUpdateEventsCalender = findViewById(R.id.btnUpdateEventsCalender);
        btnViewComplaints = findViewById(R.id.btnViewComplaints);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnManageProfile = findViewById(R.id.btnManageProfile);

        btnUpdateEventsCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HCActivity.this, UpdateEventsCalender.class);
                startActivity(intent);
            }
        });

        btnPostAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HCActivity.this, PostAnnouncements.class);
                startActivity(intent);
            }
        });

        btnRespondComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HCActivity.this,SelectRoom.class);
                startActivity(intent);
            }
        });


        btnViewComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HCActivity.this, ViewComplaints.class);
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFireBaseAuth.signOut();
                Toast.makeText(HCActivity.this, "Please wait!!! Logging you out", Toast.LENGTH_SHORT).show();
            }
        });

        btnManageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HCActivity.this, ManageProfile.class);
                startActivity(intent);
            }
        });
    }
}
