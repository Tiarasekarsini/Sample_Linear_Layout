package com.example.samplelinearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //deklarasi variabel dengan jenis data Listview
    private ListView list;

    //memanggil class ListViewAdapter dan inisiasi menjadi variabel adapter
    private ListViewAdapter adapter;

    //deklarasi array untuk menyimpannama
    String[] listnama;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //membuat objek bundle
    Bundle bundle = new Bundle();

    //membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //menyimpan nama didalam array ListNama
        listnama = new String[]{"Apin", "Douglas", "Iput", "Aretha", "Mocca", "Miko", "Mika", "Mini"};
        list = findViewById(R.id.listKontak);

        //membuat objek dari class ClassNama menjadi arrayList
        classNamaArrayList = new ArrayList<>();

        //membaca seluruh data pada array ListNama
        for (int i = 0; i < listnama.length; i++) {
            //membuat objek class nama da
            ClassNama classNama = new ClassNama(listnama[i]);
            //Binds strings ke array
            classNamaArrayList.add(classNama);
        }
        //membuat objek dari ListviewAdapter
        adapter = new ListViewAdapter(this);

        //Binds Adapter ke ListView
        list.setAdapter(adapter);

        //membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //deklarasi variabel nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();

                //memasukan value dari variabel nama dengan kunci "a" dan dimasukan kedalam bundle
                bundle.putString("a", nama.trim());

                //membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                //membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);

                //menampilkan popup menu dari Layout menu
                pm.inflate(R.menu.popup_menu);
                //menampilkan popup menu
                pm.show();
            }
        });
    }
//event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edit data", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
