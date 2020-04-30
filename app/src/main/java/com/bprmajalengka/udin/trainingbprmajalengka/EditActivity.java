package com.bprmajalengka.udin.trainingbprmajalengka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    //varabel
    private EditText txtNama,txtHp, txtJabatan ;
    private RadioGroup rgKelamin ;
    private RadioButton rbPria,rbWanita;
    private Spinner spHobi;
    private Button btnBatal,btnSimpan;
    private String [] dataHobi = {"Travelling","Music","Sepakbola","Membaca","Kicau Mania"} ;
    //variabel untuk menyimpan data hobi
    private String hobiPilih = "" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setupView();



    }

    private void  setupView(){
        txtNama = findViewById(R.id.txtNama);
        txtHp = findViewById(R.id.txtHp);
        txtJabatan = findViewById(R.id.txtJabatan);
        rgKelamin = findViewById(R.id.rgKelamin);
        rbPria = findViewById(R.id.rbPria);
        rbWanita = findViewById(R.id.rbWanita);
        spHobi = findViewById(R.id.spHobi);
        btnBatal = findViewById(R.id.btnBatal);
        btnSimpan= findViewById(R.id.btnSimpan);

        //untuk spinner
        ArrayAdapter adapterHobi = new ArrayAdapter(this,android.R.layout.simple_spinner_item,dataHobi);
        adapterHobi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // masukan adapter ke spiner
        spHobi.setAdapter(adapterHobi);

        //action spiner
        spHobi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    hobiPilih = dataHobi[position];
                    Toast.makeText(EditActivity.this,
                            "hobi yang dipilih  " + hobiPilih, Toast.LENGTH_LONG).show();
                }else{
                    hobiPilih="";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //spHobi.setSelection(3);
    }
    public void onKlikAction (View v) {
        switch (v.getId()){
            case R.id.btnBatal:
            //code untuk batal
                onBackPressed();
                break;
            case R.id.btnSimpan:
             // code simpan
             // ambil data dari edit text
             String nama = txtNama.getText().toString();
             String hp = txtHp.getText().toString();
             String jabatan = txtJabatan.getText().toString();

             //untuk ambil jenis kelamin
             int kelaminPilih = rgKelamin.getCheckedRadioButtonId();
             RadioButton rbKelaminPilih = (RadioButton) findViewById(kelaminPilih);
             String kelamin =  rbKelaminPilih.getText().toString();


             //validasi isian
                if (TextUtils.isEmpty(nama)) {
                    peringatan("Nama harus diisi");
                } else if (TextUtils.isEmpty(hp)) {
                    peringatan("Nomor Handphone harus diisi");
                } else if (TextUtils.isEmpty(jabatan)) {
                    peringatan("Jabatan harus diisi");
                } else if (TextUtils.isEmpty(kelamin)) {
                    peringatan("Kelamin harus diisi");
                } else if (TextUtils.isEmpty(hobiPilih)) {
                    peringatan("Hobi harus dipilih");
                } else {
                    peringatan("Data Siap disimpan");
                    Intent iten = new Intent(EditActivity.this, LayoutActivity.class);
                    //mengirim variabel ke layout baru
                    iten.putExtra("NAMA",nama);
                    iten.putExtra("NOHP",hp);
                    iten.putExtra("JABATAN",jabatan);
                    startActivity(iten);
                }

                 break;

        }
    }

    private void peringatan(String pesan) {
      Toast.makeText(EditActivity.this, pesan, Toast.LENGTH_LONG).show();
    }
}
