package com.example.dosyaotomasyonu;

import java.io.Serializable;
import java.util.ArrayList;

public class Arsivler extends ArrayList<Arsiv> implements Serializable {
    private static Arsivler instance = null;

    private Arsivler() {
        super();
    }

    public static Arsivler getInstance() {
        if (instance == null) {
            instance = new Arsivler();
        }
        return instance;
    }

    public static void setInstance(Arsivler arsivler) {
        instance = arsivler;
    }

    public static void arsivEkle(Arsiv arsiv) {
        instance.add(arsiv);
    }

    public static void arsivSil(Arsiv arsiv) {
        instance.remove(arsiv);
    }

    public static void arsivSil(String arsivAdi) {
        for (Arsiv arsiv : instance) {
            if (arsiv.getArsivAdi().equals(arsivAdi)) {
                instance.remove(arsiv);
                break;
            }
        }
    }

    public Arsiv getArsiv(String arsivAdi) {
        for (Arsiv arsiv : instance) {
            if (arsiv.getArsivAdi().equals(arsivAdi)) {
                return arsiv;
            }
        }
        return null;
    }

}
