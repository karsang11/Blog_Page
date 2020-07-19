package com.example.abcblog.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abcblog.EditpostActivity;
import com.example.abcblog.Model.Posts;
import com.example.abcblog.Model.PostsCrud;
import com.example.abcblog.ProfileActivity;

import com.example.abcblog.R;
import com.example.abcblog.api.BlogAPI;
import com.example.abcblog.strictmode.StrictMode;
import com.example.abcblog.url.URL;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.AdminViewHolder> {
    Context mContext;
    List<Posts> postsList;
    //Constructor to receive data from activity

    public AdminAdapter(Context mContext, List<Posts> postsList) {
        this.mContext = mContext;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public AdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adminpost, parent, false);
        return new AdminViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminViewHolder holder, int position) {
        final Posts posts = postsList.get(position);
        final String id=postsList.get(position).get_id();
        holder.adminprofileimage.setImageResource(R.drawable.ic_account);
        holder.posttitle.setText(posts.getTitle());
        holder.postblog.setText(posts.getBlog());

        holder.adminprofileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check profile
                Intent intent = new Intent(mContext, ProfileActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.editpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EditpostActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("title",posts.getTitle());
                intent.putExtra("blog",posts.getBlog());
                mContext.startActivity(intent);
            }
        });

        holder.deletepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final PostsCrud postsCrud=new PostsCrud(id);
                BlogAPI blogAPI= URL.getRetrofit().create(BlogAPI.class);
                Call<Posts> postsCrudCall=blogAPI.removeblog(id);
                StrictMode.StrictMode();
                try
                {
                    Response<Posts> postsCrudResponse=postsCrudCall.execute();
                    if(postsCrudResponse.isSuccessful())
                    {
                        Toast.makeText(mContext, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(mContext, "Unable to delete", Toast.LENGTH_SHORT).show();
                    }
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class AdminViewHolder extends RecyclerView.ViewHolder {
        ImageView adminprofileimage;
        TextView posttitle, postblog;
        Button editpost, deletepost;


        public AdminViewHolder(@NonNull View itemView) {
            super(itemView);

            adminprofileimage = itemView.findViewById(R.id.imageView3);
            posttitle = itemView.findViewById(R.id.textView2);
            postblog = itemView.findViewById(R.id.textView4);
            editpost = itemView.findViewById(R.id.button);
            deletepost = itemView.findViewById(R.id.button2);
        }
    }
}
