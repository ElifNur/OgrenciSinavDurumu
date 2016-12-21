package com.example.elifnur.ogrencisinavdurumu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OgrenciGuncelle extends AppCompatActivity {
    private TextView txtid;
    private EditText etAd;
    private EditText etSoyad;
    private  EditText etVize;
    private EditText etFinal;
    private Button btnGuncelle;
    private Ogrenci ogrenci;
    private MyDatBase myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_guncelle);

        txtid=(TextView) findViewById(R.id.txtid);
        etAd=(EditText) findViewById(R.id.etAd);
        etSoyad=(EditText) findViewById(R.id.etSoyad);
        etVize=(EditText) findViewById(R.id.etVize);
        etFinal=(EditText) findViewById(R.id.etFinal);
        btnGuncelle=(Button)findViewById(R.id.btnGuncelle);
        myDB=new MyDatBase(this);

        Intent intent = getIntent();
        final Ogrenci ogrenci = (Ogrenci) intent.getSerializableExtra("ogrenci");
        txtid.setText(String.valueOf(ogrenci.getId()));
        etAd.setText(ogrenci.getAd());
        etSoyad.setText(ogrenci.getSoyad());
        etVize.setText(String.valueOf(ogrenci.getVize()));
        etFinal.setText(String.valueOf(ogrenci.getFinall()));


        btnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Ogrenci ogrenci =new Ogrenci();
                ogrenci.setId(Integer.parseInt(txtid.getText().toString()));
                ogrenci.setAd(etAd.getText().toString());
                ogrenci.setSoyad(etSoyad.getText().toString());
                ogrenci.setVize(Integer.parseInt(etVize.getText().toString()));
                ogrenci.setFinall(Integer.parseInt(etFinal.getText().toString()));
                myDB.guncelle(ogrenci);

            }
        });



    }

}
