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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Login extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    private View mProgressView;

    private TextView tvLoad;

    LinearLayout studentLayout,resManLayout,hcLayout,mentorLayout,mLoginFormView;

    EditText etUsername, etPassword, etResetMail;
    Button btnSubmitAnnouncement;

    FirebaseAuth mFirebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;
    RadioGroup rgOccupations;
    RadioButton rbStudent, rbResManager, rbCareTaker, rbHouseCommittee,rbMentor;
    Button btnRegisterNewUser, btnLogin;
    TextView tvReset;
    String role = "";

    EditText etTitle, etDescription;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        studentLayout = (LinearLayout) findViewById(R.id.studentLayout);
        resManLayout = (LinearLayout) findViewById(R.id.resManLayout);
        hcLayout = (LinearLayout) findViewById(R.id.hcLayout);
        mentorLayout = (LinearLayout) findViewById(R.id.mentorLayout);

        btnSubmitAnnouncement = findViewById(R.id.btnSubmitAnnouncement);

        mFirebaseAuth = FirebaseAuth.getInstance();

        btnRegisterNewUser = findViewById(R.id.btnRegisterNewUser);
        btnLogin = findViewById(R.id.btnLogin);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("eRes");

        getSupportActionBar().hide();

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);

        etUsername = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        rgOccupations = findViewById(R.id.rgOccupations);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegisterNewUser = findViewById(R.id.btnRegisterNewUser);
        tvReset = findViewById(R.id.tvReset);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(Login.this, "Logged in!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Login.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };



       /* tvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(Login.this);
                dialog.setMessage("Enter Username: ");

                View dialogView = getLayoutInflater().inflate(R.layout.dialog_view,null);
                dialog.setView(dialogView);


                etResetMail = dialogView.findViewById(R.id.etResetMail);
                dialog.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        
                        if(etResetMail.getText().toString().isEmpty())
                        {
                            Toast.makeText(Login.this, "PLEASE ENTER AN EMAIL ADDRESS", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            //tvLoad.setText("Sending info to email address");
                          //  showProgress(true);

                        }
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });*/

        rgOccupations.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if (checkedId == R.id.rbStudent) {
                    role = "student";
                } else if (checkedId == R.id.rbHouseCommittee) {

                    role = "hc";

                } else if (checkedId == R.id.rbMentor) {
                    role = "mentor";
                } else {
                    role = "ram";
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = etPassword.getText().toString();
                String username = etUsername.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else if (!(username.isEmpty() && password.isEmpty()))
                {
                    mFirebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Login failed, please try again", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                    startActivity(new Intent(Login.this, ResManagerActivity.class));
                            }
                        }
                    });
                }
                else
                    { Toast.makeText(Login.this, "Error occurred!", Toast.LENGTH_SHORT).show();
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