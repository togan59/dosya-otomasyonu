package com.example.dosyaotomasyonu;

import java.util.ArrayList;

public class Yonetici extends Kullanici{
    public Yonetici(String ad, String soyad, String kullaniciAdi, String sifre, String eposta, String telefon) {
        super(ad, soyad, kullaniciAdi, sifre, eposta, telefon);
        this.setArsivler(Arsivler.getInstance());
    }

    // Kullanıcı yönetimi
    public boolean kullaniciEkle(Kullanici kullanici){
        return KullaniciListesi.getInstance().add(kullanici);
    }
    public boolean kullaniciSil(Kullanici kullanici){
        return KullaniciListesi.getInstance().remove(kullanici);
    }
    public boolean kullaniciSil(String kullaniciAdi){
        return KullaniciListesi.getInstance().remove(KullaniciListesi.getInstance().get(kullaniciAdi));
    }

    // Kullanıcı yetkilendirme
    public void yetkilendir(Calisan calisan, Arsiv arsiv){
        calisan.arsivEkle(arsiv);
    }
    public void yetkiKaldir(Calisan calisan, Arsiv arsiv){
        calisan.arsivSil(arsiv);
    }

}
