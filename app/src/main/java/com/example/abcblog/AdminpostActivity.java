package com.example.abcblog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.abcblog.Adapter.AdminAdapter;
import com.example.abcblog.Model.Posts;

import java.util.ArrayList;
import java.util.List;

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
        List<Posts> postsList = new ArrayList<>();
        postsList.add(new Posts(R.drawable.profile, "Why corona?","Corona is...."));
        postsList.add(new Posts(R.drawable.profile, "Why abc?","aoiwefw is...."));
        postsList.add(new Posts(R.drawable.profile, "BLog?","snowelhwihwe kguukgu ukuyg guyfuyf fyftdtgu"));
        postsList.add(new Posts(R.drawable.profile, "Why assignmrnt?","blah blah vlah"));

        postsList.add(new Posts(R.drawable.profile, "Why corona?","Corona is...."));
        postsList.add(new Posts(R.drawable.profile, "Why abc?","aoiwefw is...."));
        postsList.add(new Posts(R.drawable.profile, "BLog?","snowelhwihwe kguukgu ukuyg guyfuyf fyftdtgu"));
        postsList.add(new Posts(R.drawable.profile, "Why assignmrnt?","blah blah vlah"));

        postsList.add(new Posts(R.drawable.profile, "Why corona?","Corona is...."));
        postsList.add(new Posts(R.drawable.profile, "Why abc?","aoiwefw is...."));
        postsList.add(new Posts(R.drawable.profile, "BLog?","snowelhwihwe kguukgu ukuyg guyfuyf fyftdtgu"));
        postsList.add(new Posts(R.drawable.profile, "Why assignmrnt?","blah blah vlah"));

        AdminAdapter adminAdapter = new AdminAdapter(this, postsList);
        recyclerView.setAdapter(adminAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
