package com.example.dosyaotomasyonu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AnaEkranUI {

    @FXML
    private Button arsivlerButon;

    @FXML
    private Button profilButon;

    @FXML
    void arsivler_tiklandi(ActionEvent event) throws IOException {
        System.out.println(AktifKullanici.returnArsivler());
        ((Stage) arsivlerButon.getScene().getWindow()).close();
        AnaEkran anaEkran = new AnaEkran("mainArsivler.fxml");
    }
    @FXML
    void profil_tiklandi(ActionEvent event) throws IOException {
        ((Stage) profilButon.getScene().getWindow()).close();
        AnaEkran anaEkran = new AnaEkran("mainProfil.fxml");
    }
}
