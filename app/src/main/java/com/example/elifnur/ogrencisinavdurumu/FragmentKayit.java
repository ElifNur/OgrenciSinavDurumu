package com.example.elifnur.ogrencisinavdurumu;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by elifnur on 12.12.2016.
 */

public class FragmentKayit extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kayit, container, false);

        return view;

    }

    public void durumFragmentGoster(Ogrenci ogrenci) {
        String adsoy = ogrenci.getAd() + " " + ogrenci.getSoyad();
        String durum = "";
        if (ogrenci.getDurum() ) {
            durum = "GEÇTİ";
        } else
            durum = "KALDI";

        FragmentDurum fragmentDurum=new FragmentDurum();
        Bundle bundle=new Bundle();
        bundle.putString("adsoy",adsoy);
        bundle.putString("durum",durum);
        fragmentDurum.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.f,fragmentDurum,"FragmentDurum").addToBackStack("FragmentDurum");
        ft.hide(this);
        ft.commit();
    }
}
