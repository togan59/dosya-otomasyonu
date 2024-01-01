package com.example.dosyaotomasyonu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ArsivEkleUI {

    @FXML
    private TextField arsivAdi;

    @FXML
    private Button kaydetButon;

    @FXML
    void kaydet(ActionEvent event) {
        String arsivAdi = this.arsivAdi.getText();
        Arsiv arsiv = new Arsiv(arsivAdi);
        YonetimUI.arsivListe.add(arsivAdi);
        ((Button)event.getSource()).getScene().getWindow().hide();
    }

}
