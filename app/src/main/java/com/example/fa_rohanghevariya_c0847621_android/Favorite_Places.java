package com.example.fa_rohanghevariya_c0847621_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fa_rohanghevariya_c0847621_android.databinding.ActivityFavoritePlacesBinding;
import com.example.fa_rohanghevariya_c0847621_android.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class Favorite_Places extends AppCompatActivity {
    public ActivityFavoritePlacesBinding binding;
    private ArrayList<Places> placeModelArrayList = new ArrayList<>();
    private DBHelper dbHandler;
    private PlaceAdapter placeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoritePlacesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.setTitle("Favorite Places");

        placeModelArrayList = new ArrayList<>();
       /* dbHandler = new DBHelper(Favorite_Places.this);
        placeModelArrayList = dbHandler.readProducts();
        placeAdapter = new PlaceAdapter(placeModelArrayList, Favorite_Places.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Favorite_Places.this, RecyclerView.VERTICAL, false);
        binding.favoriteplacesRV.setLayoutManager(linearLayoutManager);
        binding.favoriteplacesRV.setAdapter(placeAdapter);
        placeAdapter.setOnContactClick(new PlaceAdapter.OnContactClick() {
            @Override
            public void onContactClick(int position) {
                Intent i = new Intent(Favorite_Places.this, MapsActivity.class);
                startActivity(i);
            }
        });*/
        dummyTesting();


    }

    private void dummyTesting() {
        placeModelArrayList.add(new Places("Sydney","45.90","-48"));
        placeModelArrayList.add(new Places("PAris","45.90","-48"));
        placeModelArrayList.add(new Places("Delhi","45.90","-48"));
        placeModelArrayList.add(new Places("Ottawa","45.90","-48"));
        placeModelArrayList.add(new Places("Toronto","45.90","-48"));
        placeModelArrayList.add(new Places("London","45.90","-48"));
        placeModelArrayList.add(new Places("Istanbul","45.90","-48"));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        PlaceAdapter adapter = new PlaceAdapter(placeModelArrayList, this);
        binding.favoriteplacesRV.setAdapter(adapter);
        binding.favoriteplacesRV.setLayoutManager(linearLayoutManager);

        //binding.favoriteplacesRV.setAdapter(placeAdapter);
        adapter.setOnContactClick(new PlaceAdapter.OnContactClick() {
            @Override
            public void onContactClick(int position) {
                Intent i = new Intent(Favorite_Places.this, MapsActivity.class);
                startActivity(i);
            }
        });
    }
}