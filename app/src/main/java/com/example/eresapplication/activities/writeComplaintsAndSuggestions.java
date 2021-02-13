package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eresapplication.Classes.UserHelperClass;
import com.example.eresapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//waiting for emulator

public class writeComplaintsAndSuggestions extends AppCompatActivity {

    Button btnSubmitSuggestions;
    EditText etTitle, etDescription;

    FirebaseDatabase rootNode;
    DatabaseReference reference,ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_complaints_and_suggestions);

        btnSubmitSuggestions = findViewById(R.id.btnPostAnnouncements);
        etTitle = findViewById(R.id.etAnnouncementTitle);
        etDescription = findViewById(R.id.etDescription);

        btnSubmitSuggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference().child("Suggestions");

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                ref = FirebaseDatabase.getInstance().getReference().child("User").child(uid);

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String role =snapshot.child("Role").getValue().toString();
                        String firstname =snapshot.child("Firstname").getValue().toString();
                        String surname =snapshot.child("Surname").getValue().toString();
                        String residence =snapshot.child("Residence").getValue().toString();

                        String title = etTitle.getText().toString().trim();
                        String description = etDescription.getText().toString().trim();


                        UserHelperClass helperClass = new UserHelperClass(title,description,role,firstname,surname,residence);
                        reference.push().setValue(helperClass);

                        Toast.makeText(writeComplaintsAndSuggestions.this, "Submitted Suggestion Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(writeComplaintsAndSuggestions.this,StudentActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }
}
