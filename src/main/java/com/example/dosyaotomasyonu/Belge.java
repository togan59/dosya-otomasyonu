package com.example.dosyaotomasyonu;

import java.io.*;


public class Belge extends File implements Serializable {
    private String belgeAdi;
    private String belgeTuru;
    private String belgePath;

    public Belge(String path) throws IOException {
        super(path);
        this.belgeAdi = this.getName();
        // Dosya uzantısını almak için
        this.belgeTuru = this.getName().substring(this.getName().lastIndexOf(".")+1);
        this.belgePath = path;
        Belgeler.belgeEkle(this);
        Data.getInstance().kaydet();
    }

    // Getter Metodları
    public String getBelgeAdi() {
        return this.belgeAdi;
    }

    public String getBelgeTuru() {
        return this.belgeTuru;
    }

    public String getPath() {return this.belgePath;}

}

