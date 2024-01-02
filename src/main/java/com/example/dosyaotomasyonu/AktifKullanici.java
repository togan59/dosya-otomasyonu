package com.example.dosyaotomasyonu;

import java.io.IOException;
import java.util.ArrayList;

public class AktifKullanici extends Kullanici {

    // Singleton Design Pattern
    private static AktifKullanici instance = null;

    private AktifKullanici(String ad, String soyad, String kullaniciAdi, String eposta, String telefon, ArrayList<Arsiv> arsivler) throws IOException {
        super(ad, soyad, kullaniciAdi, eposta, telefon, arsivler);
    }

    public static AktifKullanici setInstance(Kullanici kullanici) throws IOException {
        if (instance == null) {
            instance = new AktifKullanici(kullanici.getAd(), kullanici.getSoyad(), kullanici.getKullaniciAdi(), kullanici.getEposta(), kullanici.getTelefon(), kullanici.getArsivler());
        }
        return instance;
    }

    // Getters
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
