package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eresapplication.Classes.UserHelperClass;
import com.example.eresapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class PostAnnouncements extends AppCompatActivity {

    Button btnPostAnnouncements;
    EditText etTitle, etDescription;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_announcements);

        btnPostAnnouncements = findViewById(R.id.btnPostAnnouncements);
        etTitle = findViewById(R.id.etAnnouncementTitle);
        etDescription = findViewById(R.id.etDescription);

        btnPostAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference().child("Announcements");

                String title = etTitle.getText().toString().trim();
                String description = etDescription.getText().toString().trim();

                UserHelperClass helperClass = new UserHelperClass(title,description);
                reference.push().setValue(helperClass);

                Toast.makeText(PostAnnouncements.this, "Submitted Announcement Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PostAnnouncements.this,CareTakerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
