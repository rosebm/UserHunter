package com.rosalyn.userhunter.rest_client;

import com.rosalyn.userhunter.Model.NewUserResponse;
import com.rosalyn.userhunter.Model.UResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @GET("users")
    Call<UResponse> getUsers();

    @POST("users")
    Call<NewUserResponse> postUser();
}
