package com.example.dosyaotomasyonu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class YetkilerUI {

    @FXML
    private ListView<String> arsivYetkileri_listview;
    private ObservableList<String> arsivYetkileri_liste = FXCollections.observableArrayList();

    @FXML
    private Button cikis_buton;

    @FXML
    private Button yetkiEkle_buton;

    @FXML
    private ChoiceBox<String> yetkiEkle_secim;
    // Arsivlerin adları choicebox'ta gösterilecek.
    private ObservableList<String> arsivSecimListesi = FXCollections.observableArrayList();

    @FXML
    private Label yetkiSilSecim;

    @FXML
    private Button yetkiSil_buton;

    @FXML
    void yetkiEkle(ActionEvent event) {
        // YonetimUI da seçilen kullanıcıya yetkiEkle_secim'de seçilen arşivin yetkisini vereceğiz.
        // arsivYetkileri_listview'da seçilen arşivin yetkilerini göstereceğiz.

        String arsivAdi = yetkiEkle_secim.getValue();
        for (Arsiv arsiv : Arsivler.getInstance()) {
            if (arsiv.getArsivAdi().equals(arsivAdi)) {
                YonetimUI.secilenKullanici.arsivEkle(arsiv);
                arsivYetkileri_liste.add(arsivAdi);
                break;
            }
        }
    }

    @FXML
    void yetkiSil(ActionEvent event) {
        String arsivAdi = yetkiSilSecim.getText();
        for (Arsiv arsiv : Arsivler.getInstance()) {
            if (arsiv.getArsivAdi().equals(arsivAdi)) {
                YonetimUI.secilenKullanici.arsivSil(arsiv);
                arsivYetkileri_liste.remove(arsivAdi);
                break;
            }
        }
    }

    @FXML
    void cikis(ActionEvent event) {
        // YetkilerUI'dan çıkış yapılacak.
        ((Stage) cikis_buton.getScene().getWindow()).close();
    }

    @FXML
    void initialize() {
        // YonetimUI da seçilen kullanıcının arşivlerini arsivSecimListesi'ne ekleyeceğiz.
        // arsivSecimListesi dışında kalan arşivleri yetkiEkle_secim choicebox'ına ekleyeceğiz.
        // arsivYetkileri_listview'da seçilen arşivin yetkilerini göstereceğiz.

        Kullanici kullanici = YonetimUI.secilenKullanici;
        System.out.println(kullanici.getArsivler());

        for (Arsiv arsiv : Arsivler.getInstance()) {
            if (!kullanici.getArsivler().contains(arsiv)) {
                arsivSecimListesi.add(arsiv.getArsivAdi());
            } else {
                arsivYetkileri_liste.add(arsiv.getArsivAdi());
            }
        }
        yetkiEkle_secim.setItems(arsivSecimListesi);
        arsivYetkileri_listview.setItems(arsivYetkileri_liste);

        arsivYetkileri_listview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            yetkiSilSecim.setText(newValue);
        });
    }
}
