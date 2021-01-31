package com.example.eresapplication.activities;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eresapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;

    TextInputLayout passwordLayout, confirmPasswordLayout;
    EditText etFirstName, etLastName, etStudentNo, etResidenceName, etUsername, etPassword, etConfirmPass;
    Button btnRegisterNewUser;
    FirebaseAuth mFirebaseAuth;
    Spinner spResidence;
    Spinner spRole;
    String roles, residences;
    RadioGroup rgGender;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //get instance
        mFirebaseAuth = FirebaseAuth.getInstance();

        roles = "";
        residences = "";

        getSupportActionBar().hide();
        //Instatiate variables
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
        rgGender = findViewById(R.id.rgGender);

        spResidence = findViewById(R.id.spResidence);
        spRole = findViewById(R.id.spRole);

        ArrayAdapter<String> adapter;

        //Action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Register Profile");

        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,R.array.Residences);

        //Setup spinners
        //Residence spinner
        spResidence.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                if (item.equals("Mannheim Ladies"))
                {
                   residences = "Mannheim Ladies";
                }
                if(item.equals("Loggies"))
                {
                    residences = "Loggies";
                }
                if(item.equals("Welgemoed"))
                {
                    residences = "Welgemoed";
                }
                if(item.equals("Eendrag"))
                {
                    residences = "Eendrag";
                }
                if(item.equals("Gymnos"))
                {
                    residences = "Gymnos";
                }
                if(item.equals("Graduandi"))
                {
                    residences = "Graduadi";
                }
                if(item.equals("Welkom"))
                {
                    residences = "Welkom";
                }
                if(item.equals("Mannheim Men"))
                {
                    residences = "Mannheim Men";
                }
                if(item.equals("Huis Technikon"))
                {
                    residences = "Huis Technikon";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //Roles spinner
        spRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String item2 = adapterView.getItemAtPosition(i).toString();

                if (item2.equals("Residence Manager"))
                {
                   roles = "Residence Manager";
                }
                if(item2.equals("Hc"))
                {
                   roles = "Hc";
                }
                if(item2.equals("Warden"))
                {
                    roles = "Warden";
                }
                if(item2.equals("Mentor"))
                {
                    roles = "Mentor";
                }
                if(item2.equals("Caretaker"))
                {
                    roles = "Caretaker";
                }
                if(item2.equals("Student"))
                {
                    roles = "Student";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




       //btn Register
        btnRegisterNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String residenceName = etResidenceName.getText().toString().trim();
                String email = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPass.getText().toString().trim();


                if (email.isEmpty() && password.isEmpty() && firstName.isEmpty() && lastName.isEmpty() &&
                      residenceName.isEmpty() &&confirmPassword.isEmpty())
                {
                    Toast.makeText(Register.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                if(!(email.isEmpty() && password.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
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
                if(password != confirmPassword)
                {
                    etConfirmPass.setError("Passwords do not match!");
                    etConfirmPass.requestFocus();
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    etUsername.setError("Please provide a valid email!");
                    etUsername.requestFocus();
                }
                if(password.length() < 6)
                {
                    etPassword.setError("Password length should be 6 characters!");
                    etPassword.requestFocus();
                }
                else
                {
                    Toast.makeText(Register.this, "Error occurred!", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }



}