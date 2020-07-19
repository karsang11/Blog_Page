package com.example.abcblog.api;

import com.example.abcblog.Model.UserCrud;
import com.example.abcblog.Model.UserLogin;
import com.example.abcblog.Model.UserSignUp;
import com.example.abcblog.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserAPI {

    @POST("user/login")
    Call<SignUpResponse> checkUser(@Body UserLogin userLogin);

    @POST("user/signup")
    Call<SignUpResponse> createUser(@Body UserSignUp userSignUp);

    @GET("user/me")
    Call<UserCrud> getuser(@Header("Authorization") String token);


    @PUT("user/me")
    Call<UserCrud> updateUser(@Header("Authorization") String token,@Body UserCrud userCrud);

}
