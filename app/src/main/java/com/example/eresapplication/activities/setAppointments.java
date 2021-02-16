package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eresapplication.Classes.Appointments;
import com.example.eresapplication.Classes.UserHelperClass;
import com.example.eresapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class setAppointments extends AppCompatActivity {

    EditText etTitle, etLocation;
    Button btnSet;
    FirebaseDatabase rootNode;
    DatabaseReference reference, ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_appointments2);

        etTitle = findViewById(R.id.etTitle);
        etLocation = findViewById(R.id.etLocation);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String appointmentTitle = etTitle.getText().toString().trim();
                final String location = etLocation.getText().toString().trim();

                if (appointmentTitle.isEmpty() || location.isEmpty()) {
                    Toast.makeText(setAppointments.this, "Fill in the Event name and Location", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference().child("Appointments");

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String uid = user.getUid();

                    ref = FirebaseDatabase.getInstance().getReference().child("User").child(uid);

                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String title = snapshot.child("Title").getValue().toString();
                            String appointmentLocation = snapshot.child("Location").getValue().toString();
                            String date = snapshot.child("Date").getValue().toString();

                            Appointments appointments = new Appointments(title,date,location);
                            reference.push().setValue(appointments);

                            Toast.makeText(setAppointments.this, "Appointment added Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(setAppointments.this, MentorActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });
    }
}