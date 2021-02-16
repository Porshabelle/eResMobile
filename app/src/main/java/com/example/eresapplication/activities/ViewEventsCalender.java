package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.eresapplication.Classes.UserHelperAdapter;
import com.example.eresapplication.Classes.UserHelperClass;
import com.example.eresapplication.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewEventsCalender extends AppCompatActivity {

    RecyclerView eventsRecyclerView;
    UserHelperAdapter myEventsAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events_calender);

        eventsRecyclerView = (RecyclerView) findViewById(R.id.eventsrvlist);
        eventsRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        eventsRecyclerView.setLayoutManager(layoutManager);

        FirebaseRecyclerOptions<UserHelperClass> options = new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Events"), UserHelperClass.class)
                .build();

        myEventsAdapter = new UserHelperAdapter(options);
        eventsRecyclerView.setAdapter(myEventsAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        myEventsAdapter.startListening();
    }
}
