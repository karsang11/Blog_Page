package com.example.abcblog.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abcblog.AdminpostdetailActivity;
import com.example.abcblog.Model.Posts;
import com.example.abcblog.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    Context yContext;
    List<Posts> postsList;

    public UserAdapter(Context yContext, List<Posts> postsList) {
        this.yContext = yContext;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_post, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final Posts posts = postsList.get(position);
        holder.img.setImageResource(R.drawable.ic_account);
        holder.titl.setText(posts.getTitle());
        holder.blg.setText(posts.getBlog());

        holder.titl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yContext, AdminpostdetailActivity.class);
//                intent.putExtra("image", posts.getImageid());
                intent.putExtra("title", posts.getTitle());
                intent.putExtra("blog", posts.getBlog());
                yContext.startActivity(intent);
            }
        });

        holder.blg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yContext, AdminpostdetailActivity.class);
//                intent.putExtra("image", posts.getImageid());
                intent.putExtra("title", posts.getTitle());
                intent.putExtra("blog", posts.getBlog());
                yContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView titl, blg;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.ivAdminimage);
            titl = itemView.findViewById(R.id.tvAdmintitle);
            blg = itemView.findViewById(R.id.tvAdminblog);
        }
    }
}
