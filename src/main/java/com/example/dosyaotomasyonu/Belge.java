package com.example.dosyaotomasyonu;

import java.io.File;

public class Belge extends File {
    private String belgeAdi;
    private String belgeTuru;

    public Belge(String path) {
        super(path);
        this.belgeAdi = this.getName();
        // Dosya uzantısını almak için
        this.belgeTuru = this.getName().substring(this.getName().lastIndexOf(".")+1);
    }

    // Getter Metodları
    public String getBelgeAdi() {
        return belgeAdi;
    }

    public String getBelgeTuru() {
        return belgeTuru;
    }

}

