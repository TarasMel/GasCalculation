package com.example.taras.gascalculation;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

public class MainActivity extends BaseActivity implements
        LauncherFragment.OnFragmentInteractionListener,
        ResultFragment.OnFragmentInteractionListener{

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout_ID);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}


 /*EditText editMethane;
    EditText editMonoxide;
    EditText editHydrogen;
    EditText editDioxide;
    EditText editNitrogen;
    Button btn_getResult;
    Button btn_Check;
    Button btn_about;

    ArrayList<String> listEntry;*/

         /*editMethane = (EditText) findViewById(R.id.editMethane_ID);
        editMonoxide = (EditText) findViewById(R.id.editMonoxide_ID);
        editHydrogen = (EditText) findViewById(R.id.editHydrogen_ID);
        editDioxide = (EditText) findViewById(R.id.editDioxide_ID);
        editNitrogen = (EditText) findViewById(R.id.editNitrogen_ID);

        btn_about = (Button) findViewById(R.id.btn_About);
        btn_Check = (Button) findViewById(R.id.btn_Check);
        btn_getResult = (Button) findViewById(R.id.btn_getResult);
        //adding to list view
        listEntry = new ArrayList<>();
        listEntry.add(editMethane.toString());
        listEntry.add(editMonoxide.toString());
        listEntry.add(editHydrogen.toString());
        listEntry.add(editDioxide.toString());
        listEntry.add(editNitrogen.toString());



        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                toastMessage(res.getString(R.string.for_btn_about));
            }
        });
        btn_Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking logic
                toastMessage("Lalalalalalalala");
            }
        });
        });*/