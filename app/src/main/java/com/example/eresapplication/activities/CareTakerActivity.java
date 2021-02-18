package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eresapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CareTakerActivity extends AppCompatActivity {

    CardView btnPostAnnouncement, btnManageProfile,btnComplaints;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    FirebaseAuth mFirebaseAuth;

    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_taker);

        btnComplaints = findViewById(R.id.btnBrowseAnnouncements);

        btnPostAnnouncement = findViewById(R.id.btnPostAnnouncements);

        btnManageProfile = findViewById(R.id.btnManageProfile);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
            }
        };

        btnComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CareTakerActivity.this,SelectRoom.class);
                startActivity(intent);
            }
        });


        btnPostAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CareTakerActivity.this,PostAnnouncements.class);
                startActivity(intent);
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

                        Intent intent = new Intent(CareTakerActivity.this, ManageProfile.class);

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
