package com.example.dosyaotomasyonu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private TextField yeniSifreGiris;

    @FXML
    void kaydet(ActionEvent event) {
        String ad = adGiris.getText();
        String soyad = soyadGiris.getText();
        String kullaniciAdi = kullaniciAdiGiris.getText();
        String eposta = epostaGiris.getText();
        String telefon = telefonGiris.getText();
        String yeniSifre = yeniSifreGiris.getText();

        if (ad.isEmpty() || soyad.isEmpty() || kullaniciAdi.isEmpty() || eposta.isEmpty() || telefon.isEmpty() || yeniSifre.isEmpty()) {
            kaydet_hata.setText("Lütfen tüm alanları doldurunuz.");
        } else if (KullaniciListesi.getInstance().contains(kullaniciAdi)) {
            kaydet_hata.setText("Bu kullanıcı adı zaten kullanılıyor.");
        } else {
            Kullanici kullanici = new Kullanici(ad, soyad, kullaniciAdi, eposta, telefon, yeniSifre);
            KullaniciListesi.getInstance().kullaniciEkle(kullanici);
            ((Button)event.getSource()).getScene().getWindow().hide();
            YonetimUI.kullaniciListe.add(kullaniciAdi);
        }
        // Kaydettikten sonra yonetimuı daki listview i guncelle

    }
}
