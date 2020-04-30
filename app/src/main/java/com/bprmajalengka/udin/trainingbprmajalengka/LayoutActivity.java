package com.bprmajalengka.udin.trainingbprmajalengka;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LayoutActivity extends AppCompatActivity {
//variabel yang digunakan
    // tipe private=1 clas public=umum,protected
    private Button btnedit1,btnweb,btnPsn;
    private TextView nama,jabatan,nohp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        //menghubungan layout dan xml
        nama = findViewById(R.id.txtnama1);
        jabatan = findViewById(R.id.txtjabatan1);
        nohp = findViewById(R.id.txthp1);
        String namaString = getIntent().getStringExtra("NAMA");
        String jabatanString = getIntent().getStringExtra("JABATAN");
        String hpString = getIntent().getStringExtra("NOHP");

        nama.setText(namaString);
        jabatan.setText(jabatanString);
        nohp.setText(hpString);

        //menghubunggan tombol dengan layout
        btnedit1 = (Button) findViewById(R.id.btnedit3);
        //action saat di klik
        btnedit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///cara berpindah halaman
                Intent inten = new Intent(LayoutActivity.this,EditActivity.class);
                //metoe pindah
                startActivity(inten);
            }
        });
        //membuat inten implicit buka ke web
        btnweb = findViewById(R.id.btnweb);
        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://bprmajalengka.com"));
                startActivity(intent);
            }
        });
        //membuat inten kirim pesan
        btnPsn = findViewById(R.id.btnPsn);
        btnPsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(Intent.ACTION_VIEW,);
                inten.putExtra(Intent.EXTRA_TEXT, "Pelatihan android MAMAS AYAM");
                inten.setType("text/plain");
                startActivity(inten);
            }
        });
    }
}
