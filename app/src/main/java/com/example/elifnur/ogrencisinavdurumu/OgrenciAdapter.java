package com.example.elifnur.ogrencisinavdurumu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elifnur on 14.12.2016.
 */

public class OgrenciAdapter extends BaseAdapter {
    private Context mContext;
    private MyDatBase myDB;
    private LayoutInflater mInflater;
    private List<Ogrenci> mogrenciler;
    private Button btnSil;
    private Button btnDuzenle;

    public OgrenciAdapter(Activity activity, List<Ogrenci> ogrenciler){
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext=activity;
       mogrenciler=ogrenciler;
    }


    @Override
    public int getCount() {
        return mogrenciler.size();
    }

    @Override
    public Object getItem(int position) {
        return mogrenciler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;
        satirView=mInflater.inflate(R.layout.satir_layout,null);

        TextView txtAdSoy= (TextView) satirView.findViewById(R.id.txtAdSoyad);
        TextView txtVize= (TextView) satirView.findViewById(R.id.txtVize);
        TextView txtFinal= (TextView) satirView.findViewById(R.id.txtFinal);
        TextView txtDurum= (TextView) satirView.findViewById(R.id.txtDurum);
        final Ogrenci ogrenci = mogrenciler.get(position);
        txtAdSoy.setText(ogrenci.getAd() + " " +ogrenci.getSoyad());
        txtVize.setText(String.valueOf(ogrenci.getVize()));
        txtFinal.setText(String.valueOf(ogrenci.getFinall()));
        txtDurum.setText(ogrenci.getDurum() ? "GEÇTİ" : "KALDI");
        btnSil=(Button) satirView.findViewById(R.id.btnSil);
        btnDuzenle=(Button)satirView.findViewById(R.id.btnDuzenle);

        btnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             myDB=new MyDatBase(mContext);
                myDB.sil(ogrenci.getId());
                Toast.makeText(mContext, "KAYIT SİLİNDİ", Toast.LENGTH_SHORT).show();


            }
        });

        btnDuzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mContext,OgrenciGuncelle.class);
                intent.putExtra("ogrenci",ogrenci);
                mContext.startActivity(intent);// startactivity  methodu activitlerin methodur mcontext e activitydir.

            }
        });
        return satirView;



    }




}
