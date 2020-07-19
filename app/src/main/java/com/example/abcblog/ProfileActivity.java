package com.example.abcblog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcblog.Model.UserCrud;
import com.example.abcblog.api.UserAPI;
import com.example.abcblog.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    TextView fname,lname,username;
    Button edit, delete;
    UserCrud userCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edit = findViewById(R.id.btnProfileEdit);

        fname=findViewById(R.id.tvFirstname);
        lname=findViewById(R.id.tvLastname);
        username=findViewById(R.id.tvUsername);
        setNames();

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ProfileeditActivity.class);
                intent.putExtra("first",userCrud.getFname());
                intent.putExtra("last",userCrud.getLname());
                intent.putExtra("user",userCrud.getUsername());
                intent.putExtra("pass",userCrud.getPassword());
                startActivity(intent);
            }
        });


    }

    public void setNames()
    {

        UserAPI userAPI= URL.getRetrofit().create(UserAPI.class);
        Call<UserCrud> userCrudCall=userAPI.getuser(URL.token);
        try {
            Response<UserCrud> userCrudResponse=userCrudCall.execute();

            if(userCrudResponse.isSuccessful())
            {

                userCrud=userCrudResponse.body();
                fname.setText(userCrudResponse.body().getFname());
                lname.setText(userCrudResponse.body().getLname());
                username.setText(userCrudResponse.body().getUsername());

            }
            else
            {
                Toast.makeText(this, "Unable to Retrieve data at this time", Toast.LENGTH_SHORT).show();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
