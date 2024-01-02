package com.example.dosyaotomasyonu;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Calisan extends Kullanici implements Serializable {
    public Calisan(String ad, String soyad, String kullaniciAdi, String sifre, String eposta, String telefon, ArrayList<Arsiv> arsivler) throws IOException {
        super(ad, soyad, kullaniciAdi, sifre, eposta, telefon, arsivler);
    }
}
