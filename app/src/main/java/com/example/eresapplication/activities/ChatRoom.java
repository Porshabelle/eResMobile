package com.example.eresapplication.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eresapplication.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatRoom extends AppCompatActivity {

    Button btnSendMessage;
    EditText etMessage;
    TextView tvConversation;

    private String userName, roomName;
    private DatabaseReference root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room);

        btnSendMessage = findViewById(R.id.btnSendMessage);
        etMessage = findViewById(R.id.etMessage);
        tvConversation = findViewById(R.id.tvConversation);

        userName = getIntent().getExtras().get("user_name").toString();
        roomName = getIntent().getExtras().get("room_name").toString();
        setTitle("Room " + roomName);

        root = FirebaseDatabase.getInstance().getReference().child(roomName);


        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            private String temp_key;

            @Override
            public void onClick(View view) {
                Map<String,Object> map = new HashMap<>();
                temp_key = root.push().getKey();
                root.updateChildren(map);

                DatabaseReference messageRoot = root.child(temp_key);
                Map<String,Object> map2 = new HashMap<>();
                map2.put("name",userName);
                map2.put("message",etMessage.getText().toString());
                messageRoot.updateChildren(map2);

                DatabaseReference message_root = root.child(temp_key);
                map2.put("name",userName);
                map2.put("message",etMessage.getText().toString());

                message_root.updateChildren(map2);
            }
        });

        root.addChildEventListener(new ChildEventListener() {
            private String chat_message,chat_username;

            private void append_child_conversation(DataSnapshot snapshot) {
                Iterator iterator = snapshot.getChildren().iterator();
                while(iterator.hasNext())
                {
                    chat_message = (String)((DataSnapshot)iterator.next()).getValue();
                    chat_username = (String)((DataSnapshot)iterator.next()).getValue();
                    tvConversation.append(chat_username + " : " + chat_message +" \n");
                }
                etMessage.clearComposingText();
            }

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                append_child_conversation(snapshot);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                append_child_conversation(snapshot);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
