package com.example.dosyaotomasyonu;

import java.io.Serializable;
import java.util.ArrayList;

public class KullaniciListesi extends ArrayList<Kullanici> implements Serializable {
    private static KullaniciListesi instance = null;
    private KullaniciListesi() {
        super();
    }
    public static KullaniciListesi getInstance() {
        if (instance == null) {
            instance = new KullaniciListesi();
        }
        return instance;
    }
    public static void setInstance(KullaniciListesi kullanicilar) {
        instance = kullanicilar;
    }
    public boolean kullaniciEkle(Kullanici kullanici){
        super.add(kullanici);
        return true;
    }
    public boolean kullaniciSil(Kullanici kullanici){
        super.remove(kullanici);
        return true;
    }
    public boolean kullaniciSil(String kullaniciAdi){
        for (Kullanici kullanici : this) {
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi)) {
                super.remove(kullanici);
                return true;
            }
        }
        return false;
    }
    public boolean contains(Kullanici kullanici){
        return super.contains(kullanici);
    }
    public boolean contains(String kullaniciAdi){
        for (Kullanici kullanici : this) {
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi)) {
                return true;
            }
        }
        return false;
    }
    public boolean authonticate(String kullaniciAdi, String sifre){
        for (Kullanici kullanici : this) {
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi) && kullanici.getSifre().equals(sifre)) {
                return true;
            }
        }
        return false;
    }
    public Kullanici get(String kullaniciAdi){
        for (Kullanici kullanici : this) {
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi)) {
                return kullanici;
            }
        }
        return null;
    }
}
