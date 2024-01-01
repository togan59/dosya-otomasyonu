package com.example.dosyaotomasyonu;

import java.util.ArrayList;

public class AktifKullanici extends Kullanici {
    private static AktifKullanici instance = null;

    private AktifKullanici(String ad, String soyad, String kullaniciAdi, String sifre, String eposta, String telefon, ArrayList<Arsiv> arsivler) {
        super(ad, soyad, kullaniciAdi, sifre, eposta, telefon, arsivler);
    }

    public static AktifKullanici getInstance(Kullanici kullanici) {
        if (instance == null) {
            instance = new AktifKullanici(kullanici.getAd(), kullanici.getSoyad(), kullanici.getKullaniciAdi(), kullanici.getSifre(), kullanici.getEposta(), kullanici.getTelefon(), kullanici.getArsivler());
        }
        return instance;
    }

    public static void setInstance(Kullanici kullanici) {
        instance = new AktifKullanici(kullanici.getAd(), kullanici.getSoyad(), kullanici.getKullaniciAdi(), kullanici.getSifre(), kullanici.getEposta(), kullanici.getTelefon(), kullanici.getArsivler());
    }


    public static String returnAd() {
        return instance.getAd();
    }
    public static String returnSoyad() {
        return instance.getSoyad();
    }
    public static String returnKullaniciAdi() {
        return instance.getKullaniciAdi();
    }
    public static String returnEposta() {
        return instance.getEposta();
    }
    public static String returnTelefon() {
        return instance.getTelefon();
    }
    public static String returnSifre() {
        return instance.getSifre();
    }
    public static ArrayList<Arsiv> returnArsivler() {
        return instance.getArsivler();
    }








}
