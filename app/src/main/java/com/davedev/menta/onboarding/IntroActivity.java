package com.davedev.menta.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.davedev.menta.R;
import com.davedev.menta.menu.DashboardActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    MaterialButton btnNext, btnStart;
    int position = 0;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        tabIndicator = findViewById(R.id.tab_indicator);
        btnNext = findViewById(R.id.btn_next);
        btnStart = findViewById(R.id.btn_start);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up_move);
        btnStart.setVisibility(View.GONE);

        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Aprende los cuidados", "Las plantas son tus mejores compañeros, necesitan los mejores cuidados, por ello te recomendamos como hacerlo de manera correcta y efectiva.", R.raw.plants));
        mList.add(new ScreenItem("Descubre nuevas plantas", "¿Aún no sabes que planta elegir?, no te preocupes nosotros te ayudamos cuál elegir, explora entre las distintas variedades de plantas.", R.raw.plant_potted));
        mList.add(new ScreenItem("Conoce sus características", "Cada planta es un mundo nuevo, son diferentes seres vivos y nosotros te enseñamos a que te temperatura crecen, la humedad y el tamaño que alcanzan.", R.raw.phone_plant));

        screenPager = findViewById(R.id.screenPager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        tabIndicator.setupWithViewPager(screenPager);

        btnNext.setOnClickListener(view -> {
            position = screenPager.getCurrentItem();
            if (position < mList.size()){
                position++;
                screenPager.setCurrentItem(position);
            }
            if (position == mList.size()-1){
                loadLastScreen();
            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnStart.setOnClickListener(view -> {
            Intent intent = new Intent(IntroActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void loadLastScreen(){

        btnNext.setVisibility(View.INVISIBLE);
        btnStart.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.VISIBLE);
        //btnStart.setAnimation(btnAnim);

    }
}