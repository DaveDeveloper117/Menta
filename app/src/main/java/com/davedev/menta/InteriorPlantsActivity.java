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

public class InteriorPlantsActivity extends AppCompatActivity{

    List<ListElementPlant> elementPlants;
    SearchView searchView;
    ListAdapterPlant listAdapterPlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interior_plants);

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
        Intent intent = new Intent(InteriorPlantsActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    public void init(){
        elementPlants = new ArrayList<>();
        elementPlants.add(new ListElementPlant((R.drawable.ficus_lyrata_min), "Higuera Hoja de Violín (Ficus lyrata)",
                "Es un baniano que generalmente comienza su vida como una epífita en lo alto de la copa de otro árbol, luego envía raíces al suelo que envuelven el tronco del árbol huésped y lo estrangulan lentamente.",
                "El ficus lyrata necesita luz indirecta. Si lo ponemos bajo luz directa las hojas se empiezan a quemar.",
                "30cm - 45cm",
                "40% - 60%",
                "15°C - 25°C"));
        elementPlants.add(new ListElementPlant((R.drawable.monstera_deliciosa_min), "Costilla de Adán (Monstera Deliciosa)",
                "La característica más llamativa son sus espectaculares hojas verdes que pueden llegar a los 90 centímetros de largo y 80 de ancho.",
                "La monstera deliciosa es una enredadera. Si clavas guías de madera en la maceta, la planta las usará para escalar y crecer a lo alto.",
                "80cm - 90cm",
                "30% - 40%",
                "15°C - 20°C"));
        elementPlants.add(new ListElementPlant((R.drawable.oxalis_adenophylla_min), "Trébol de plata (Oxalis Adenophylla)",
                "Sus hojas están divididas en muchas partes (llamadas folíolos), habitualmente alrededor de 10. Al contrario que otros miembros de la familia, las partes de la hoja son alargadas y ovaladas.",
                "Estas plantas almacenan \"energía\" en bulbos bajo tierra. Si pasa mucho tiempo sin riego y las hojas se caen, no significa que la planta esté muerta. ",
                "10cm - 15cm",
                "40% - 50%",
                "15°C - 25°C"));
        elementPlants.add(new ListElementPlant((R.drawable.calathea_lutea_min), "Hoja Blanca (Calathea Lutea)",
                "Sus hojas se usan para envolver distintos alimentos. Comúnmente para empaquetar tamales y algunos dulces. También se usa en algunas recetas, como el ayampaco y el maito en Ecuador. En ocasiones, sus hojas se usan para cubrir techos. Y el jugo de sus raíces y tallos se usan como diurético.",
                "Si quieres potenciar su crecimiento, usa fertilizante para plantas de interior una vez al mes durante la primavera y el verano. Durante el invierno no es necesario..",
                "60cm - 90cm",
                "20% - 40%",
                "20°C - 30°C"));
        elementPlants.add(new ListElementPlant((R.drawable.peperomia_incana_min), "Pimiento Fieltro (Peperomia Incana)",
                "Es una planta compacta en altura y envergadura, con cuidados sencillos, lo que la hace una planta de interior ideal. Sus hojas tienen forma de corazón y son de un color verde pálido. Quizá no es la Peperomia más atractiva de la familia, pero es ideal para principiantes.",
                "La Peperomia polybotrya necesita bastante luz indirecta aunque tolera bien la falta de luz. Cuidado con la luz directa del sol porque quema sus hojas.",
                "15cm - 30cm",
                "40% - 60%",
                "15°C - 25°C"));

        listAdapterPlant = new ListAdapterPlant(elementPlants, this, this::moveToDescription);

        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        recyclerView.setAdapter(listAdapterPlant);
    }

    public void moveToDescription(ListElementPlant item){
        Intent intent = new Intent(InteriorPlantsActivity.this, DetailsPlantsActivity.class);
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