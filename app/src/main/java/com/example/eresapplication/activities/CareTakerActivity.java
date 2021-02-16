package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eresapplication.R;
import com.google.firebase.auth.FirebaseAuth;

public class CareTakerActivity extends AppCompatActivity {

    CardView btnPostAnnouncement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_taker);

        btnPostAnnouncement = findViewById(R.id.btnPostAnnouncements);

        btnPostAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CareTakerActivity.this,PostAnnouncements.class);
                startActivity(intent);
            }
        });
    }
}
