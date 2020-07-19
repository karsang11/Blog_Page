package com.example.abcblog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.abcblog.Adapter.AdminAdapter;
import com.example.abcblog.Model.Posts;
import com.example.abcblog.api.BlogAPI;
import com.example.abcblog.strictmode.StrictMode;
import com.example.abcblog.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class AdminActivity extends AppCompatActivity {

    ImageView adminimage;
    EditText title, blog;
    Button posts, view_posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        adminimage = findViewById(R.id.ivBlogImage);

        view_posts = findViewById(R.id.btnMyposts);
        posts=findViewById(R.id.btnPost);
        title=findViewById(R.id.etBlogTitle);
        blog=findViewById(R.id.etBlog);

        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createpost();
            }
        });
        adminimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        view_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AdminpostActivity.class);
                startActivity(intent);
            }
        });
    }


    public void createpost()
    {
        String tit=title.getText().toString();
        String blo=blog.getText().toString();
        final Posts posts=new Posts(tit,blo);
        BlogAPI blogAPI= URL.getRetrofit().create(BlogAPI.class);
        Call<Posts> postsCall=blogAPI.createBlog(posts);
        StrictMode.StrictMode();
        try {
            Response<Posts> postsResponse=postsCall.execute();
            if(postsResponse.isSuccessful())
            {
                Toast.makeText(this, "Blog Added", Toast.LENGTH_SHORT).show();
                title.setText("");
                blog.setText("");
            }
            else
            {
                Toast.makeText(this, "Unable to create blog at the moment", Toast.LENGTH_SHORT).show();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_profile) {
            Intent intent = new Intent(AdminActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_logout) {
            Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
