package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eresapplication.Classes.EventCalender;
import com.example.eresapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddEventsCalender extends AppCompatActivity {

    EditText etEvent;
    CalendarView calender;
    Button btnSet;
    private String selectedDate;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events_calender);

        etEvent = findViewById(R.id.etEvent);
        calender = findViewById(R.id.calendar);
        btnSet = findViewById(R.id.btnSet);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();


        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {

                String mon = "";
                if(month==0)
                {
                     mon = "January";
                     selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==1)
                {
                    mon = "February";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==2)
                {
                    mon = "March";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==3)
                {
                    mon = "April";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==4)
                {
                    mon = "May";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==5)
                {
                    mon = "June";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==6)
                {
                    mon = "July";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==7)
                {
                    mon = "August";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==8)
                {
                    mon = "September";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==9)
                {
                    mon = "October";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else if(month==10)
                {
                    mon = "November";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
                else {
                    mon = "December";
                    selectedDate = Integer.toString(year)+" " + mon+" " + Integer.toString(dayOfMonth)+" ";
                }
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddEventsCalender.this, "Event added successfully!", Toast.LENGTH_SHORT).show();
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference().child("Events");

                EventCalender eventCalender = new EventCalender(selectedDate,etEvent.getText().toString());
                reference.push().setValue(eventCalender);
            }
        });


    }

    public void months()
    {

    }


}