package com.example.abcblog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditpostActivity extends AppCompatActivity {

    private EditText editTitle, editPost;
    private Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpost);

        editTitle = findViewById(R.id.etEditTitle);
        editPost = findViewById(R.id.etEditPost);
        editButton = findViewById(R.id.btnEditEdit);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Post should be edited...
            }
        });
    }
}
