package com.example.aplikasisistemdeteksikebakarankosharapanbunda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class Pengaturan_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

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
}