package com.example.aplikasisistemdeteksikebakarankosharapanbunda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Beranda_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        // Temukan tampilan bilah alat di dalam tata letak aktivitas
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarBeranda);
        // Menyetel Toolbar untuk bertindak sebagai ActionBar untuk jendela Aktivitas ini.
        // Pastikan toolbar ada dalam aktivitas dan bukan null
        setSupportActionBar(toolbar);

        // Menghapus title default
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Mengambil akses TextView yang ada di dalam Toolbar
        TextView mTitle = (TextView) toolbar.findViewById(R.id.textToolbarBeranda);

        // Menampilkan ikon di Toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    // Ikon menu digelembungkan seperti pada bilah tindakan
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Mengembang menu; ini menambahkan item ke bilah tindakan jika ada.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void KlikPengaturan(MenuItem item) {
        Intent Pengaturan = new Intent(Beranda_Activity.this, Pengaturan_Activity.class);
        startActivity(Pengaturan);
    }
}