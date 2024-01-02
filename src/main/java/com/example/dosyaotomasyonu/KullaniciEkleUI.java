package com.example.dosyaotomasyonu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class KullaniciEkleUI {

    @FXML
    private TextField adGiris;

    @FXML
    private TextField epostaGiris;

    @FXML
    private Button kaydet_buton;

    @FXML
    private Label kaydet_hata;

    @FXML
    private TextField kullaniciAdiGiris;

    @FXML
    private TextField soyadGiris;

    @FXML
    private TextField telefonGiris;

    @FXML
    private TextField sifreGiris;

    @FXML
    void kaydet(ActionEvent event) throws IOException {
        String ad = adGiris.getText();
        String soyad = soyadGiris.getText();
        String kullaniciAdi = kullaniciAdiGiris.getText();
        String eposta = epostaGiris.getText();
        String telefon = telefonGiris.getText();
        String sifre = sifreGiris.getText();

        if (ad.isEmpty() || soyad.isEmpty() || kullaniciAdi.isEmpty() || eposta.isEmpty() || telefon.isEmpty() || sifre.isEmpty()) {
            kaydet_hata.setText("Lütfen tüm alanları doldurunuz.");
        } else if (KullaniciListesi.getInstance().contains(kullaniciAdi)) {
            kaydet_hata.setText("Bu kullanıcı adı zaten kullanılıyor.");
        } else {
            Calisan calisan = new Calisan(ad, soyad, kullaniciAdi, sifre, eposta, telefon, new ArrayList<Arsiv>());
            ((Button)event.getSource()).getScene().getWindow().hide();
            YonetimUI.kullaniciListe.add(kullaniciAdi);
            Data.getInstance().kaydet();
        }
    }
}
