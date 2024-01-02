package com.example.dosyaotomasyonu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;


public class YonetimUI {

    public static Kullanici secilenKullanici;
    public static Arsiv secilenArsiv;

    @FXML
    private Button arsivEkle_button;

    @FXML
    private Button arsivSil_buton;

    @FXML
    private Label arsivler;

    @FXML
    private Button kullaniciEkle_buton;

    @FXML
    private Button kullaniciSil_buton;

    @FXML
    private Button yetkiler_buton;

    @FXML
    private ListView<String> arsivListView;

    @FXML
    private ListView<String> kullaniciListView;

    static ObservableList<String> arsivListe = FXCollections.observableArrayList();
    static ObservableList<String> kullaniciListe = FXCollections.observableArrayList();


    @FXML
    void arsivEkle(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("arsivEkle.fxml"));
        stage.setTitle("Arsiv Ekle");
        stage.setScene(new Scene(root, 400, 150));
        stage.show();
    }

    @FXML
    void arsivSil(ActionEvent event) throws IOException {
        Arsivler.getInstance().arsivSil(secilenArsiv);
        arsivListe.remove(secilenArsiv.getArsivAdi());
        Data.getInstance().kaydet();
    }

    @FXML
    void kullaniciEkle(ActionEvent event) throws Exception {
        // Kullanıcı ekleme ekranını aç
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("kullaniciEkle.fxml"));
        stage.setTitle("Kullanıcı Ekle");
        stage.setScene(new Scene(root, 320, 400));
        stage.show();
    }

    @FXML
    void kullaniciSil(ActionEvent event) throws IOException {
        KullaniciListesi.getInstance().kullaniciSil(secilenKullanici);
        kullaniciListe.remove(secilenKullanici.getKullaniciAdi());
        Data.getInstance().kaydet();
    }

    @FXML
    void yetkiler_tiklandi(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("yetkiler.fxml"));
        stage.setTitle("Yetkiler | " + secilenKullanici.getKullaniciAdi());
        stage.setScene(new Scene(root, 250, 420));
        stage.show();
    }

    @FXML
    void initialize () {
        arsivListe.clear();
        kullaniciListe.clear();
        for (Arsiv arsiv : Arsivler.getInstance()) {
            arsivListe.add(arsiv.getArsivAdi());
        }
        for (Kullanici kullanici : KullaniciListesi.getInstance()) {
            // Yönetici kullanıcıyı göstermeyecek
            if (kullanici instanceof Yonetici) {
                continue;
            }
            kullaniciListe.add(kullanici.getKullaniciAdi());
        }
        arsivListView.setItems(arsivListe);
        kullaniciListView.setItems(kullaniciListe);

        kullaniciListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            secilenKullanici = KullaniciListesi.getInstance().get(newValue);
        });

        arsivListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            secilenArsiv = Arsivler.getInstance().getArsiv(newValue);
        });
    }

}
