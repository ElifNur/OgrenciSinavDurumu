package com.example.elifnur.ogrencisinavdurumu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elifnur on 14.12.2016.
 */

public class OgrenciAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Ogrenci> mogrenciler;

    public OgrenciAdapter(Activity activity, List<Ogrenci> ogrenciler){
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        Ogrenci ogrenci = mogrenciler.get(position);
        txtAdSoy.setText(ogrenci.getAd() + " " +ogrenci.getSoyad());
        txtVize.setText(String.valueOf(ogrenci.getVize()));
        txtFinal.setText(String.valueOf(ogrenci.getFinall()));
        txtDurum.setText(ogrenci.getDurum() ? "GEÇTİ" : "KALDI");
        return satirView;
    }
}
