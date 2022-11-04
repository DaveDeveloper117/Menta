package com.davedev.menta.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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

        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Title Text", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed lacus sem, lobortis nec semper in, vestibulum id orci.", R.raw.plants));
        mList.add(new ScreenItem("Title Text", "Curabitur quis erat nec leo aliquet porta. Nullam rutrum, felis eu sodales tincidunt, odio erat porta mi, egestas tincidunt dui justo eget leo.", R.raw.plant_potted));
        mList.add(new ScreenItem("Title Text", "Vestibulum nunc eros, rutrum vitae interdum nec, dictum eu lorem. Curabitur sed erat enim. Duis molestie varius nisl vel euismod.", R.raw.phone_plant));

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
        tabIndicator.setVisibility(View.INVISIBLE);
        btnStart.setAnimation(btnAnim);

    }
}