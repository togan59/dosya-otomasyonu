package com.example.dosyaotomasyonu;

import java.io.*;
import java.util.ArrayList;

public class Arsiv implements Serializable {
    private String arsivAdi;
    private ArrayList<Belge> belgeler;

    public Arsiv(String arsivAdi) throws IOException {
        this.arsivAdi = arsivAdi;
        this.belgeler = new ArrayList<Belge>();
        Arsivler.arsivEkle(this);
        Data.getInstance().kaydet();
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
