package com.micronaut.playground.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Client {

    @GET("hello")
    Call<String> sayHello();

    @GET("hello/name")
    Call<String> sayHiToName(@Query("name") String name);

    @GET("hello/{name}")
    Call<String> sayHiToNameWithPath(@Path("name") String name);
}
