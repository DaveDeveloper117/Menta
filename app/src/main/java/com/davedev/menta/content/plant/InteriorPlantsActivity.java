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
        elementPlants.add(new ListElementPlant((R.drawable.monstera_adansonii_min), "Piña Anona (Monstera Adansonii)",
                "La monstera adansonii es una planta nativa de América del sur, América central y en las Islas del Caribe.Es una de las plantas más \"pequeñas\" de la familia, aunque puede llegar a los 3 metros de alto en buenas condiciones.",
                "La monstera adansonii prefiere la luz indirecta. Nunca la pongas bajo el sol directo, ya que las hojas se queman y la planta acaba muriendo.",
                "20cm - 30cm",
                "50% - 90%",
                "15°C - 20°C"));
        elementPlants.add(new ListElementPlant((R.drawable.Planta_Elefante_main), "Planta de Elefante (Beaucarnea recurvata)",
                "Es una original y elegante planta de interior originaria del desierto meridional de México. Es una planta suculenta que, al igual que los cactus, crea su propio depósito de agua dentro del tronco.",
                "Estas plantas, sobre todo en temporada de crecimiento, se riegan, de forma general, una vez cada 7 o 14 días.",
                "2.5mts - 7mts",
                "60% - 70%",
                "15°C - 22°C"));
        elementPlants.add(new ListElementPlant((R.drawable.Collar_Corazon_main), "Collar de Corazon (CEROPEGIA WOODII)",
                "Se trata de una vivaz suculenta nativa de las regiones del este de Sudáfrica, de fácil cuidado. Sus carnosas hojas, gruesas y de textura cerosa, son pequeñas —de 1-2 centímetros— y suelen tener forma de corazón o manzana.",
                "Necesita mucha luz —incluso puede recibir el sol suave de la mañana— para que el follaje no pierda color. El sustrato debe ser humífero, pero muy bien drenado y pobre en nitrógeno. Agradece los aportes de abono rico en fósforo.",
                "2cm - 5cm",
                "60% - 50%",
                "16°C - 21°C"));
        elementPlants.add(new ListElementPlant((R.drawable.Rosario_main), "Planta de Rosario (SENECIO ROWLEYANUS)",
                "Este senecio es una planta suculenta, perenne y de porte colgante, caracterizada por unos tallos alargados y muy delgados rodeados de hojas verdes cilíndricas y carnosas. Estas hojas en realidad son una reserva de agua, la cual le permite a la planta sobrevivir durante periodos de sequía.",
                "Esta planta necesita de mucha luz, pero de forma indirecta o con poca intensidad.",
                "15cm - 30cm",
                "50% - 90%",
                "60°C - 80°C"));
        elementPlants.add(new ListElementPlant((R.drawable.Oracion_main), "Planta de la Oraciòn (MARANTA LEUCONERA)",
                "La Maranta leuconeura también es conocida como planta de la oración, debido a que cada noche repliega sus hojas y durante el día las expande. Se trata de una planta de interior perenne de la familia de las 'Marantáceas' y es originaria de las selvas tropicales de América del Sur (más concretamente de Brasil).",
                "La Flor de la Oración requiere mucha luz, pero nunca directa. Su especie nació protegida por la copa de los árboles más altos, así que no está acostumbrada a sentir el beso directo de los rayos solares. Ubícala en un lugar a la sombra pero iluminado, donde no reciba el sol directo porque puede quemar su hojas.",
                "20cm - 30cm",
                "30% - 50%",
                "18°C - 20°C"));
        elementPlants.add(new ListElementPlant((R.drawable.anturio_main), "Anturio (Anthurium)",
                "El anturio es una planta de interior exótica y elegante, con más de 1.000 especies distintas. Sus hojas brillantes verdes y sus preciosas hojas modificadas, que parecen flores rojas, en forma de corazón y de larga duración, decoran la casa durante todo el año.",
                "En nuestra lista de cómo cuidar un anthurium el riego es, sin duda, la tarea que más tendremos que vigilar. Y es que, aunque sea una planta tropical, no tolera el exceso de agua en sus raíces ni demanda humedad constante en el sustrato.",
                "10cm - 15cm",
                "30% - 50%",
                "20°C - 25°C"));
        elementPlants.add(new ListElementPlant((R.drawable.pluma_main), "Pluma Rosa (TILLANDSIA)",
                "Lucida y llamativa por su color y por su forma y bastante fácil de cultivar. Lo que hace que sea diferente es que del centro de la planta nace una bráctea, que parece una flor pero en realidad es una hoja, con forma de espiga y un color rosa intenso. Alrededor, hojas verdes, largas y curvadas.",
                "La pluma rosa no es demasiado exigente con sus cuidados, pero agradece el clima templado y necesita mucha luz indirecta.",
                "20cm - 25cm",
                "20% - 60%",
                "15°C - 25°C"));
        elementPlants.add(new ListElementPlant((R.drawable.cactus_main), "Cactus (Cactaceae)",
                "Los cactus son plantas pertenecientes a la familia Cactaceae, originaria de América, caracterizada por presentar modificaciones en sus estructuras vegetativas como areolas, tallos suculentos y hojas reducidas a espinas, en la mayoría de las especies.",
                "Necesitan mucha luz, por lo que el lugar ideal es delante de la ventana. En verano agradecerán que les saques al balcón o a la terraza, pero no necesitan una iluminación directa del sol, un factor importante si quieres cuidar las plantas de cara al verano.",
                "30cm - 1mts",
                "15% - 30%",
                "30°C - 70°C"));
        elementPlants.add(new ListElementPlant((R.drawable.violeta_main), "Violeta Africana (Saintpaulia)",
                "Cuyas especies son comúnmente llamadas violeta africana, es un género con 6 especies perteneciente a la familia Gesneriaceae nativo de Tanzania y sureste de Kenia en el este de África tropical, con una concentración de especies en las montañas Nguru de Tanzania.",
                "Necesitan mucha luz, aunque, salvo en invierno, no deben quedar expuestas directamente al sol. La violeta africana es una planta que no precisa demasiados abonos, pero si quieres que florezca todo el año puedes utilizar un fertilizante que contenga nitrógeno, potasio y fósforo en cantidades iguales.",
                "10cm - 15cm",
                "30% - 40%",
                "24°C - 29°C"));
        elementPlants.add(new ListElementPlant((R.drawable.espatifilo_main), "Espatifilo (Spathiphyllum)",
                "Sus brillantes hojas tienen una elegante forma lanceolada y, en condiciones de buena iluminación, produce flores blancas, grandes y duraderas. Es una planta muy seductora para cualquier principiante porque es exquisita, se adapta a cualquier entorno y es fácil de cuidar.",
                "Deja que se seque la tierra entre riegos o cuando veas que las hojas apuntan hacia bajo. Procura aportarle agua libre de cloro: bastará con que dejes reposar el agua del grifo toda la noche para que se evapore el cloro.",
                "45cm - 1mts",
                "50% - 70%",
                "20°C - 22°C"));

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