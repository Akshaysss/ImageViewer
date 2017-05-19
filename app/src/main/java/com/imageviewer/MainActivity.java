package com.imageviewer;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.imageviewer.fragments.RV_Fragment;
import com.imageviewer.fragments.RV_Fragment2;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Gallery"));
        tabLayout.addTab(tabLayout.newTab().setText("Favourites"));
        tabLayout.addTab(tabLayout.newTab().setText("Saved"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.ViewPager);
        final PagerAdapter adapter = new PagerAdapter
                (getFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }  */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
      /*  if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }



    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(getSupportFragmentManager());
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    RV_Fragment tab1 = new RV_Fragment();
                    return tab1;
                case 1:
                    RV_Fragment tab2 = new RV_Fragment();
                    return tab2;
                case 2:
                    RV_Fragment2 tab3 = new RV_Fragment2();
                    return tab3;
                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

}





 /* class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int i) {
            android.support.v4.app.Fragment fragment = null;
            Log.d("AJ", "get Item is called" + i);
            if (i == 0) {
                fragment = new RV_Fragment();
            }
            if (i == 1) {
                fragment = new RV_Fragment2();
            }
            if (i == 2) {
                fragment = new RV_Fragment();
            }
            return fragment;

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return " Gallery";
            }
            if (position == 1) {
                return "Tab 2";
            }
            if (position == 2) {
                return "Favourites";
            }
            return null;
        }

    }*/

