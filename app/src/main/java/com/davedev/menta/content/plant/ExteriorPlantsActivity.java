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
        elementPlants.add(new ListElementPlant((R.drawable.hemerocalis_min), "Hemerocalis (Hemerocallis)",
                "Las hemerocalis (Hemerocallis) conocidas como lirios de San Juan, lirios de la mañana o azucenas amarillas son muy valoradas por sus flores perfumadas con aroma a azahar. Florecen entre finales de primavera y principios de otoño. Si plantas distintas variedades mezcladas puedes tener multitud de flores desde la primavera hasta el otoño. ",
                "Prefieren estar en semisombra y en suelos que no se encharquen.",
                "60cm - 80cm",
                "50% - 70%",
                "15°C - 20ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.clivia_min), "Clivia (Clivia miniata)",
                "Muy apreciada hace años, la clivia (Clivia miniata) ha vuelto con fuerza gracias a sus infinitas bondades. Es una planta herbácea con gruesas hojas planas en color verde oscuro y grandes flores anaranjadas. Florece desde finales de invierno o principios de la primavera hasta mitad del verano.",
                "Es muy resistente, y admite el cultivo en maceta en el exterior y como planta interior. No tolera estar a pleno sol.",
                "30cm - 50cm",
                "30% - 50%",
                "18°C - 20ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.convalaria_min), "Convalaria (Ophiopogon japonicus)",
                "La convalaria (Ophiopogon japonicus) son matas herbácea densas que van cubriendo el suelo en colonias. Se usan tanto como plantas tapizantes como planta ornamental en borduras, bajo los árboles, junto a los estanques o en macetas. Sus hojas son largas y estrechas y produce flores de color rosa claro, lila claro o blanco, seguidas de unos atractivos frutos de color azul porcelana, del tamaño de un guisante.",
                "Prefiere las zonas sombreadas o moderadamente soleadas.",
                "15cm - 30cm",
                "20% - 40%",
                "25°C - 30ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.aspidistra_min), "Aspidistra (Aspidistra Elatior)",
                "A la aspidistra (Aspidistra elatior) se la conoce también como hoja de salón, hoja de lata o planta de portería. Presenta unas hojas muy apreciadas en floristería que se usan para cerrar los ramos.",
                "Además, es una planta muy resistente que puede vivir en condiciones extremas de falta de luz, lo que permite colocarla en zonas sombreadas del jardín. Debe regarse con moderación.",
                "1mts - 1.25mts",
                "40% - 60%",
                "15°C - 21ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.agapanto_min), "Agapanto (Hemerocallis)",
                "También conocido como flor del amor o lirio africano, el agapanto (Agapanthus africanus) es una planta de exterior muy valorada porque todo el año presenta un exuberante follaje de gran valor ornamental.",
                "Se trata de una planta muy resistente que se emplea para macetas o como cubresuelos formando macizos.",
                "30cm - 1mts",
                "25% - 40%",
                "5°C - 8ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.pita_min), "Pita (Agave)",
                "Las pitas o agaves (Agave) como el resto de cactus, crasas y plantas suculentas, son las estrellas principales de los jardines de cero mantenimiento. Su punto fuerte: que no requieren casi agua ni mantenimiento",
                "Su punto débil: que no llevan nada bien el frío ni el exceso de agua. Como en otros casos, también pueden prosperar en maceta o contenedor. ",
                "3mts - 5mts",
                "20% - 45%",
                "15°C - 25ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.yuca_min), "Yuca (Yucca)",
                "Las yucas (Yucca) son unas plantas con un porte parecido a las palmeras que resultan muy agradecidas porque son muy poco exigentes a nivel de mantenimiento. ",
                "Además de poderse cultivar tanto en el suelo como en maceta, también hay variedades que se usan como planta de interior.",
                "2mts - 3mts",
                "60% - 65%",
                "16°C - 38ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.palmito_min), "Palmito (Chamaerops humilis)",
                "El palmito (Chamaerops humilis) aguanta muy bien la sequía pero no las heladas prolongadas. Se puede cultivar tanto en el suelo como en maceta.",
                "Uno de sus mayores atractivos, junto con su porte y su aspecto exuberante, es que no requiere prácticamente ningún mantenimiento.",
                "1mts - 4mts",
                "40% - 50%",
                "17°C - 23ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.trebol_min), "Trebol (Trifolium)",
                "El trébol (Trifolium) es una planta tapizante que funciona muy bien como alternativa al césped. Además, tiene una floración muy bonita.",
                "Su único inconveniente es no tolera demasiado bien el pisado por lo que no se recomienda ponerlo en zonas de mucho paso del jardín. ",
                "10cm - 50cm",
                "30% - 50%",
                "18°C - 35ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.hiedra_min), "Hiedra (Hedera)",
                "La hiedra (Hedera) está en la lista de las mejores plantas de exterior por su versatilidad y escaso mantenimiento. Se puede usar como planta trepadora para cubrir paredes, muros o cercados, y también como rastrera o tapizante para cubrir trozos de tierra o parterres sin tener que recurrir al césped.",
                "Esta especie vegetal no necesita mucha cantidad de agua, por lo que se riega cada dos días en verano y en invierno una vez al día. Es importante que vigiles el drenaje para que sea eficaz si tienes una hiedra de interior, de ahí que se pueda sembrar en macetas con autorriego.",
                "5cm - 20cm",
                "10% - 20%",
                "12°C - 20ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.glicina_min), "Glacina (Wisteria sinensis)",
                "Entre sus pros destaca su rústica y espectacular floración de color violeta o malva. Vive bien en cualquier terreno o exposición. Por otro lado, es tan fuerte que puede llegar a romper las estructuras por las que trepa y se va enroscando. ",
                "Aunque aguanta los periodos de sequía, la Wisteria sinensis necesita como norma riegos frecuentes en verano, o al menos los suficientes para mantener cierta humedad en el sustrato. No le gusta que éste seque por completo, pero tampoco que permanezca encharcado.",
                "5mts - 15mts",
                "40% - 50%",
                "10°C - 20ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.jazmin_min), "Jazmin Chino (Trachelospermum jasminoides)",
                "El falso jazmín o traquelospermo (Trachelospermum jasminoides) es un arbusto trepador muy apreciado. Además de tener una espectacular floración muy olorosa, tiene una foliación densa que no pierde a no ser que haga mucho frío.",
                "Sus raíces se pudren si riegas demasiado a menudo, así que necesitas esperar a que la tierra o el sustrato se hayan secado más allá de la capa superficial antes de volver a regar.",
                "2mts - 4mts",
                "40% - 50%",
                "7°C - 15ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.tecomaria_min), "Tecomaria (Tecomaria capensis)",
                "La tecomaria (Tecomaria capensis), también conocida como bignonia o madreselva del Cabo, es un arbusto con flores rojas o rosas muy apreciado porque florece desde principios de otoño hasta final del invierno.",
                "Se puede utilizar como trepadora o como arbusto ornamental aislado, y también puede vivir en maceta. Es poco exigente y, una vez adaptada al terreno, tolera la sequía. ",
                "3mts - 8mts",
                "20% - 30%",
                "15°C - 25ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.buganvilia_min), "Bugamvilia (Bougainvillea)",
                "La buganvilla (Bougainvillea) es una planta trepadora y espinosa muy apreciada por su espectacular floración (de colores fucsias, rosas, blancos...), su versatilidad (sirve para cubrir muros y pérgolas, hacer setos o cultivarse en maceta), y porque no exige mucho mantenimiento.",
                "Florece en primavera, verano y hasta principios del otoño. Aguanta la sequía, pero no las heladas prolongadas ni el encharcamiento. ",
                "5mts - 10mts",
                "25% - 50%",
                "20°C - 40ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.clemadite_min), "Clemadite (Clematis)",
                "Las clemátides (Clematis) son otras plantas de exterior muy valoradas. Esta familia engloba alrededor de 300 especies de plantas herbáceas y trepadoras muy cotizadas por su prolongado período de floración (de primavera a principios de otoño).",
                "Admite el cultivo en maceta y es ideal para cubrir pérgolas y tapizar muros y vallas. Resiste muy bien los cambios climáticos y el frío, pero quiere tierras ricas y húmedas. ",
                "1mts - 3mts",
                "70% - 80%",
                "10°C - 25ºC"));



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