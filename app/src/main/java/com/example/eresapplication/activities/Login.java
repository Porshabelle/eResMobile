package com.example.eresapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eresapplication.Classes.HouseCommittee;
import com.example.eresapplication.Classes.ResManager;
import com.example.eresapplication.Classes.UserHelperClass;
import com.example.eresapplication.R;
import com.example.eresapplication.Utilities;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Login extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    private View mProgressView;

    private TextView tvLoad;

    LinearLayout studentLayout, resManLayout, hcLayout, mentorLayout, mLoginFormView;

    EditText etUsername, etPassword, etResetMail;
    Button btnSubmitAnnouncement;

    FirebaseAuth mFirebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;
    FirebaseDatabase database;
    DatabaseReference ref;

    DatabaseReference reference;


    Button btnRegisterNewUser, btnLogin;
    TextView tvReset;
    String role = "";

    EditText etTitle, etDescription;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        studentLayout = (LinearLayout) findViewById(R.id.studentLayout);
        resManLayout = (LinearLayout) findViewById(R.id.resManLayout);
        hcLayout = (LinearLayout) findViewById(R.id.hcLayout);
        mentorLayout = (LinearLayout) findViewById(R.id.mentorLayout);

        mFirebaseAuth = FirebaseAuth.getInstance();

        btnRegisterNewUser = findViewById(R.id.btnRegisterNewUser);
        btnLogin = findViewById(R.id.btnLogin);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);

        etUsername = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);



        btnLogin = findViewById(R.id.btnLogin);
        btnRegisterNewUser = findViewById(R.id.btnRegisterNewUser);
        tvReset = findViewById(R.id.tvReset);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
               /*if (mFirebaseUser != null) {
                   Toast.makeText(Login.this, "Logged in!", Toast.LENGTH_SHORT).show();
               }*/

            }
        };

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   final FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
              //  String role = "";
                final String password = etPassword.getText().toString();
                final String username = etUsername.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                } else if (!(username.isEmpty() && password.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Login failed, please try again", Toast.LENGTH_SHORT).show();
                            }
                            if (task.isSuccessful())
                            {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                String uid = user.getUid();

                                ref = FirebaseDatabase.getInstance().getReference().child("User").child(uid);
                               ref.addValueEventListener(new ValueEventListener() {
                                   @Override
                                   public void onDataChange(@NonNull DataSnapshot snapshot) {
                                       String role =snapshot.child("Role").getValue().toString();
                                       if(role.equals("Student"))
                                       {
                                           startActivity(new Intent(Login.this,StudentActivity.class));
                                       }
                                       else if(role.equals("Hc"))
                                       {
                                           startActivity(new Intent(Login.this,HCActivity.class));
                                       }
                                       else if(role.equals("Residence Manager"))
                                       {
                                           startActivity(new Intent(Login.this,ResManagerActivity.class));
                                       }
                                       else if(role.equals("Mentor"))
                                       {
                                           startActivity(new Intent(Login.this,MentorActivity.class));
                                       }
                                       else if(role.equals("Warden"))
                                       {
                                           startActivity(new Intent(Login.this,ResManagerActivity.class));
                                       }
                                       else {
                                           startActivity(new Intent(Login.this,CareTakerActivity.class));
                                       }
                                   }

                                   @Override
                                   public void onCancelled(@NonNull DatabaseError error) {

                                   }
                               });

                            }
                        }
                    });
                }
                else
                    {
                    Toast.makeText(Login.this, "Error occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegisterNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerActivityIntent = new Intent(Login.this, Register.class);
                startActivity(registerActivityIntent);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}