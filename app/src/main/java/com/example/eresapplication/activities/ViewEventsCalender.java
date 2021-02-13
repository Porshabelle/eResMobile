package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.eresapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewEventsCalender extends AppCompatActivity {

    FirebaseDatabase rootNode;
    CalendarView calender;
    TextView etEvent;
    DatabaseReference ref;
     public String selectedDate;
    Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events_calender);

        calender = findViewById(R.id.calendar);
        etEvent = findViewById(R.id.tvEvent);
        btnView = findViewById(R.id.btnView);

        // ref = FirebaseDatabase.getInstance().getReference().child("Events");
        rootNode = FirebaseDatabase.getInstance();
        ref = rootNode.getReference().child("Events").child("-MT2sd65yfWI4f2PMDx9");

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {


                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String event =snapshot.child("event").getValue().toString();
                        etEvent.setText(event);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }



        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });


    }
}