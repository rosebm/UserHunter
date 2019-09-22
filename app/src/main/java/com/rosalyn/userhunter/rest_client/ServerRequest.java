package com.rosalyn.userhunter.rest_client;

import com.rosalyn.userhunter.Interface.GetData;
import com.rosalyn.userhunter.Model.UResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class that holds requests for RESTful
 */
public class ServerRequest {
    private final static String BASE_URL = "https://reqres.in/api/";

    /**
     * Creates the Retrofit instance
     * @return retrofit
     */
    public static Retrofit getRetrofit(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Calls the endpoint to fetch the users
     * @param callback
     */
    public static void getUsers(final GetData callback){
        Retrofit retrofit = getRetrofit();
        APIService apiService = retrofit.create(APIService.class);
        Call<UResponse> call = apiService.getUsers();

        call.enqueue(new Callback<UResponse>() {
            @Override
            public void onResponse(Call<UResponse> call, Response<UResponse> UResponse) {
                if (UResponse.isSuccessful()) {
                    UResponse jsonUResponse = UResponse.body();
                    //return data
                    if (jsonUResponse != null)
                        callback.getData(jsonUResponse.getData());
                }
            }

            @Override
            public void onFailure(Call<UResponse> call, Throwable t) {
            }
        });
    }

    public static void addNewUser(){
        Retrofit retrofit = getRetrofit();
        APIService apiService = retrofit.create(APIService.class);
        apiService.postUser();
    }

}
