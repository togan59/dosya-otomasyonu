package com.example.dosyaotomasyonu;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class Giris {
    @FXML
    private TextField adGiris;

    @FXML
    private TextField epostaGiris;

    @FXML
    private Button giris_yap;

    @FXML
    private Button kayit_ol;

    @FXML
    private Label kayit_ol_hata;

    @FXML
    private Label giris_yap_hata;

    @FXML
    private TextField kullaniciAdiGiris;

    @FXML
    private PasswordField sifreGiris;

    @FXML
    private TextField soyadGiris;

    @FXML
    private TextField telefonGiris;

    @FXML
    private TextField yeniKullaniciAdiGiris;

    @FXML
    private TextField yeniSifreGiris;

    private ObjectProperty<Kullanici> kullanici = new SimpleObjectProperty<>();

    public Giris() throws IOException, ClassNotFoundException {
    }

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        Data data = Data.getInstance();
        data.yukle();
    }
    @FXML
    public void giris_yap_tiklandi(ActionEvent event) throws Exception {
        String kullaniciAdi = kullaniciAdiGiris.getText();
        String sifre = sifreGiris.getText();
        if (KullaniciListesi.getInstance().authonticate(kullaniciAdi, sifre)) {
            AktifKullanici aktifKullanici = AktifKullanici.setInstance(KullaniciListesi.getInstance().get(kullaniciAdi));
            // Yonetici veya çalışan
            if (KullaniciListesi.getInstance().get(kullaniciAdi) instanceof Yonetici) {
                setAnaEkranYonetici();
            } else {
                setAnaEkranCalisan();
            }
        } else {
            giris_yap_hata.setText("Kullanıcı adı veya şifre hatalı!");
        }
    }
    public void setAnaEkranCalisan() throws Exception {
        // giris ekranını kapat
        ((Stage)giris_yap.getScene().getWindow()).close();
        // ana ekranı aç
        AnaEkran anaEkran = new AnaEkran("main.fxml");
    }

    public void setAnaEkranYonetici() throws Exception {
        // giris ekranını kapat
        ((Stage)giris_yap.getScene().getWindow()).close();
        // Yönetici için Yönetim Paneli veya Ana Ekran aç seçim ekranı
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("YoneticiSecim.fxml"));
        stage.setTitle("Dosya Otomasyonu");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }
    @FXML
    public void kayit_ol_tiklandi(ActionEvent event) throws IOException {
        String ad = adGiris.getText();
        String soyad = soyadGiris.getText();
        String kullaniciAdi = yeniKullaniciAdiGiris.getText();
        String sifre = yeniSifreGiris.getText();
        String eposta = epostaGiris.getText();
        String telefon = telefonGiris.getText();
        if (ad==null || soyad==null || kullaniciAdi==null || sifre==null || eposta==null || telefon==null ) {
            kayit_ol_hata.setText("Lütfen tüm alanları doldurunuz");
        }else {
            if (KullaniciListesi.getInstance().contains(kullaniciAdi)) {
                kayit_ol_hata.setText("Bu kullanıcı adı alınmış");
            } else if (sifre.length() < 4) {
                kayit_ol_hata.setText("Sifre en az 4 karakter uzunluğunda olmalıdır");
            } else {
                Kullanici yeniKullanici = new Kullanici(ad, soyad, kullaniciAdi, sifre, eposta, telefon, new ArrayList<Arsiv>());
                KullaniciListesi.getInstance().add(yeniKullanici);
                kayit_ol_hata.setText("Kayit işlemi başarılı, giriş yapabilirsiniz.");
                Data.getInstance().kaydet();
            }
        }
    }
}
