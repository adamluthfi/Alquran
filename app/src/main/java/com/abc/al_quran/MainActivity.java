package com.abc.al_quran;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.abc.al_quran.fragment_surat.FragmentAlanam;
import com.abc.al_quran.fragment_surat.FragmentAlbaqarah;
import com.abc.al_quran.fragment_surat.FragmentAlfatihah;
import com.abc.al_quran.fragment_surat.FragmentAlimran;
import com.abc.al_quran.fragment_surat.FragmentAlmaidah;
import com.abc.al_quran.fragment_surat.FragmentAnnisa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentAlfatihah(),"Al-Fatihah");
        adapter.addFragment(new FragmentAlbaqarah(),"Al-Baqarah");
        adapter.addFragment(new FragmentAlimran(),"Ali'Imran");
        adapter.addFragment(new FragmentAnnisa(),"An-Nisa");
        adapter.addFragment(new FragmentAlmaidah(),"Al-Ma'idah");
        adapter.addFragment(new FragmentAlanam(),"Al-An'am");
        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
