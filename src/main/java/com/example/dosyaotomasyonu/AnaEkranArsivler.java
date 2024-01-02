package com.example.dosyaotomasyonu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

// Ana ekran üzerinde arşivler sekmesi için kullanılan controller
public class AnaEkranArsivler extends AnaEkranUI {
    @FXML
    private Button arsivlerButon;

    @FXML
    private Button profilButon;

    @FXML
    private Label selectionLabel;

    @FXML
    private ListView<String> arsivListe;

    @FXML
    private ListView<String> belgeler;

    @FXML
    private Button belgeEkleButon;

    @FXML
    private Button belgeSilButon;

    @FXML
    private Label belgeAdi;

    @FXML
    private ImageView belgeIkonu;

    @FXML
    private Label belgeTuru;

    @FXML
    void belgeEkle(ActionEvent event) throws IOException {
        // Belge ekleme ekranına geçiş
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Belge Ekle");
        File file = fileChooser.showOpenDialog(new Stage());
        Belge belge = new Belge(file.getAbsolutePath());
        for (Arsiv arsiv : AktifKullanici.returnArsivler()) {
            if (arsiv.getArsivAdi().equals(arsivListe.getSelectionModel().getSelectedItem())) {
                arsiv.belgeEkle(belge);
                belgeListesi.add(belge.getBelgeAdi());
                Data.getInstance().kaydet();
            }
        }
    }

    @FXML
    void belgeSil(ActionEvent event) {
        // Seçili belgeyi sil
        for (Arsiv arsiv : AktifKullanici.returnArsivler()) {
            if (arsiv.getArsivAdi().equals(arsivListe.getSelectionModel().getSelectedItem())) {
                for (Belge belge : arsiv.getBelgeler()) {
                    if (belge.getBelgeAdi().equals(belgeler.getSelectionModel().getSelectedItem())) {
                        arsiv.belgeSil(belge);
                        break;
                    }
                }
                break;
            }
        }
    }

    private ObservableList<String> arsivListesi = FXCollections.observableArrayList();
    private ObservableList<String> belgeListesi = FXCollections.observableArrayList();


    @FXML
    void arsivler_tiklandi(ActionEvent event) throws IOException {
        super.arsivler_tiklandi(event);
    }

    @FXML
    void profil_tiklandi(ActionEvent event) throws IOException {
        super.profil_tiklandi(event);
    }

    @FXML
    void initialize() {
        // Aktif kullanıcının yetkisi olan arşivlerin adlarını listele
        for (Arsiv arsiv : AktifKullanici.returnArsivler()) {
            arsivListesi.add(arsiv.getArsivAdi());
        }
        arsivListe.setItems(arsivListesi);
        arsivListe.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectionLabel.setText(newValue + " Arşivi");
            // Arşiv seçildiğinde o arşivin belgelerini listele
            belgeListesi.clear();
            for (Arsiv arsiv : AktifKullanici.returnArsivler()) {
                if (arsiv.getArsivAdi().equals(newValue)) {
                    for (Belge belge : arsiv.getBelgeler()) {
                        belgeListesi.add(belge.getBelgeAdi());
                    }
                    belgeler.setItems(belgeListesi);
                }
            }
        });

        belgeler.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Belge seçildiğinde belge bilgilerini göster
            for (Arsiv arsiv : AktifKullanici.returnArsivler()) {
                for (Belge belge : arsiv.getBelgeler()) {
                    if (belge.getBelgeAdi().equals(newValue)) {
                        belgeAdi.setText(belge.getBelgeAdi());
                        belgeTuru.setText(belge.getBelgeTuru());
                        Image ikon = new Image(getClass().getResourceAsStream("icon/" + belge.getBelgeTuru() + ".png"));
                        belgeIkonu.setImage(ikon);
                    }
                }
            }
        });

    }
}

