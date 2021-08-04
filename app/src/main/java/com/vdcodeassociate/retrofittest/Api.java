package com.vdcodeassociate.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

//  Retrofit divides it in two parts the first part is the base URL and then the api name

    // Base url
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    // Api name
    @GET("marvel")
    Call<List<Hero>> getHeroes();

}
