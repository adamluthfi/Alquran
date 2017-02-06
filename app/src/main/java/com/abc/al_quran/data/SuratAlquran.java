package com.abc.al_quran.data;

/**
 * Created by Gerbage on 1/16/2017.
 */

public class SuratAlquran {
    public String ayat;
    public String surat;
    public int no_ayat;

    public SuratAlquran(){

    }

    public SuratAlquran(String ayat, String surat,int no_ayat){
        this.ayat = ayat;
        this.surat = surat;
        this.no_ayat = no_ayat;
    }

    public String getAyat() {
        return ayat;
    }

    public String getSurat() {
        return surat;
    }

    public int getNo_ayat() {
        return no_ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public void setSurat(String surat) {
        this.surat = surat;
    }

    public void setNo_ayat(int no_ayat) {
        this.no_ayat = no_ayat;
    }
}
