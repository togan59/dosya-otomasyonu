package com.example.dosyaotomasyonu;

import java.io.*;
import java.util.ArrayList;

public class Kullanici implements Serializable {
    private String kullaniciAdi;
    private String sifre;
    private String ad;
    private String soyad;
    private String eposta;
    private String telefon;
    private ArrayList<Arsiv> arsivler;

    public Kullanici(String ad, String soyad, String kullaniciAdi, String sifre, String eposta, String telefon, ArrayList<Arsiv> arsivler) throws IOException {
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.eposta = eposta;
        this.telefon = telefon;
        this.arsivler = arsivler;
        KullaniciListesi.getInstance().kullaniciEkle(this);
        Data.getInstance().kaydet();
    }

    public Kullanici(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    public Kullanici(String ad, String soyad, String kullaniciAdi, String sifre, String eposta, String telefon) throws IOException {
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.eposta = eposta;
        this.telefon = telefon;
        this.arsivler = Arsivler.getInstance();
        KullaniciListesi.getInstance().kullaniciEkle(this);
        Data.getInstance().kaydet();
    }

    public Kullanici(String ad, String soyad, String kullaniciAdi, String eposta, String telefon, ArrayList<Arsiv> arsivler) {
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.eposta = eposta;
        this.telefon = telefon;
        this.arsivler = arsivler;
    }

    // Getters
    public String getKullaniciAdi() {
        return this.kullaniciAdi;
    }
    public String getSifre() {
        return this.sifre;
    }
    public String getAd() {
        return this.ad;
    }
    public String getSoyad() {
        return this.soyad;
    }
    public String getEposta() {
        return this.eposta;
    }
    public String getTelefon() {
        return this.telefon;
    }
    public ArrayList<Arsiv> getArsivler() {
        return this.arsivler;
    }
    // Setters
    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
    public void setEposta(String eposta) {
        this.eposta = eposta;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void setArsivler(ArrayList<Arsiv> arsivler) {
        this.arsivler = arsivler;
    }

    public void arsivEkle(Arsiv arsiv){
        this.arsivler.add(arsiv);
    }

    public void arsivSil(Arsiv arsiv){
        this.arsivler.remove(arsiv);
    }

}
