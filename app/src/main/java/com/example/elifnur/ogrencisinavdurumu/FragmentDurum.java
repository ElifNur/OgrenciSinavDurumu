package com.example.elifnur.ogrencisinavdurumu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by elifnur on 12.12.2016.
 */

public class FragmentDurum extends Fragment{

    private TextView txtAdsoy;
    private TextView txtDurum;
    private Button btnGeri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_durum, container, false);
        String adsoy=getArguments().getString("adsoy");
        String durum=getArguments().getString("durum");

        txtAdsoy=(TextView) view.findViewById(R.id.txtAdSoyad);
        txtDurum=(TextView ) view.findViewById(R.id.txtDurum);
        final Fragment thiss = this;
        txtAdsoy.setText(adsoy);
        txtDurum.setText(durum);
        btnGeri = (Button) view.findViewById(R.id.btnGeri);
        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.remove(thiss);
                ft.show(fm.findFragmentById(R.id.fragmentKayit));
                ft.commit();
            }
        });
        return view;
    }
}
