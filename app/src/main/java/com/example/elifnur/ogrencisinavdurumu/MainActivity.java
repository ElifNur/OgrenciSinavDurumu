package com.example.elifnur.ogrencisinavdurumu;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Fragment fragmentKayit;

    private Button btnDurum;
    private Button btnListele;
    private MyDatBase myDB;
    private EditText etAd;
    private EditText etSoyad;
    private EditText etVize;
    private EditText etFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new MyDatBase(this); //this bir Contex nesnesi
        etAd = (EditText)findViewById(R.id.etAd);
        etSoyad = (EditText)findViewById(R.id.etSoyad);
        etFinal = (EditText)findViewById(R.id.etFinal);
        etVize = (EditText)findViewById(R.id.etVize);
        final FragmentManager fm = getSupportFragmentManager();
        fragmentKayit = (Fragment) fm.findFragmentById(R.id.fragmentKayit);




        btnDurum = (Button) findViewById(R.id.btnDurum);


        btnListele = (Button) findViewById(R.id.btnlistele);


        btnDurum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Ogrenci ogrenci = new Ogrenci();
                ogrenci.setAd(etAd.getText().toString());
                ogrenci.setSoyad(etSoyad.getText().toString());
                ogrenci.setVize(Integer.parseInt(etVize.getText().toString()));
                ogrenci.setFinall(Integer.parseInt(etFinal.getText().toString()));

                myDB.ekle(ogrenci);
                ((FragmentKayit)fragmentKayit).durumFragmentGoster(ogrenci);
            }
        });



        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Ogrenci> ogrenciler = myDB.listele();
                Intent intent =new Intent(MainActivity.this,ListeleActivity.class);
                intent.putExtra("ogrenciler",(ArrayList<Ogrenci>) ogrenciler);
                startActivity(intent);

            }
        });
    }
}
