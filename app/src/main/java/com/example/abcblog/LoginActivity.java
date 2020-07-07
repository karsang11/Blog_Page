package com.example.abcblog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private TextView regiser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.etLoginUsername);
        password = findViewById(R.id.etLoginPassword);
        login = findViewById(R.id.btnUserLogin);
        regiser = findViewById(R.id.tvRegister);

        regiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText())) {
                    username.setError("Please enter username");
                    username.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password.getText())) {
                    password.setError("Please enter password");
                    password.requestFocus();
                    return;
                } else if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(LoginActivity.this, "Correct Admin!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(intent);
                } else if (username.getText().toString().equals("jimmy") && password.getText().toString().equals("jimmy")) {
                    Toast.makeText(LoginActivity.this, "Correct user!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Wrong username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
