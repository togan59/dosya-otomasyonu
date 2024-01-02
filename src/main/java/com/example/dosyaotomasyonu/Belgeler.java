package com.example.dosyaotomasyonu;

import java.io.*;
import java.util.ArrayList;

public class Belgeler extends ArrayList<Belge>{
    private static Belgeler instance = null;

    private Belgeler() {
        super();
    }

    public static Belgeler getInstance() {
        if (instance == null) {
            instance = new Belgeler();
        }
        return instance;
    }

    public static void setInstance(Belgeler belgeler) {
        instance = belgeler;
    }

    public static void belgeEkle(Belge belge) {
        instance.add(belge);
    }

    public static void belgeSil(Belge belge) {
        instance.remove(belge);
    }

    public Belge getBelge(String belgeAdi) {
        for (Belge belge : instance) {
            if (belge.getBelgeAdi().equals(belgeAdi)) {
                return belge;
            }
        }
        return null;
    }
}
