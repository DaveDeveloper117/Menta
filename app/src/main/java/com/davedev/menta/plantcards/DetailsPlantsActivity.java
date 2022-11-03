package com.davedev.menta.plantcards;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.davedev.menta.R;
import com.davedev.menta.content.InteriorPlantsActivity;

public class DetailsPlantsActivity extends AppCompatActivity {
    TextView descNamePlant, descInfoPlant, descCarePlant, descInfoHeight, descInfoHumidity, descInfoTemperature;
    ImageView descImagePlant;
    LinearLayout linearLayoutFabs;
    Animation downMove, upMove, leftMove, rightMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_plants);

        ListElementPlant elementPlant = (ListElementPlant) getIntent().getSerializableExtra("ListElement");

        descNamePlant = findViewById(R.id.descNamePlant);
        descInfoPlant = findViewById(R.id.descInfoPlant);
        descCarePlant = findViewById(R.id.descCarePlant);
        descInfoHeight = findViewById(R.id.descInfoHeight);
        descInfoHumidity = findViewById(R.id.descInfoHumidity);
        descInfoTemperature = findViewById(R.id.descInfoTemperature);
        descImagePlant = findViewById(R.id.descImagePlant);
        linearLayoutFabs = findViewById(R.id.linearLayoutFabs);

        downMove = AnimationUtils.loadAnimation(DetailsPlantsActivity.this, R.anim.down_move);
        upMove = AnimationUtils.loadAnimation(DetailsPlantsActivity.this, R.anim.up_move);
        leftMove = AnimationUtils.loadAnimation(DetailsPlantsActivity.this, R.anim.left_move);
        rightMove = AnimationUtils.loadAnimation(DetailsPlantsActivity.this, R.anim.right_move);

        descNamePlant.setAnimation(upMove);
        descImagePlant.setAnimation(upMove);
        descInfoPlant.setAnimation(leftMove);
        descCarePlant.setAnimation(rightMove);
        linearLayoutFabs.setAnimation(upMove);

        descNamePlant.setText(elementPlant.getNamePlant());
        descInfoPlant.setText(elementPlant.getDescriptionPlant());
        descCarePlant.setText(elementPlant.getSupportPlant());
        descInfoHeight.setText(elementPlant.getHeightPlant());
        descInfoHumidity.setText(elementPlant.getHumidityPlant());
        descInfoTemperature.setText(elementPlant.getTemperaturePlant());
        descImagePlant.setImageResource(elementPlant.getImagePlant());
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailsPlantsActivity.this, InteriorPlantsActivity.class);
        startActivity(intent);
        finish();
    }
}