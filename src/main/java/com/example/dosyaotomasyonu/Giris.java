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
    private KullaniciListesi kullanicilar = KullaniciListesi.getInstance();
    private Arsivler arsivler = Arsivler.getInstance();

    private Belgeler belgeler = Belgeler.getInstance();

    @FXML
    public void initialize() {
        // Kullanıcılar
        Calisan calisan1 = new Calisan("Kadir", "Atabay", "sqlcikadir", "sql23", "sqlci23@mail.com", "5123456723", new ArrayList<Arsiv>());
        Calisan calisan2 = new Calisan("Tolga", "AI", "tensorTolga", "taitai", "ccctolgaccc@mail.com", "5123456707", new ArrayList<Arsiv>());
        Yonetici yonetici = new Yonetici("Hamza", "Gündoğdu", "HamzaBey", "java", "javabenimisim@mail.com", "5121212121");

        // Belgeler
        Belge belge1 = new Belge("src/main/resources/belgeler/dilekce.doc");
        Belge belge2 = new Belge("src/main/resources/belgeler/duyuru.pdf");
        Belge belge3 = new Belge("src/main/resources/belgeler/gelirler.xls");
        Belge belge4 = new Belge("src/main/resources/belgeler/giderler.xls");
        Belge belge5 = new Belge("src/main/resources/belgeler/intro.mp4");
        Belge belge6 = new Belge("src/main/resources/belgeler/konusma.doc");
        Belge belge7 = new Belge("src/main/resources/belgeler/logo.png");
        Belge belge8 = new Belge("src/main/resources/belgeler/rapor.doc");
        Belge belge9 = new Belge("src/main/resources/belgeler/web.js");
        Belge belge10 = new Belge("src/main/resources/belgeler/sunum.ppt");

        // Arşivler

        Arsiv arsiv1 = new Arsiv("Mali İşler");
        arsiv1.belgeEkle(belge3);
        arsiv1.belgeEkle(belge4);

        Arsiv arsiv2 = new Arsiv("İnsan Kaynakları");
        arsiv2.belgeEkle(belge1);
        arsiv2.belgeEkle(belge2);
        arsiv2.belgeEkle(belge3);
        arsiv2.belgeEkle(belge4);
        arsiv2.belgeEkle(belge5);

        Arsiv arsiv3 = new Arsiv("Yazılım");
        arsiv3.belgeEkle(belge8);
        arsiv3.belgeEkle(belge9);
        arsiv3.belgeEkle(belge10);

        // Arsi̇vleri̇ Çalışanlara Eşleştirme

        calisan1.arsivEkle(arsiv1);
        calisan1.arsivEkle(arsiv2);

        calisan2.arsivEkle(arsiv3);

        kullanicilar.add(calisan1);
        kullanicilar.add(calisan2);
        kullanicilar.add(yonetici);

    }
    @FXML
    public void giris_yap_tiklandi(ActionEvent event) throws Exception {
        String kullaniciAdi = kullaniciAdiGiris.getText();
        String sifre = sifreGiris.getText();
        if (kullanicilar.authonticate(kullaniciAdi, sifre)) {
            // Yonetici veya çalışan
            if (kullanicilar.get(kullaniciAdi) instanceof Yonetici) {
                setAnaEkranYonetici();
            } else {
                setAnaEkranCalisan();
            }
            AktifKullanici aktifKullanici = AktifKullanici.getInstance(kullanicilar.get(kullaniciAdi));
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
    public void kayit_ol_tiklandi(ActionEvent event){
        String ad = adGiris.getText();
        String soyad = soyadGiris.getText();
        String kullaniciAdi = yeniKullaniciAdiGiris.getText();
        String sifre = yeniSifreGiris.getText();
        String eposta = epostaGiris.getText();
        String telefon = telefonGiris.getText();
        if (ad==null || soyad==null || kullaniciAdi==null || sifre==null || eposta==null || telefon==null ) {
            kayit_ol_hata.setText("Lütfen tüm alanları doldurunuz");
        }else {
            if (kullanicilar.contains(kullaniciAdi)) {
                kayit_ol_hata.setText("Bu kullanıcı adı alınmış");
            } else if (sifre.length() < 4) {
                kayit_ol_hata.setText("Sifre en az 4 karakter uzunluğunda olmalıdır");
            } else {
                Kullanici yeniKullanici = new Kullanici(ad, soyad, kullaniciAdi, sifre, eposta, telefon, new ArrayList<Arsiv>());
                kullanicilar.add(yeniKullanici);
                kayit_ol_hata.setText("Kayit işlemi başarılı, giriş yapabilirsiniz.");
            }
        }
    }
}
