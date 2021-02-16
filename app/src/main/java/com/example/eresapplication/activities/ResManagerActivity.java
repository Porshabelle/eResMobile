package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eresapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResManagerActivity extends AppCompatActivity {

    CardView btnUpdateEventsCalender, btnReplyComplaints, btnViewComplaints, btnLogOut, btnManageProfile, btnPostAnnouncements;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    FirebaseAuth mFirebaseAuth;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_manager);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnPostAnnouncements = findViewById(R.id.btnPostAnnouncements);
        btnUpdateEventsCalender = findViewById(R.id.btnUpdateEventsCalender);
        btnReplyComplaints = findViewById(R.id.btnPostAnnouncements);
        btnViewComplaints = findViewById(R.id.btnPostAnnouncements);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnManageProfile = findViewById(R.id.btnManageProfile);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
            }
        };


        btnUpdateEventsCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResManagerActivity.this, AddEventsCalender.class);
                startActivity(intent);
            }
        });

        btnPostAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResManagerActivity.this, PostAnnouncements.class);
                startActivity(intent);
            }
        });

        btnReplyComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResManagerActivity.this,hcReply.class);
                startActivity(intent);
            }
        });

        btnViewComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResManagerActivity.this, ViewComplaints.class);
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResManagerActivity.this, "Please wait!!! Logging you out", Toast.LENGTH_SHORT).show();
            }
        });

        btnManageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                ref = FirebaseDatabase.getInstance().getReference().child("User").child(uid);

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String firstname = snapshot.child("firstname").getValue().toString();
                        String surname = snapshot.child("surname").getValue().toString();
                        String email = snapshot.child("email").getValue().toString();
                        String studnumber = snapshot.child("studNum").getValue().toString();
                        String password = snapshot.child("password").getValue().toString();
                        String confPassword = snapshot.child("confPassword").getValue().toString();

                        Intent intent = new Intent(ResManagerActivity.this, ManageProfile.class);

                        intent.putExtra("firstname", firstname);
                        intent.putExtra("surname", surname);
                        intent.putExtra("email",email);
                        intent.putExtra("studnumber",studnumber);
                        intent.putExtra("password", password);
                        intent.putExtra("confPassword", confPassword);

                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }
}