package com.example.elifnur.ogrencisinavdurumu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListeleActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        List<Ogrenci> ogrenciler = (ArrayList<Ogrenci>) getIntent().getSerializableExtra("ogrenciler");
        OgrenciAdapter adapter= new OgrenciAdapter(this,ogrenciler);
        listView = (ListView)findViewById(R.id.lstkayit);
        listView.setAdapter(adapter);

    }


}
