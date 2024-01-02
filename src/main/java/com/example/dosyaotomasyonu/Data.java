package com.example.dosyaotomasyonu;

import java.io.*;

public class Data {
    private KullaniciListesi kullanicilar = KullaniciListesi.getInstance();
    private Arsivler arsivler = Arsivler.getInstance();
    private Belgeler belgeler = Belgeler.getInstance();

    // Singleton Design Pattern
    private static Data instance = null;

    private Data() {
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public static void setInstance(Data instance) {
        Data.instance = instance;
    }

    public void kaydet() throws IOException {
        ObjectOutputStream outBelgeler = new ObjectOutputStream(new FileOutputStream("src/main/resources/com/example/dosyaotomasyonu/data/belgeler.txt"));
        outBelgeler.writeObject(Belgeler.getInstance());
        ObjectOutputStream outArsivler = new ObjectOutputStream(new FileOutputStream("src/main/resources/com/example/dosyaotomasyonu/data/arsivler.txt"));
        outArsivler.writeObject(Arsivler.getInstance());
        ObjectOutputStream outKullanicilar = new ObjectOutputStream(new FileOutputStream("src/main/resources/com/example/dosyaotomasyonu/data/kullanicilar.txt"));
        outKullanicilar.writeObject(KullaniciListesi.getInstance());
    }

    public void yukle() throws IOException, ClassNotFoundException {
        ObjectInputStream inBelgeler = new ObjectInputStream(new FileInputStream("src/main/resources/com/example/dosyaotomasyonu/data/belgeler.txt"));
        ObjectInputStream inArsivler = new ObjectInputStream(new FileInputStream("src/main/resources/com/example/dosyaotomasyonu/data/arsivler.txt"));
        ObjectInputStream inKullanicilar = new ObjectInputStream(new FileInputStream("src/main/resources/com/example/dosyaotomasyonu/data/kullanicilar.txt"));

        belgeler = (Belgeler) inBelgeler.readObject();
        arsivler = (Arsivler) inArsivler.readObject();
        kullanicilar = (KullaniciListesi) inKullanicilar.readObject();

        KullaniciListesi.setInstance(kullanicilar);
        Arsivler.setInstance(arsivler);
        Belgeler.setInstance(belgeler);

        inKullanicilar.close();
        inArsivler.close();
        inBelgeler.close();

    }
}
