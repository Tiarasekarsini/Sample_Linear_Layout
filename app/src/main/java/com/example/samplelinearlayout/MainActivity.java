package com.example.samplelinearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel untuk button dan edittext
    Button btnMasuk;
    EditText ednama, edpassword;

    //deklarasi variabel untuk menyimpan nama dan password
    String nama, sandi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnMasuk dengan komponen button yang ada pada layout
        btnMasuk = findViewById(R.id.btMasuk);
        //Menghubungkan variabel idmasuk dengan komponen button yang ada pada layout
        ednama = findViewById(R.id.edNama);
        //Menghubungkan variabel idsandi dengan komponen button yang ada pada layout
        edpassword = findViewById(R.id.edPassword);

        //membuat fungsi onclick pada button btnMasuk
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                //menyimpan inputan nama dari user kedalam variabel nama
                nama = ednama.getText().toString();
                //menyimpan inputan dari user kedalam variabel sandi
                sandi = edpassword.getText().toString();

                //mengecek apakah edittext nama dan password sesuai atau tidak (mengecek validasi)
                if (nama.equals("Tiara") && sandi.equals("tiaraaja")) {
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    //inisiasi Bundle
                    Bundle bl = new Bundle();
                    //memasukan value dari variabel nama dengan kunci "nm" kedalam bundle
                    bl.putString("nm", nama.trim());
                    //memasukan value dari variabel sandi dengan kunci "sn" kedalam bundle
                    bl.putString("sn", sandi.trim());

                    //membuat objek intent berpindah dari MainActivity(asal) ke isiTaskActivity(tujuan) atau memanggil dan yang dipanggil
                    Intent i = new Intent(MainActivity.this,Home_Activity.class);

                    //memasukan bundle kedalam intent untuk dikirimkan ke isiTaskActivity
                    i.putExtras(bl);
                    //berpindah ke isiTaskActivity
                    startActivity(i);

                    //mengececek validasi apakah nama dan sandi sudah terisi atau belum, jika belum maka akan muncul setError
                }else if (nama.isEmpty()) {
                    ednama.setError("Masukan Nama");
                }
                else if (sandi.isEmpty()){
                    edpassword.setError("Masukan Password");
                }else if (nama.equals(nama) && sandi.equals("tiaraaja")) {
                    Toast.makeText(MainActivity.this, "nama salah", Toast.LENGTH_SHORT).show();
                } else if (nama.equals("Tiara") && sandi.equals(sandi)) {
                    Toast.makeText(MainActivity.this, "password salah", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "nama dan password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}