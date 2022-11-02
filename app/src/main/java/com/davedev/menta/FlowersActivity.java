package com.davedev.menta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FlowersActivity extends AppCompatActivity {

    List<ListElementPlant> elementPlants;
    SearchView searchView;
    ListAdapterPlant listAdapterPlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);

        searchView = findViewById(R.id.searchView2);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        init();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FlowersActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    public void init(){
        elementPlants = new ArrayList<>();
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Flower Name",
                "Flower Description",
                "Flower Indication",
                "0cm",
                "0%",
                "0°C"));
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Flower Name",
                "Flower Description",
                "Flower Indication",
                "0cm",
                "0%",
                "0°C"));
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Flower Name",
                "Flower Description",
                "Flower Indication",
                "0cm",
                "0%",
                "0°C"));
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Flower Name",
                "Flower Description",
                "Flower Indication",
                "0cm",
                "0%",
                "0°C"));
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Flower Name",
                "Flower Description",
                "Flower Indication",
                "0cm",
                "0%",
                "0°C"));

        listAdapterPlant = new ListAdapterPlant(elementPlants, this, new ListAdapterPlant.OnItemClickListener() {
            @Override
            public void onItemClick(ListElementPlant item) {
                moveToDescription(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        recyclerView.setAdapter(listAdapterPlant);
    }

    public void moveToDescription(ListElementPlant item){
        Intent intent = new Intent(FlowersActivity.this, DetailsPlantsActivity.class);
        intent.putExtra("ListElement", item);
        startActivity(intent);
        finish();
    }

    public void filterList(String text) {
        List<ListElementPlant> filteredList = new ArrayList<>();
        for (ListElementPlant listElementPlant : elementPlants){
            if (listElementPlant.getNamePlant().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(listElementPlant);
            }

            if (filteredList.isEmpty()){
                Log.d("tag", "No info found");
            } else {
                listAdapterPlant.setFilteredList(filteredList);
            }
        }
    }

}