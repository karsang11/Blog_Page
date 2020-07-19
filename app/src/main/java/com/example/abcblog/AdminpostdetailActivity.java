package com.example.abcblog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            title.setText(bundle.getString("title"));
            blog.setText(bundle.getString("blog"));
        }

    }
}
