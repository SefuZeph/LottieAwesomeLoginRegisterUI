package com.example.sefu.awesomeloginui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sefu.awesomeloginui.dialog.CustomDialogFragment;

public class Register extends AppCompatActivity {
    ImageView closeImage;
    Button register;

    EditText edtFullname, edtEmail, edtPassword, edtDOB;
    String fullname, email, password, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtFullname = (EditText) findViewById(R.id.editTexFullName);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
        edtDOB = (EditText) findViewById(R.id.editTextDOB);


        closeImage = (ImageView) findViewById(R.id.close);
        closeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent closeRegister = new Intent(getApplicationContext(), Login.class);
                startActivity(closeRegister);
            }
        });


        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
                if (validate() == true) {
                    Toast.makeText(Register.this, "Enter Login Here", Toast.LENGTH_SHORT).show();
                    showCustomDialog();
                }
            }
        });
    }

    private void showCustomDialog() {
        CustomDialogFragment customDialog = new CustomDialogFragment();
        customDialog.show(getSupportFragmentManager(), "CustomDialogFragment");
    }

    public boolean validate() {
        boolean valid = true;

        fullname = edtFullname.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        password = edtPassword.getText().toString().trim();
        dob = edtDOB.getText().toString().trim();


        if (fullname.isEmpty() || fullname.length() < 5) {
            edtFullname.setError("at least 5 characters");
            valid = false;
        } else {
            edtFullname.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("enter a valid email address");
            valid = false;
        } else {
            edtEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            edtPassword.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            edtPassword.setError(null);
        }


        return valid;
    }
}
