package com.example.aplikasisistemdeteksikebakarankosharapanbunda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aplikasisistemdeteksikebakarankosharapanbunda.Fragment.Pengaturan_Fragment;
import com.example.aplikasisistemdeteksikebakarankosharapanbunda.Fragment.Room_Fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Beranda_Activity extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        tab = findViewById(R.id.tabBeranda);
        viewPager = findViewById(R.id.viewPagerBeranda);
        toolbar = findViewById(R.id.toolbarBeranda);

        if (cek_status(this)){
            // ada koneksi internet
        } else {
            // tidak ada koneksi internet
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setLogo(getResources().getDrawable(R.mipmap.logo));

        tab.setupWithViewPager(viewPager);
        SetupViewPager();
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    private boolean cek_status(Beranda_Activity beranda_activity) {
        boolean connectStatus = true;
        ConnectivityManager ConnectionManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true ) {
            connectStatus = true;
            Toast.makeText(getApplication(), "Anda terhubung ke "+networkInfo.getTypeName()+" "+networkInfo.getSubtypeName(), Toast.LENGTH_SHORT).show();
        }
        else {
            connectStatus = false;
            Toast.makeText(getApplication(), "Anda tidak memiliki koneksi jaringan.", Toast.LENGTH_SHORT).show();
        }
        return connectStatus;
    }

    private void SetupViewPager() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Room_Fragment(), "Room");
        adapter.AddFragment(new Pengaturan_Fragment(), "Pengaturan");
        viewPager.setAdapter(adapter);
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fr = new ArrayList<>();
        private List<String> title = new ArrayList<>();
        public MyViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        public void AddFragment(Fragment fragment, String jd) {
            fr.add(fragment);
            this.title.add(jd);
        }

        @Override
        public Fragment getItem(int position){
            return fr.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return title.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}