package com.example.samplelinearlayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLihatData extends AppCompatActivity {
    //deklarasi variabel dengan jenis data TextView
    TextView tvnama, tvumur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvumur = findViewById(R.id.tvnotelp);

        //membuat variabel dengan jenis data bundle dan assign value dari variabel tersebut engan getIntent().getExtras()
        Bundle bundle = getIntent().getExtras();

        //membuat variabel nama dan assign value dari pesan yang dikirimkan dari activity sebelumnya
        String nama = bundle.getString("a");

        //membuat fungsi untuk mengatur textview nama dan umur kucing berdasarkan pesan yang dikrimkan dari activity sebelumnya
        switch (nama) {
            case "Apin":
                tvnama.setText("Apin");
                tvumur.setText("085221666966");
                break;
            case "Douglas":
                tvnama.setText("Douglas");
                tvumur.setText("089227866966");
                break;
            case "Iput":
                tvnama.setText("Iput");
                tvumur.setText("085231666977");
                break;
            case "Aretha":
                tvnama.setText("Aretha");
                tvumur.setText("087621669666");
                break;
            case "Mocca":
                tvnama.setText("Mocca");
                tvumur.setText("089221222966");
                break;
            case "Miko":
                tvnama.setText("Miko");
                tvumur.setText("085321666966");
                break;
            case "Mika":
                tvnama.setText("Mika");
                tvumur.setText("085221456966");
                break;
            case "Mini":
                tvnama.setText("Mini");
                tvumur.setText("082226166933");
                break;
        }
    }
}
