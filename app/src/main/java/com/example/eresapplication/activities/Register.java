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

import com.example.eresapplication.Classes.User;
import com.example.eresapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText etFirstName, etLastName, etStudentNo, etResidenceName, etUsername, etPassword, etConfirmPass;
    Button btnRegisterNewUser;
    FirebaseAuth mFirebaseAuth;
    Spinner spResidence;
    Spinner spRole;
    String roles, residences,Gender;
    RadioGroup rgGender;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mFirebaseAuth = FirebaseAuth.getInstance();

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etStudentNo = findViewById(R.id.etStudentNo);
        etConfirmPass = findViewById(R.id.etConfirmPassword);
        btnRegisterNewUser = findViewById(R.id.btnRegisterNewUser);
        rgGender = findViewById(R.id.rgGender);

        spResidence = findViewById(R.id.spResidence);
        spRole = findViewById(R.id.spRole);

       ArrayAdapter adapter;
        ArrayAdapter adapter1;

       adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Residences));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spResidence.setAdapter(adapter);

       adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Roles));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRole.setAdapter(adapter1);

       spResidence.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if(adapterView.getItemAtPosition(i).equals("Huis Technikon"))
               {
                   residences = "Huis Technikon";
               }
               else if(adapterView.getItemAtPosition(i).equals("Loggies")){
                   residences = "Loggies";
               }
               else if(adapterView.getItemAtPosition(i).equals("Mannheim Men")){
                   residences = "Mannheim Men";
               }
               else if(adapterView.getItemAtPosition(i).equals("Mannheim Ladies")){
                   residences = "Mannheim Ladies";
               }
               else if(adapterView.getItemAtPosition(i).equals("Graduandi")){
                   residences = "Graduandi";
               }
               else if(adapterView.getItemAtPosition(i).equals("Welkom")){
                   residences = "Welkom";
               }
               else if(adapterView.getItemAtPosition(i).equals("Gymnos")){
                   residences = "Gymnos";
               }
               else if(adapterView.getItemAtPosition(i).equals("Eendrag")){
                   residences = "Eendrag";
               }
               else
               {
                   residences = "Welgemoed";
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

       spRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if(adapterView.getItemAtPosition(i).equals("Residence Manager"))
               {
                   roles = "Residence Manager";
               }
               else if(adapterView.getItemAtPosition(i).equals("Student")){
                   roles = "Student";
               }
               else if(adapterView.getItemAtPosition(i).equals("Hc")){
                   roles = "Hc";
               }
               else if(adapterView.getItemAtPosition(i).equals("Caretaker")){
                   roles = "Caretaker";
               }
               else if(adapterView.getItemAtPosition(i).equals("Hc Academics")){
                   roles = "Hc Academics";
               }
               else if(adapterView.getItemAtPosition(i).equals("Hc Domestic")){
                   roles = "Hc Domestic";
               }
               else if(adapterView.getItemAtPosition(i).equals("Hc Sports")){
                   roles = "Hc Sports";
               }
               else {
                   roles = "Mentor";
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rbFemale) {
                    Gender = "Female";
                } else if (checkedId == R.id.rbMale) {
                    Gender = "Male";
                }
            }
        });

        btnRegisterNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String FirstName = etFirstName.getText().toString().trim();
                final String Surname = etLastName.getText().toString().trim();
                final String StNum = etStudentNo.getText().toString().trim();
                final String Email = etUsername.getText().toString().trim();
                final String Password = etPassword.getText().toString().trim();
                final String ConfirmPassword = etConfirmPass.getText().toString().trim();




                if (Email.isEmpty() && Password.isEmpty() && FirstName.isEmpty() && Surname.isEmpty()  &&ConfirmPassword.isEmpty())
                {
                    Toast.makeText(Register.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else if(!(Email.isEmpty() && Password.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {

                              //  String Res = spResidence.getSelectedItem().toString();

                              //  String Role = spRole.getSelectedItem().toString();

                                User user = new User(FirstName,Surname,Email,StNum,Password,ConfirmPassword,Gender,residences,roles);

                                FirebaseDatabase.getInstance().getReference("User")
                                       .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(Register.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(Register.this, Login.class);
                                            startActivity(intent);
                                        }
                                        else
                                        {
                                            Toast.makeText(Register.this, "Registration failed! Please try again.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                            else
                                {
                                Toast.makeText(Register.this, "Registration failed! Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

                if(Surname.isEmpty())
                {
                    etFirstName.setError("First Name required");
                }

                if(Surname.isEmpty())
                {
                    etLastName.setError("Last Name required");
                }

                if(StNum.isEmpty())
                {
                    etStudentNo.setError("Student Number is required");
                    etStudentNo.requestFocus();
                }
                 if(Password != ConfirmPassword)
                {
                    etConfirmPass.setError("");

                }
                if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    etUsername.setError("Please provide a valid email!");
                    etUsername.requestFocus();
                }
                 if(Password.length() < 6)
                {
                    etPassword.setError("Password length should be 6 characters!");
                    etPassword.requestFocus();
                }
            }
        });
    }

   /* public  void addRoles()
    {
        ArrayAdapter<String>  adapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Roles));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRole.setAdapter(adapter1);
    }

    public  void addResidence()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Residences));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spResidence.setAdapter(adapter);
    }*/
}