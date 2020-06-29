package com.example.abcblog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminpostdetailActivity extends AppCompatActivity {
    private ImageView image;
    private TextView title, blog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpostdetail);

        image = findViewById(R.id.ivDetailImage);
        title = findViewById(R.id.tvDetailTitle);
        blog = findViewById(R.id.tvDetailBlog);
    }
}
