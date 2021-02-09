package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.eresapplication.Classes.EventCalender;
import com.example.eresapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEventsCalender extends AppCompatActivity {

    EditText etEvent;
    CalendarView calender;
    Button btnSet;
    private String selectedDate;

    FirebaseDatabase rootNode;
    DatabaseReference reference,ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events_calender);

        etEvent = findViewById(R.id.etEvent);
        calender = findViewById(R.id.calendar);
        btnSet = findViewById(R.id.btnSet);

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                 selectedDate = Integer.toString(year) + Integer.toString(month) + Integer.toString(dayOfMonth);
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference().child("Events");

                EventCalender eventCalender = new EventCalender(selectedDate,etEvent.getText().toString());
                reference.push().setValue(eventCalender);

            }
        });


    }

}