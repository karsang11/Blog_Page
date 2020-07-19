package com.example.abcblog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.abcblog.Adapter.UserAdapter;
import com.example.abcblog.Model.Posts;
import com.example.abcblog.api.BlogAPI;
import com.example.abcblog.url.URL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.POST;

public class UserActivity extends AppCompatActivity {
    private RecyclerView userrecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userrecyclerview = findViewById(R.id.userrecyclerview);

        List<Posts>postsList = getList();
        UserAdapter userAdapter = new UserAdapter(this, postsList);
        userrecyclerview.setAdapter(userAdapter);
        userrecyclerview.setLayoutManager(new LinearLayoutManager(this));

    }


    public List<Posts> getList()
    {
        List<Posts> pList=new ArrayList<>();
        BlogAPI blogAPI= URL.getRetrofit().create(BlogAPI.class);
        Call<List<Posts>> postcall=blogAPI.getBlog(URL.token);
        try {
            Response<List<Posts>> listResponse=postcall.execute();
            if(listResponse.isSuccessful())
            {
                pList=listResponse.body();
                return pList;
            }
            else
            {
                Toast.makeText(this, "No Posts to show", Toast.LENGTH_SHORT).show();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return pList;

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
            Intent intent = new Intent(UserActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_logout) {
            URL.token+=null;
            Intent intent = new Intent(UserActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
