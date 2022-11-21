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
        elementPlants.add(new ListElementPlant((R.drawable.girasol_main), "Girasoles (Helianthus annuus)",
                "El girasol es el símbolo del Sol y simboliza el amor y la admiración. Pero también la felicidad, la vitalidad, el positivismo y la energía. En la cultura china simboliza una larga vida y buena suerte.\n",
                "Si queremos saber cómo cuidar girasoles en maceta, lo más importante es buscarles una ubicación muy soleada, junto a alguna ventana o fuente de luz. Lo ideal es que reciba al menos 6 horas de luz directa diaria. Es recomendable que la maceta sea bastante profunda.",
                "2mts - 3mts",
                "10% - 20%",
                "20°C - 25ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.crisan_main), "Crisantemos (Chrysanthemum)",
                "Los crisantemos son flores ideales para expresar todo tipo de emociones positivas como la felicidad, la longevidad, la alegría y, por supuesto, el amor y la belleza. Además, son la flor del mes de noviembre.",
                "El único cuidado clave que necesitan los crisantemos para sobrevivir lozanos y hermosos es vigilar el riego y mantenerlos bien regados, especialmente si no llueve o si el otoño es cálido.",
                "30cm - 1mts",
                "30% - 40%",
                "13°C - 18ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.ave_min), "Ave de Paraìso (Strelitzia reginae)",
                "Así mismo, la flor ave del paraíso también está relacionada con el amor y la fidelidad, ya que hay diversas especies de pájaros que son fieles a su pareja hasta el día de su muerte, por lo que es muy común que estas plantas sean un regalo para nuestros seres amados.",
                "Esta planta tropical vive bien tanto en interior como en exterior. Acostumbramos a verla en maceta pero es ideal también para plantar en el jardín ya que sus raíces no son invasivas. ",
                "1mts - 2mts",
                "30% - 40%",
                "10°C - 20ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.calen_min), "Caléndulas (Calendula officinalis)",
                "Calendula officinalis, de nombre común (entre otros) botón de oro, caléndula, flor del muerto, mercadela, maravilla, es una hierba de la familia de las asteráceas. Planta herbácea, aromática, glandular, de anual a perenne, leñosa únicamente en la base.",
                "Para poder disfrutar de la Caléndula en todo su esplendor, tendremos que ubicarla a pleno sol. A pesar de que la proliferación en nuestro país procede del Mediterráneo, sus orígenes son todavía más soleados.",
                "20cm - 55cm",
                "30% - 45%",
                "18°C - 24ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.came_min), "Camelia (Camellia)",
                "El género Camellia agrupa entre 100 y 250 especies (hay cierta controversia sobre el número exacto) originarias de las regiones tropicales y subtropicales de Asia sudoriental, China y Japón. Se las encuentra en los bosques situados a media altura sobre el nivel del mar.",
                "En cuanto a sus cuidados, debe estar ubicada en semi-sombra, no tolerará sol directo, pero si el frío intenso.",
                "80cm - 2mts",
                "70% - 80%",
                "10°C 15ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.loto_min), "Flor de Loto (Nelumbo nucifera)",
                "En el budismo representa la pureza de cuerpo y alma. Crece en aguas lodosas que representa los deseos carnales y la flor, que crece sobre ella, muestra una promesa de elevación espiritual. Se suele asociar con el dios Buda, dándole así un carácter sagrado.",
                "Para cultivar la flor de loto debes colocar las semillas en un vaso de agua tibia sin cloro, que tendrás que cambiar todos los días hasta que tus semillas germinen. ¡No lo olvides! Si lo has hecho bien, después del primer día en agua, tus semillas deberán haber crecido casi el doble de su tamaño original.",
                "15cm - 25cm",
                "70% - 80%",
                "22°C 32ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.dalia_min), "Dalias (Dahlia)",
                "Pertenece a la familia Asteraceae también conocida como Compositae (Compuestas). Este nombre se debe a la estructura de la flor que consiste de una cabeza (cabezuela) con muchas flores pequeñas (llamadas flores del disco) rodeadas de unos pétalos grandes.",
                "Riega con frecuencia y en abundancia, unas 3 veces por semana y preferiblemente por la noche, y hazlo sobre la tierra, sin mojar las hojas y las flores.",
                "16cm - 23cm",
                "70% - 80%",
                "22°C 32ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.tulipan_min), "Tulipanes (Tulipa)",
                "Los tulipanes son plantas bulbosas (almacenan nutrientes en estructuras subterráneas) que suelen tener un tallo simple que puede medir hasta sesenta centímetros. Sus hojas, lanceoladas, son grandes. En la parte superior del escapo aparece la flor, también de dimensiones importantes, que se caracteriza por sus colores.",
                "Si mantenemos los bulbos en el interior de casa, es necesario colocar el tiesto cerca de una ventana o bien, en un lugar con buena iluminación. Para que los tulipanes se desarrollen correctamente las temperaturas deben oscilar entre 15 ºC y 20 ºC y nunca bajar de 5 ºC o la planta enfermará y difícilmente se recuperará.",
                "30cm - 1mts",
                "70% - 85%",
                "13°C 16ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.maracuya_min), "Maracuyá (Passiflora edulis)",
                "La maracuyá es una fruta tropical o también llamada fruta de la pasión, de un sabor un poco ácido y con aroma. Las variedades en tamaño, color y sabor, actualmente 40 países utilizan la maracuyá en el campo comercial para satisfacer las necesidades del mercado.",
                "Mantén la planta a una temperatura de entre 18-27 °C en un sitio luminoso y soleado. Riega la maracuyá planta libremente, tres veces por semana, para que el compost se mantenga húmedo. Agrega un fertilizante líquido todas las semanas entre marzo y septiembre.",
                "6mts - 9mts",
                "40% - 60%",
                "18°C 27ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.margarita_min), "Margarita (Bellis perennis)",
                "La margarita es una planta semiarbustiva, perenne, cuya altura varía entre 30 centímetros y un metro, aunque lo normal es que alcance unos 70 centímetros. Sus hojas son verdes y sus flores, muy conocidas: pétalos alargados y blancos (aunque pueden ser de más colores), en torno a un botón circular amarillo.",
                "La mejor temperatura para un buen desarrollo es entre 15º C y 25º C, aunque se adapta bien tanto al frío como al calor, incluso heladas. Riego: Hay que hacerlo regularmente en verano cada 2 ó 3 días y en invierno cada 15 días, evitando encharcamiento; por eso, el riego de la margaritas debe ser cuidadoso.",
                "30cm - 1mts",
                "30% - 50%",
                "15°C 25ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.orquidea_min), "Orquìdea (Orchidaceae)",
                "Las orquídeas u orquidáceas (nombre científico Orchidaceae) son una familia de plantas monocotiledóneas que se distinguen por la complejidad de sus flores y por sus interacciones ecológicas con los agentes polinizadores y con los hongos con los que forman micorrizas.",
                "La mayoría de orquídeas necesitan estar en un lugar bien iluminado donde no reciban sol directo. Te recomendamos que las sitúes cerca de una ventana, evitando fuentes de calor y corrientes. Si el sol incide excesivamente en alguna hora del día, los visillos son suficientes para filtrar la luz.",
                "30cm - 1mts",
                "80% - 90%",
                "10°C 30ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.lirio_min), "Lirios (Lilium)",
                "El Lilium es un género de herbáceas bulbosas perteneciente a la familia de las Liliáceas, es originaria de las zonas templadas de Eurasia y América del Norte. Las azucenas o lirios florecen a partir de primavera, pero es hasta el verano cuando alcanzan su mayor esplendor.",
                "Debemos mantener la tierra fresca y el riego dependerá de la variedad. Riega las macetas varias veces por semana en verano, y en otoño elimina y tira los que se hayan helado al compuesto organico.",
                "10cm - 25cm",
                "25% - 45%",
                "22°C 26ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.sangrante_min), "Corazon Sangrante (Dicentra)",
                "De la familia de las amapolas (la familia Papaveraceae), la corazón sangrante es una especie de planta cultivada como ornamental en zonas húmedas, templadas y sombreadas. Es una de las escasas plantas que no soporta bien el calor, y que regularmente acabará perdiendo sus hojas y entrando en hibernación.",
                "En los climas más secos y templados, la planta del corazón sangrante deberá colocarse a sombra parcial o total. Sin embargo, en climas más fríos y húmedos pueden llegar a soportar el sol sin ningún problema.",
                "70cm - 80cm",
                "30% - 50%",
                "12°C 23ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.campana_min), "Campanillas (Campanula)",
                "La campanilla silvestre es una planta perenne glabra, erguida y alta, hermosa. Se ha cultivado como planta ornamental por lo menos desde el siglo XVII. A nivel autóctono está presente en laderas herbosas y en bosques de frondosas. La alteración humana la favorece.",
                "Los cuidados que requiere son sencillos, basta con mantener la tierra algo húmeda, con un riego a demanda, pero con cuidado de no encharcarla. Necesita luz natural, recibir un poco de sol de la mañana le vendrá muy bien, y es que las plantas con flores es recomendable ubicarlas cerca de la ventana.",
                "2mts - 4mts",
                "40% - 70%",
                "12°C 23ºC"));
        elementPlants.add(new ListElementPlant((R.drawable.rosa_min), "Rosa (Rosa)",
                "Las hojas de las rosas son alternas, ásperas, pecioladas, compuestas de un número impar de foliolos elípticos, con forma de sierra en los márgenes. Las flores son terminales, solitarias o en racimo, con el cáliz aovado o redondo.",
                "Elije un florero limpio y llenarlo con agua del grifo a temperatura ambiente. Añade alimento para flores cortadas al agua para una vida útil más larga. Corta el tallo 3-5 cm en diagonal con un cuchillo o tijeras de podar y que estén limpias y afiladas. Asegúrate de que no hay hojas en el agua.",
                "2mts - 5mts",
                "30% - 60%",
                "40°C 50ºC"));

        listAdapterPlant = new ListAdapterPlant(elementPlants, this, this::moveToDescription);

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