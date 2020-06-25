package com.example.abcblog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.PriorityQueue;

public class RegisterActivity extends AppCompatActivity {

    private EditText fname, lname, username, password;
    private Button register;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Binding
        fname = findViewById(R.id.etFirstName);
        lname = findViewById(R.id.etLastName);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        register = findViewById(R.id.btnUserRegister);
        login = findViewById(R.id.tvLogin);

        //After clicking register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(fname.getText())){
                    fname.setError("Enter First Name");
                    fname.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(lname.getText())){
                    lname.setError("Enter Last Name");
                    lname.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(username.getText())){
                    username.setError("Enter username");
                    username.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password.getText())){
                    password.setError("Enter password");
                    password.requestFocus();
                    return;
                }


            }
        });

        //After clicking login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
