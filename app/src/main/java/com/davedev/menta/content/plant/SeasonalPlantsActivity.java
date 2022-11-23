package com.davedev.menta.content.plant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davedev.menta.R;
import com.davedev.menta.menu.DashboardActivity;
import com.davedev.menta.plantcards.DetailsPlantsActivity;
import com.davedev.menta.plantcards.ListAdapterPlant;
import com.davedev.menta.plantcards.ListElementPlant;

import java.util.ArrayList;
import java.util.List;

public class SeasonalPlantsActivity extends AppCompatActivity {

    List<ListElementPlant> elementPlants;
    SearchView searchView;
    ListAdapterPlant listAdapterPlant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonal_plants);

        searchView = findViewById(R.id.searchViewSeasonal);
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
        Intent intent = new Intent(SeasonalPlantsActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    public void init(){
        elementPlants = new ArrayList<>();
        elementPlants.add(new ListElementPlant((R.drawable.nochebuena_min), "Noche Buena (Euphorbia pulcherrima)",
                "La flor de nochebuena o flor de pascua es una especie nativa de México, la cual pertenece a la familia de las euforbiáceas como el ricino. Su nombre científico es Euphorbia pulcherrima y posee un enorme valor ornamental, siendo una de las plantas más cultivadas en todo el mundo.",
                "Son plantas delicadas, solo hay que recordar su origen tropical. Lo primero, retira el plástico en el que viene envuelta, porque asfixia las hojas. En invierno, los cuidados de la poinsettia para que no se quede lacia son claves: necesitan luz natural, así que busca una estancia con una humedad ambiental alta y pon la maceta en un rinconcito junto a una ventana, donde no llegue la calefacción. Las altas temperaturas suelen marchitan el follaje de la poinsettia.",
                "30 - 50cm",
                "60%",
                "16°C - 22°C"));
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
        elementPlants.add(new ListElementPlant((R.drawable.sample), "El verga larga",
                "Seasonal Plant Description",
                "Seasonal Plant Indications",
                "0cm",
                "0%",
                "0°C"));
        elementPlants.add(new ListElementPlant((R.drawable.sample), "Planta De Pino",
                "Lorem ipsum jasjaj",
                "Texto de cuidados",
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
        Intent intent = new Intent(SeasonalPlantsActivity.this, DetailsPlantsActivity.class);
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