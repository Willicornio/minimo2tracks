package com.example.minimo2tracks;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Field;

public interface ApiTracks {
    @GET("tracks")
    Call<List<Tracks>> mistracks();



    @GET("tracks/{id}")
    Call<Tracks> track(
            @Path("id") String id);

    @PUT("tracks")
    Call<Void> editTrack(
            @Body Tracks track);

    @DELETE("tracks/{id}")
    Call<Void> deleteTrack(
            @Path("id") String id);

    /*@GET("tracks/{owner}/{repo}/contributors")
    Call<ArrayList<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
*/

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://147.83.7.203:8080/dsaApp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
