package com.example.abcblog.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        Posts posts = postsList.get(position);
        holder.img.setImageResource(posts.getImageid());
        holder.titl.setText(posts.getTitle());
        holder.blg.setText(posts.getBlog());

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
