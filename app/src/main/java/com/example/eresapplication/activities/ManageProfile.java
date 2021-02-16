package com.example.eresapplication.activities;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eresapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ManageProfile extends AppCompatActivity {

    EditText etFirstName, etLastName, etStudentNo, etUsername, etPassword, etConfirmPass;

    DatabaseReference reference;

    String FIRSTNAME, SURNAME, PASSWORD, CONFPASSWORD, EMAIL, STUDNUMBER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_profile);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        reference = FirebaseDatabase.getInstance().getReference("User").child(uid);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etStudentNo = findViewById(R.id.etStudentNo);
        etConfirmPass = findViewById(R.id.etConfirmPassword);
        showData();

        etStudentNo.setFocusable(false);
    }


    private void showData() {
        Intent intent = getIntent();
        FIRSTNAME = intent.getStringExtra("firstname");
        SURNAME = intent.getStringExtra("surname");
        PASSWORD = intent.getStringExtra("password");
        CONFPASSWORD = intent.getStringExtra("confPassword");
        STUDNUMBER = intent.getStringExtra("studnumber");
        EMAIL = intent.getStringExtra("email");

        etFirstName.setText(FIRSTNAME);
        etLastName.setText(SURNAME);
        etPassword.setText(PASSWORD);
        etConfirmPass.setText(CONFPASSWORD);
        etStudentNo.setText(STUDNUMBER);
        etUsername.setText(EMAIL);
    }

    public void update(View view) {
        if (firstnameChanged() || surnameChanged() || passwordChanged() || confPasswordChanged()) {
            Toast.makeText(this, "Data updated successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Unsuccessful...Data is the same and cannot be updated!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean confPasswordChanged() {
        if (!CONFPASSWORD.equals(etConfirmPass.getText().toString())) {
            reference.child("confPassword").setValue(etConfirmPass.getText().toString());
            return true;
        } else {
            return false;
        }
    }

    private boolean surnameChanged() {
        if (!SURNAME.equals(etLastName.getText().toString())) {
            reference.child("surname").setValue(etLastName.getText().toString());
            return true;
        } else {
            return false;
        }
    }

    private boolean firstnameChanged() {
        if (!FIRSTNAME.equals(etFirstName.getText().toString())) {
            reference.child("firstname").setValue(etFirstName.getText().toString());
            return true;
        } else {
            return false;
        }
    }

    private boolean passwordChanged() {
        if (!PASSWORD.equals(etPassword.getText().toString())) {
            reference.child("password").setValue(etPassword.getText().toString());
            return true;
        } else {
            return false;
        }
    }
}