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
        elementPlants.add(new ListElementPlant((R.drawable.camelia_min), "Camelia (Camellia)",
                "Las camelias se cultivaron en los jardines de China y Japón durante siglos antes de que se vieran en Europa.",
                "En cuanto a sus cuidados, debe estar ubicada en semi-sombra, no tolerará sol directo, pero si el frío intenso. No es conveniente cambiar de ubicación a nuestra Camelia, ya que sufre bastante con las variaciones (temperatura, riego, etc.). Le agrada mucho la iluminación.",
                "80cm - 2m",
                "60%",
                "5°C - 12°C"));
        elementPlants.add(new ListElementPlant((R.drawable.amarilis_min), "Amarilis (Amaryllis)",
                "El Amarilis es una planta bulbosa elegante donde las haya, compuesta por un gran bulbo del que salen uno o dos tallos florales antes de que comiencen a aparecer las hojas.",
                "Respecto al riego, lo ideal es que la tierra se mantenga siempre húmeda, pero evitando encharcamiento. Esta planta puede florecer año tras año, para ello, es recomendable mantener un periodo de reposo de aproximadamente 2 meses sin riego ni abono en un lugar fresco y oscuro.",
                "20cm - 40cm",
                "60%",
                "13°C - 18°C"));
        elementPlants.add(new ListElementPlant((R.drawable.ciclamen_min), "Ciclamen (Cyclamen)",
                "Es una de las plantas por excelencia del frío porque precisamente con él es cómo logra florecer. Una compañía natural que podemos disfrutar si conocemos los cuidados del Ciclamen y, además, descubrimos cómo alargar un poco más su floración. Porque, y aunque es poco sabido, si le damos a la planta lo que necesita sus flores pueden acompañarnos incluso durante cuatro meses.",
                "Aunque es poco sabido, el Ciclamen es una planta oriunda de la zona Mediterránea oriental; y son precisamente estos orígenes lo que marcan sus ciclos vitales. Acostumbrada a habitar en las áreas boscosas de estas regiones, la meteorología a la que está acostumbrada es la que marca de manera natural los cuidados del Ciclamen.",
                "30cm - 60cm",
                "40%",
                "16°C"));
        elementPlants.add(new ListElementPlant((R.drawable.espatifilo_min), "Espatifilo (Spathiphyllum)",
                "Esta planta perenne de origen sudamericano aporta mucha paz y tranquilidad a la casa. Además, es una de las plantas de interior más utilizadas para purificar el aire. Sus brillantes hojas tienen una elegante forma lanceolada y, en condiciones de buena iluminación, produce flores blancas, grandes y duraderas.",
                "Es una planta muy seductora para cualquier principiante porque es exquisita, se adapta a cualquier entorno y es fácil de cuidar.",
                "12cm  60cm",
                "35%",
                "20°C - 22°C"));
        elementPlants.add(new ListElementPlant((R.drawable.primula_min), "Prímula (Primula)",
                "Las prímulas, también conocidas cmula_omo primaveras o primaveras de jardín, es un género de plantas de la familia de las primuláceas. Es una planta perenne de crecimiento bajo con alrededor de 500 especies. Muchas de las especies de este género se dan espontáneamente en todo el hemisferio norte.",
                "Las prímulas se deben colocar en una zona fresca y luminosa, evitando la luz directa del sol. No soporta las altas temperaturas y, aunque tolera el frío, es muy susceptible a las heladas. Se multiplica por semillas y para su plantación se recomienda un sustrato bien aireado y rico en materia orgánica.",
                "20cm - 40cm",
                "40%",
                "14°C - 18°C"));
        elementPlants.add(new ListElementPlant((R.drawable.begonia_min), "Begonia (Begonia)",
                "El género Begonia comprende alrededor de 1500 especies, de las que alrededor de 150, además de casi 10 000 variedades e híbridos, se comercializan para su uso en jardinería. Son oriundas de las regiones tropicales y subtropicales de América, África y Asia.",
                "Las prímulas se deben colocar en una zona fresca y luminosa, evitando la luz directa del sol. No soporta las altas temperaturas y, aunque tolera el frío, es muy susceptible a las heladas. Se multiplica por semillas y para su plantación se recomienda un sustrato bien aireado y rico en materia orgánica.",
                "20cm - 40cm",
                "40%",
                "14°C - 18°C"));
        elementPlants.add(new ListElementPlant((R.drawable.narciso_min), "Narciso (Narcissus)",
                "Narcissus es un género de la familia Amaryllidaceae originario de la cuenca mediterránea y Europa. Comprende numerosas especies bulbosas, la mayoría con floración primaveral, aunque hay algunas especies que florecen en el otoño. En español, se le conoce como flor pato o narciso.",
                "Ubicación: semisombra. Sustrato: ligero para que drene bien y algo enriquecido con materia o abono orgánico. Riego: moderado pero cada poco tiempo para mantener un buen nivel de humedad, sin llegar a encharcar. Poda: solo hay que eliminar las flores y hojas secas.",
                "1cm - 22 cm",
                "30%",
                "16°C - 20°C"));
        elementPlants.add(new ListElementPlant((R.drawable.crisantemo_min), "Crisantemo (Chrysanthemum)",
                "El crisantemo es una de las flores con mayor diversidad de formas y colores. Pertenece a la familia de las compuestas y las hojas pueden ser lobuladas o dentadas, lingulosas o rugosas y están recubiertas por un polvillo blanquecino que le da un aspecto grisáceo. Casi siempre son muy aromáticas. Sus flores ofrecen una amplísima variedad de formas que van desde las más simples, tipo margarita, a las llamadas anémonas, tubulares, pompones, etc.",
                "Los crisantemos necesitan mucha luz, pero teniendo cuidado de que la exposición solar no sea directa, ya que podrían quemarse. Las condiciones de temperatura ambiente son normales; por eso, uno de los consejos para los crisantemos es que se ubiquen en una habitación bastante fresca y muy bien ventilada, ya que se marchitan enseguida si el ambiente es demasiado caluroso.",
                "1cm - 20cm",
                "60%",
                "13°C - 18°C"));
        elementPlants.add(new ListElementPlant((R.drawable.membrillero_japones_min), "Membrillero japonés (Chaenomeles japonica)",
                "Chaenomeles japonica es una especie de plantas del género Chaenomeles, familia de las rosáceas. Es nativa del este asiático.",
                "Regar moderadamente todo el año (2 riegos por semana) aumentando un poco el aporte de agua en verano si hace mucho calor. La poda es muy importante y se lleva a cabo tras la floración cortando las ramas sobre la segunda yema a partir de la rama principal.",
                "20cm - 3m",
                "60%",
                "-23°C"));

        elementPlants.add(new ListElementPlant((R.drawable.hortensiadeinvierno_min), "Hortensia de invierno ()",
                "Las prímulas, también conocidas como primaveras o primaveras de jardín, es un género de plantas de la familia de las primuláceas. Es una planta perenne de crecimiento bajo con alrededor de 500 especies. Muchas de las especies de este género se dan espontáneamente en todo el hemisferio norte.",
                "Las prímulas se deben colocar en una zona fresca y luminosa, evitando la luz directa del sol. No soporta las altas temperaturas y, aunque tolera el frío, es muy susceptible a las heladas. Se multiplica por semillas y para su plantación se recomienda un sustrato bien aireado y rico en materia orgánica.",
                "20cm - 40cm",
                "40%",
                "14°C - 18°C"));
        elementPlants.add(new ListElementPlant((R.drawable.prímula_min), "Prímula (Primula)",
                "Las prímulas, también conocidas como primaveras o primaveras de jardín, es un género de plantas de la familia de las primuláceas. Es una planta perenne de crecimiento bajo con alrededor de 500 especies. Muchas de las especies de este género se dan espontáneamente en todo el hemisferio norte.",
                "Las prímulas se deben colocar en una zona fresca y luminosa, evitando la luz directa del sol. No soporta las altas temperaturas y, aunque tolera el frío, es muy susceptible a las heladas. Se multiplica por semillas y para su plantación se recomienda un sustrato bien aireado y rico en materia orgánica.",
                "20cm - 40cm",
                "40%",
                "14°C - 18°C"));
        elementPlants.add(new ListElementPlant((R.drawable.prímula_min), "Prímula (Primula)",
                "Las prímulas, también conocidas como primaveras o primaveras de jardín, es un género de plantas de la familia de las primuláceas. Es una planta perenne de crecimiento bajo con alrededor de 500 especies. Muchas de las especies de este género se dan espontáneamente en todo el hemisferio norte.",
                "Las prímulas se deben colocar en una zona fresca y luminosa, evitando la luz directa del sol. No soporta las altas temperaturas y, aunque tolera el frío, es muy susceptible a las heladas. Se multiplica por semillas y para su plantación se recomienda un sustrato bien aireado y rico en materia orgánica.",
                "20cm - 40cm",
                "40%",
                "14°C - 18°C"));
        elementPlants.add(new ListElementPlant((R.drawable.prímula_min), "Prímula (Primula)",
                "Las prímulas, también conocidas como primaveras o primaveras de jardín, es un género de plantas de la familia de las primuláceas. Es una planta perenne de crecimiento bajo con alrededor de 500 especies. Muchas de las especies de este género se dan espontáneamente en todo el hemisferio norte.",
                "Las prímulas se deben colocar en una zona fresca y luminosa, evitando la luz directa del sol. No soporta las altas temperaturas y, aunque tolera el frío, es muy susceptible a las heladas. Se multiplica por semillas y para su plantación se recomienda un sustrato bien aireado y rico en materia orgánica.",
                "20cm - 40cm",
                "40%",
                "14°C - 18°C"));
        elementPlants.add(new ListElementPlant((R.drawable.prímula_min), "Prímula (Primula)",
                "Las prímulas, también conocidas como primaveras o primaveras de jardín, es un género de plantas de la familia de las primuláceas. Es una planta perenne de crecimiento bajo con alrededor de 500 especies. Muchas de las especies de este género se dan espontáneamente en todo el hemisferio norte.",
                "Las prímulas se deben colocar en una zona fresca y luminosa, evitando la luz directa del sol. No soporta las altas temperaturas y, aunque tolera el frío, es muy susceptible a las heladas. Se multiplica por semillas y para su plantación se recomienda un sustrato bien aireado y rico en materia orgánica.",
                "20cm - 40cm",
                "40%",
                "14°C - 18°C"));


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