package com.example.dosyaotomasyonu;

import java.util.ArrayList;

public class Arsiv {
    private String arsivAdi;
    private ArrayList<Belge> belgeler;

    public Arsiv(String arsivAdi) {
        this.arsivAdi = arsivAdi;
        this.belgeler = new ArrayList<Belge>();
        Arsivler.arsivEkle(this);
    }

    // Getter ve Setter Metodları
    public String getArsivAdi() {
        return arsivAdi;
    }

    public void setArsivAdi(String arsivAdi) {
        this.arsivAdi = arsivAdi;
    }
    public ArrayList<Belge> getBelgeler() {
        return belgeler;
    }

    // Belge ekleme
    public void belgeEkle(Belge belge) {
        this.belgeler.add(belge);
    }

    // Belge silme
    public void belgeSil(Belge belge) {
        this.belgeler.remove(belge);
    }

}
