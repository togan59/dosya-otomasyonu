package com.example.dosyaotomasyonu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

// Yönetici panelinde açılan arşiv ekleme ekranı için kullanılan controller
public class ArsivEkleUI {

    @FXML
    private TextField arsivAdi;

    @FXML
    private Button kaydetButon;

    @FXML
    void kaydet(ActionEvent event) throws IOException {
        String arsivAdi = this.arsivAdi.getText();
        Arsiv arsiv = new Arsiv(arsivAdi);
        YonetimUI.arsivListe.add(arsivAdi);
        ((Button)event.getSource()).getScene().getWindow().hide();
        Data.getInstance().kaydet();
    }

}
