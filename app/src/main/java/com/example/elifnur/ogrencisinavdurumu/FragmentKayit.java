package com.example.elifnur.ogrencisinavdurumu;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by elifnur on 12.12.2016.
 */

public class FragmentKayit extends Fragment {
    private EditText etAd;
    private EditText etSoyad;
    private EditText etVize;
    private EditText etFinal;
    private Button btndurum;
    private String adsoy;
    private double sonuc;
    private String durum;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kayit, container, false);
        etAd = (EditText) view.findViewById(R.id.etAd);
        etSoyad = (EditText) view.findViewById(R.id.etSoyad);
        etVize = (EditText) view.findViewById(R.id.etVize);
        etFinal = (EditText) view.findViewById(R.id.etFinal);
        btndurum=(Button) view.findViewById(R.id.btnDurum);

        /**


         */



        return view;

    }

    public void durumFragmentGoster(ViewGroup container) {
        adsoy = etAd.getText().toString() + " " + etSoyad.getText().toString();
        int vize = Integer.parseInt(etVize.getText().toString());
        int finall = Integer.parseInt(etFinal.getText().toString());
        sonuc = (vize * 0.4) + (finall * 0.6);

        if (sonuc > 60) {
            durum = "GEÇTİ";
        } else
            durum = "KALDI";

        FragmentDurum fragmentDurum=new FragmentDurum();
        Bundle bundle=new Bundle();
        bundle.putString("adsoy",adsoy);
        bundle.putString("durum",durum);
        fragmentDurum.setArguments(bundle);
        getFragmentManager().beginTransaction().add(container.getId(),fragmentDurum,"FragmentDurum").addToBackStack("FragmentDurum").commit();
    }
}
