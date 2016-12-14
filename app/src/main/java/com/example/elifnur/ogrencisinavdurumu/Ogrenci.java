package com.example.elifnur.ogrencisinavdurumu;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by elifnur on 12.12.2016.
 */



public class Ogrenci implements Serializable {

    private int id;
    private String ad;
    private String soyad;
    private int vize;
    private int finall;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getVize() {
        return vize;
    }

    public void setVize(int vize) {
        this.vize = vize;
    }

    public int getFinall() {
        return finall;
    }

    public void setFinall(int finall) {
        this.finall = finall;
    }

    public boolean getDurum(){
        double sonuc = (vize*0.4)+(finall*0.6);
        if(sonuc>60){
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "id:"+id+" ad:" + ad+" soyad:" +soyad + " vize:"+ vize + " final:"+ finall;
    }
}
