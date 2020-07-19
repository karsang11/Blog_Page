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

import com.example.abcblog.Adapter.AdminAdapter;
import com.example.abcblog.Model.Posts;
import com.example.abcblog.api.BlogAPI;
import com.example.abcblog.url.URL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class AdminpostActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpost);

//        profile = findViewById(R.id.btnHello);
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(AdminpostActivity.this, "Hello", Toast.LENGTH_SHORT).show();
//            }
//        });

        recyclerView = findViewById(R.id.adminrecyclerview);
        List<Posts> postsList = getList();

        AdminAdapter adminAdapter = new AdminAdapter(this, postsList);
        recyclerView.setAdapter(adminAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
            Intent intent = new Intent(AdminpostActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_logout) {
            Intent intent = new Intent(AdminpostActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
