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

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    private RecyclerView userrecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userrecyclerview = findViewById(R.id.userrecyclerview);

        List<Posts> postsList = new ArrayList<>();

        postsList.add(new Posts(R.drawable.profile, "Why corona?", "Corona is...."));
        postsList.add(new Posts(R.drawable.profile, "Why abc?", "aoiwefw is...."));
        postsList.add(new Posts(R.drawable.profile, "BLog?", "snowelhwihwe kguukgu ukuyg guyfuyf fyftdtgu"));
        postsList.add(new Posts(R.drawable.profile, "Why assignmrnt?", "blah blah vlah"));

        UserAdapter userAdapter = new UserAdapter(this, postsList);
        userrecyclerview.setAdapter(userAdapter);
        userrecyclerview.setLayoutManager(new LinearLayoutManager(this));

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
            Intent intent = new Intent(UserActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
