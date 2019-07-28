package br.com.phoebus.marvelstore.retrofit.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Needed interface to RetrofitLib API implementation (Same package)
 */
public interface MarvelAPI {

    String GET_ALL_COMICS_URL = "comics?ts=1&apikey=bb1209f2e21264fe7f963b7cd7244fb3&hash=ed427e6cda65e443f9b703f9d46c21b4";

    @Headers("Content-Type: application/json")
    @GET(GET_ALL_COMICS_URL)
    Call<DataJSON> getData();
}
