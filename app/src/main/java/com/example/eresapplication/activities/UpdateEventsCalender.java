package com.example.eresapplication.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eresapplication.Classes.Student;
import com.example.eresapplication.R;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UpdateEventsCalender extends AppCompatActivity {

    CompactCalendarView compactCalendar;
    Button btnBackToMenu;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_events_calender);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        compactCalendar = (CompactCalendarView) findViewById(R.id.calendarView);
        compactCalendar.setUseThreeLetterAbbreviation(true);
        btnBackToMenu = findViewById(R.id.btnBackToMenu);

        //Set Events
        Event event = new Event(Color.GREEN,1477054800000L,"Graduation Ceremony");
        compactCalendar.addEvent(event);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked)
            {
                Context context = getApplicationContext();
                if(dateClicked.toString().compareTo("Fri Oct 29 09:00:00 AST 2021") == 0)
                {
                    Toast.makeText(context, "Graduation Day Ceremony", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(context, "No event scheduled for this day", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth)
            {
                actionBar.setTitle(dateFormat.format(firstDayOfNewMonth));
            }
        });

        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UpdateEventsCalender.this, StudentActivity.class));
            }
        });
    }
}
