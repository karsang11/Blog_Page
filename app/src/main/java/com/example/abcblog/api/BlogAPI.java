package com.example.abcblog.api;

import com.example.abcblog.Model.Posts;
import com.example.abcblog.Model.PostsCrud;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BlogAPI {

    @GET("/blog/getblogs")
    Call<List<Posts>> getBlog(@Header("Authorization") String token);

    @POST("/blog/create")
    Call<Posts> createBlog(@Body Posts posts);

    @PUT("/blog/update/{id}")
    Call<Posts> updateBlog(@Header("Authorization") String token, @Body Posts posts, @Path("id") String id);

    @DELETE("/blog/remove/{id}")
    Call<Posts> removeblog(@Path("id") String id);
}
