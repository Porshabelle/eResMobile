package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eresapplication.Classes.UserHelperAdapter;
import com.example.eresapplication.Classes.UserHelperClass;
import com.example.eresapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BrowseAnnouncements extends AppCompatActivity {

    RecyclerView recyclerView;
    UserHelperAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    String portfolio = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_announcements);

        recyclerView = (RecyclerView) findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        portfolio = intent.getStringExtra("portfolio");

        if(portfolio.equals("academics"))
        {
            FirebaseRecyclerOptions<UserHelperClass> options = new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Announcements").orderByChild("role").equalTo("Hc Academics"), UserHelperClass.class)
                    .build();

            myAdapter = new UserHelperAdapter(options);
            recyclerView.setAdapter(myAdapter);
        }
        else if(portfolio.equals("ram"))
        {
            FirebaseRecyclerOptions<UserHelperClass> options = new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Announcements").orderByChild("role").equalTo("Residence Manager"), UserHelperClass.class)
                    .build();

            myAdapter = new UserHelperAdapter(options);
            recyclerView.setAdapter(myAdapter);
        }
        else if(portfolio.equals("sports"))
        {
            FirebaseRecyclerOptions<UserHelperClass> options = new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Announcements").orderByChild("role").equalTo("Hc Sports"), UserHelperClass.class)
                    .build();

            myAdapter = new UserHelperAdapter(options);
            recyclerView.setAdapter(myAdapter);
        }
        else if(portfolio.equals("domestics"))
        {
            FirebaseRecyclerOptions<UserHelperClass> options = new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Announcements").orderByChild("role").equalTo("Hc Domestic"), UserHelperClass.class)
                    .build();

            myAdapter = new UserHelperAdapter(options);
            recyclerView.setAdapter(myAdapter);
        }
        else if(portfolio.equals("caretaker"))
        {
            FirebaseRecyclerOptions<UserHelperClass> options = new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Announcements").orderByChild("role").equalTo("Caretaker"), UserHelperClass.class)
                    .build();

            myAdapter = new UserHelperAdapter(options);
            recyclerView.setAdapter(myAdapter);
        }



    }

    @Override
    public void onStart() {
        super.onStart();
        myAdapter.startListening();
    }

}