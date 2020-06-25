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

import com.example.abcblog.AdminActivity;
import com.example.abcblog.Model.Posts;
import com.example.abcblog.ProfileeditActivity;
import com.example.abcblog.R;

import java.util.List;

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
        Posts posts = postsList.get(position);
        holder.adminprofileimage.setImageResource(posts.getImageid());
        holder.posttitle.setText(posts.getTitle());
        holder.postblog.setText(posts.getBlog());

        holder.adminprofileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProfileeditActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.editpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AdminActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.deletepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();
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
