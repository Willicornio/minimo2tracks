package com.example.minimo2tracks;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {



    private ApiTracks api;
    TextView textViewIdtrack;
    TextView textViewtTile;
    TextView a;
    public List<Tracks> listaTracks;
    public Recycler recycler;
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recycler = new Recycler(MainActivity.this);
        recyclerView.setAdapter(recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        textViewIdtrack = findViewById(R.id.idtrack);
        textViewtTile = findViewById(R.id.title);
        a = findViewById(R.id.singer);
//aaqtratottoot

        //Progress loading


        api = ApiTracks.retrofit.create(ApiTracks.class);
        getData();

    }

    private void getData() {
        Call<List<Tracks>> tracksCall = api.mistracks();

        tracksCall.enqueue(new Callback<List<Tracks>>() {
            @Override
            public void onResponse(Call<List<Tracks>> call, Response<List<Tracks>> response) {

                listaTracks = response.body();
                recycler.rellenarLista(listaTracks);


            }


            @Override
            public void onFailure(Call<List<Tracks>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Fallo con la petición de información", Toast.LENGTH_SHORT);


            }
        });

    }}
