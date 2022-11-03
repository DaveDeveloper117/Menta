package com.davedev.menta.content;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.davedev.menta.plantcards.DetailsPlantsActivity;
import com.davedev.menta.plantcards.ListAdapterPlant;
import com.davedev.menta.plantcards.ListElementPlant;
import com.davedev.menta.R;
import com.davedev.menta.menu.DashboardActivity;

import java.util.ArrayList;
import java.util.List;

public class ExteriorPlantsActivity extends AppCompatActivity {

    List<ListElementPlant> elementPlants;
    SearchView searchView;
    ListAdapterPlant listAdapterPlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exterior_plants);

        searchView = findViewById(R.id.searchViewExterior);
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
        Intent intent = new Intent(ExteriorPlantsActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    public void init(){
        elementPlants = new ArrayList<>();
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Exterior Name Plant",
                "Exterior Plant Description",
                "Exterior Plant Indications",
                "0cm",
                "0%",
                "0°C"));
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Seasonal Name Plant",
                "Seasonal Plant Description",
                "Seasonal Plant Indications",
                "0cm",
                "0%",
                "0°C"));
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Seasonal Name Plant",
                "Seasonal Plant Description",
                "Seasonal Plant Indications",
                "0cm",
                "0%",
                "0°C"));
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Seasonal Name Plant",
                "Seasonal Plant Description",
                "Seasonal Plant Indications",
                "0cm",
                "0%",
                "0°C"));
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Seasonal Name Plant",
                "Seasonal Plant Description",
                "Seasonal Plant Indications",
                "0cm",
                "0%",
                "0°C"));


        listAdapterPlant = new ListAdapterPlant(elementPlants, this, this::moveToDescription);

        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        recyclerView.setAdapter(listAdapterPlant);
    }

    public void moveToDescription(ListElementPlant item){
        Intent intent = new Intent(ExteriorPlantsActivity.this, DetailsPlantsActivity.class);
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