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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eresapplication.Classes.HouseCommittee;
import com.example.eresapplication.Classes.ResManager;
import com.example.eresapplication.R;
import com.example.eresapplication.Utilities;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;

    EditText etUsername, etPassword, etResetMail;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    RadioGroup rgOccupations;
    RadioButton rbStudent, rbResManager, rbCareTaker, rbHouseCommittee,rbMentor;
    Button btnRegisterNewUser, btnLogin;
    TextView tvReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
        etPassword =  findViewById(R.id.etPassword);

        rgOccupations = findViewById(R.id.rgOccupations);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegisterNewUser = findViewById(R.id.btnRegisterNewUser);
        tvReset = findViewById(R.id.tvReset);


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null) {
                    Toast.makeText(Login.this, "Logged in!", Toast.LENGTH_SHORT).show();
                }
                else
                {
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
                /*if(checkedId == R.id.rbCaretaker)
                {
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(etUsername.getText().toString().isEmpty()|| etPassword.getText().toString().isEmpty())
                            {
                                Toast.makeText(Login.this, "Specify Login Credentials and Occupation", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Utilities.isValidEmail(etUsername.getText());
                                startActivity(new Intent(Login.this, CareTakerActivity.class));
                                Login.this.finish();
                            }
                        }
                    });
                }
                if(checkedId == R.id.rbStudent)
                {
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(etUsername.getText().toString().isEmpty()|| etPassword.getText().toString().isEmpty())
                            {
                                Toast.makeText(Login.this, "Specify Login Credentials and Occupation", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Utilities.isValidEmail(etUsername.getText());
                                startActivity(new Intent(Login.this, StudentActivity.class));
                                Login.this.finish();
                            }
                        }
                    });
                }
                if(checkedId == R.id.rbHouseCommittee)
                {
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(etUsername.getText().toString().isEmpty()|| etPassword.getText().toString().isEmpty())
                            {
                                Toast.makeText(Login.this, "Specify Login Credentials and Occupation", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Utilities.isValidEmail(etUsername.getText());
                                startActivity(new Intent(Login.this, HCActivity.class));
                                Login.this.finish();
                            }
                        }
                    });
                }
                if(checkedId == R.id.rbMentor)
                {
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(etUsername.getText().toString().isEmpty()|| etPassword.getText().toString().isEmpty())
                            {
                                Toast.makeText(Login.this, "Specify Login Credentials and Occupation", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Utilities.isValidEmail(etUsername.getText());
                                startActivity(new Intent(Login.this, MentorActivity.class));
                                Login.this.finish();
                            }
                        }
                    });
                }*/
                if(checkedId == R.id.rbResManager)
                {
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String password = etPassword.getText().toString();
                            String username = etUsername.getText().toString();

                                if (username.isEmpty() || password.isEmpty())
                                {
                                    Toast.makeText(Login.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                                }
                                else if(!(username.isEmpty() && password.isEmpty()))
                                {
                                    mFirebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {

                                            if (!task.isSuccessful()) {
                                                Toast.makeText(Login.this, "Login failed, please try again", Toast.LENGTH_SHORT).show();
                                            } else {
                                                Intent intent = new Intent(Login.this, ResManagerActivity.class);
                                                startActivity(intent);

                                            }
                                        }
                                    });
                                }
                                else
                                {
                                    Toast.makeText(Login.this, "Error occured!", Toast.LENGTH_SHORT).show();

                                }

                        }
                    });
                }
            }
        });

        btnRegisterNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerActivityIntent = new Intent(Login.this,Register.class);
                startActivity(registerActivityIntent);
            }
        });

    }


    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }



    /**
     * Shows the progress UI and hides the login form.
     */
    /*@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }*/

}