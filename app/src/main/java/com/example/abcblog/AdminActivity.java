package com.example.abcblog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.abcblog.Adapter.AdminAdapter;

public class AdminActivity extends AppCompatActivity {

    ImageView adminimage;
    EditText title, blog;
    Button posts, view_posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        view_posts = findViewById(R.id.btnMyposts);

        view_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AdminpostActivity.class);
                startActivity(intent);
            }
        });
    }
}
