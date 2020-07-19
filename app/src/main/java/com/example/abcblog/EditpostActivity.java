package com.example.abcblog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abcblog.Model.Posts;
import com.example.abcblog.api.BlogAPI;
import com.example.abcblog.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class EditpostActivity extends AppCompatActivity {

    private EditText editTitle, editPost;
    private Button editButton;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpost);

        editTitle = findViewById(R.id.etEditTitle);
        editPost = findViewById(R.id.etEditPost);
        editButton = findViewById(R.id.btnEditEdit);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            editTitle.setText(bundle.getString("title"));
            editPost.setText(bundle.getString("blog"));
            id=bundle.getString("id");
        }
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                update();
            }
        });
    }

    public void update()
    {
        String title,post;
        title=editTitle.getText().toString();
        post=editPost.getText().toString();
        final Posts posts=new Posts(title,post);
        BlogAPI blogAPI= URL.getRetrofit().create(BlogAPI.class);
        Call<Posts> postsCall=blogAPI.updateBlog(URL.token,posts,id);
        try {
            Response<Posts> postsResponse=postsCall.execute();
            if(postsResponse.isSuccessful())
            {
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(this, "Unable to update at this time", Toast.LENGTH_SHORT).show();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
