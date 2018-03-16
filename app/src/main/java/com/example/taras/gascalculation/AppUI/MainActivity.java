package com.example.taras.gascalculation.AppUI;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.taras.gascalculation.AppUI.BaseActivity;
import com.example.taras.gascalculation.AppUI.InPutFragment;
import com.example.taras.gascalculation.AppUI.PagerAdapter;
import com.example.taras.gascalculation.AppUI.ResultFragment;
import com.example.taras.gascalculation.R;

public class MainActivity extends BaseActivity implements
        InPutFragment.OnFragmentInteractionListener,
        ResultFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout_ID);
        tabLayout.addTab(tabLayout.newTab().setText("Gas Description"));
        tabLayout.addTab(tabLayout.newTab().setText("Values Result"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager_ID);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
