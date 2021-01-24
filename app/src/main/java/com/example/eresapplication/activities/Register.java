package com.example.eresapplication.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eresapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity{

    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;

    TextInputLayout passwordLayout, confirmPasswordLayout;
    EditText etFirstName, etLastName, etStudentNo, etResidenceName, etUsername, etPassword, etConfirmPass;
    Button btnRegisterNewUser;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();

        getSupportActionBar().hide();
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etResidenceName = findViewById(R.id.etResidenceName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etStudentNo = findViewById(R.id.etStudentNo);
        etConfirmPass = findViewById(R.id.etConfirmPassword);
        btnRegisterNewUser = findViewById(R.id.btnRegisterNewUser);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Register Profile");

        btnRegisterNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  String firstName = etFirstName.getText().toString().trim();
               // String lastName = etLastName.getText().toString().trim();
               // String residenceName = etResidenceName.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
               // String confirmPassword = etConfirmPass.getText().toString().trim();

                if (username.isEmpty() && password.isEmpty())
                {
                    Toast.makeText(Register.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else if(!(username.isEmpty() && password.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(!task.isSuccessful())
                            {
                                Toast.makeText(Register.this, "Registration failed, please try again", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Intent intent = new Intent(Register.this, Login.class);
                                startActivity(intent);

                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(Register.this, "Error occured!", Toast.LENGTH_SHORT).show();
                }


               /* if (TextUtils.isEmpty(firstName)) {
                    etFirstName.setError("Valid First Name is required...");
                }
                if (TextUtils.isEmpty(lastName)) {
                    etLastName.setError("Valid Last Name is required...");
                }
                if (TextUtils.isEmpty(residenceName)) {
                    etResidenceName.setError("Valid Residence Name is required...");
                }
                if (TextUtils.isEmpty(username)) {
                    etUsername.setError("Username is required...");
                }
                etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            passwordLayout.setError(null);
                        } else {
                            if (etPassword.toString().isEmpty()) {
                                {
                                    etPassword.setText("");
                                    passwordLayout.setError("Password Too Simple!");
                                }
                            } else {
                                passwordLayout.setError("Sorry Password Required!!");
                            }
                        }
                    }
                });

                etConfirmPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            confirmPasswordLayout.setError(null);
                        }
                    }
                });*/



            }
        });
    }


}