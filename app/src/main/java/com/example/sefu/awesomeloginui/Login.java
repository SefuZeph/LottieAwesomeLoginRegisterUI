package com.example.sefu.awesomeloginui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView signupLink;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signupLink = (TextView) findViewById(R.id.sigmuplink);
        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signupLink = new Intent(getApplicationContext(), Register.class);
                startActivity(signupLink);
            }
        });

        signin = (Button) findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent walkThrough = new Intent(getApplicationContext(), WalkThrough.class);
                startActivity(walkThrough);
            }
        });
    }
}
