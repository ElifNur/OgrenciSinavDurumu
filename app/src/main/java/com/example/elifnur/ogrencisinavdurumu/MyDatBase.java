package com.example.elifnur.ogrencisinavdurumu;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by elifnur on 13.12.2016.
 */

public class MyDatBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ogrenciler.db";

    public MyDatBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ogrenciler (id integer primary key autoincrement, ad text, soyad text, vize integer, final integer);");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void ekle(Ogrenci ogrenci) {
        SQLiteDatabase db = getWritableDatabase();
        String sorgu = String.format("insert into ogrenciler (ad,soyad,vize,final) values ('%s','%s',%d,%d)", ogrenci.getAd(), ogrenci.getSoyad(), ogrenci.getVize(), ogrenci.getFinall());
        db.execSQL(sorgu);


    }

    public List<Ogrenci> listele() {
        List<Ogrenci> ogrenciler = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from ogrenciler", null);
        cursor.moveToFirst();
        while (cursor.moveToNext() ){
            Ogrenci ogrenci = new Ogrenci();
            ogrenci.setId(cursor.getInt(cursor.getColumnIndex("id")));
            ogrenci.setAd(cursor.getString(cursor.getColumnIndex("ad")));
            ogrenci.setSoyad(cursor.getString(cursor.getColumnIndex("soyad")));
            ogrenci.setVize(cursor.getInt(cursor.getColumnIndex("vize")));
            ogrenci.setFinall(cursor.getInt(cursor.getColumnIndex("final")));


            ogrenciler.add(ogrenci); //liste clasının methodu ! öğrenci listesine ekler
        }
        return ogrenciler;
    }

    public void sil(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String sorgu = String.format("delete from ogrenciler where id=%d",id);
        db.execSQL(sorgu);

    }

      public void guncelle(Ogrenci ogrenci){
          SQLiteDatabase db=getReadableDatabase();
          String sorgu= String.format("update ogrenciler set ad='%s',soyad='%s',vize=%d,final=%d where id=%d",ogrenci.getAd(), ogrenci.getSoyad(),ogrenci.getVize(),ogrenci.getFinall(),ogrenci.getId());
          db.execSQL(sorgu);

      }

}
