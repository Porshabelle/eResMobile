package com.example.eresapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eresapplication.Classes.UserHelperAdapter;
import com.example.eresapplication.Classes.UserHelperClass;
import com.example.eresapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BrowseAnnouncements extends AppCompatActivity {

    RecyclerView recyclerView;
    UserHelperAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_announcements);

        recyclerView = (RecyclerView) findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FirebaseRecyclerOptions<UserHelperClass> options = new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Announcements"),UserHelperClass.class)
                .build();

        myAdapter = new UserHelperAdapter(options);
        recyclerView.setAdapter(myAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        myAdapter.startListening();
    }
}