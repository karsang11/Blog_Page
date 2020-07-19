package com.example.abcblog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abcblog.Model.UserCrud;
import com.example.abcblog.api.UserAPI;
import com.example.abcblog.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ProfileeditActivity extends AppCompatActivity {
EditText firstname,lastname,username,password;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileedit);
        firstname=findViewById(R.id.etEditFirstName);
        lastname=findViewById(R.id.etEditLastName);
        username=findViewById(R.id.etEditUsername);
        password=findViewById(R.id.etEditPassword);
        btn=findViewById(R.id.btnEditProfile);
        set();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

    }

    public void set()
    {
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {

            firstname.setText(bundle.getString("first"));
            lastname.setText(bundle.getString("last"));
            username.setText(bundle.getString("user"));

        }
    }

    public void update()
    {

        String fname,lname,user,pass;
        fname=firstname.getText().toString();
        lname=lastname.getText().toString();
        user=username.getText().toString();
        pass=password.getText().toString();
        final UserCrud userCrud=new UserCrud(fname,lname,user,pass);
        UserAPI userAPI= URL.getRetrofit().create(UserAPI.class);
        Call<UserCrud> userCrudCall=userAPI.updateUser(URL.token,userCrud);
        try {
            Response<UserCrud> userCrudResponse=userCrudCall.execute();
            if(userCrudResponse.isSuccessful())
            {
                Toast.makeText(this, "Information Updated", Toast.LENGTH_LONG).show();
                password.setText("");
            }
            else
            {
                Toast.makeText(this, "Unable to update profile at the moment", Toast.LENGTH_SHORT).show();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
