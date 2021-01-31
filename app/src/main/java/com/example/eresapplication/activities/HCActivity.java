package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.eresapplication.R;

public class HCActivity extends AppCompatActivity {

    CardView btnPostAnnouncements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_c);

        btnPostAnnouncements = findViewById(R.id.btnPostAnnouncements);

        btnPostAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HCActivity.this,PostAnnouncements.class);
                startActivity(intent);
            }
        });
    }
}
