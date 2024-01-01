package com.example.dosyaotomasyonu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class YoneticiSecim {

    @FXML
    private Button anaEkran;

    @FXML
    private Button yonetim;

    @FXML
    void anaEkran_tiklandi(ActionEvent event) throws IOException {
        AnaEkran anaEkran = new AnaEkran("main.fxml");

    }

    @FXML
    void yonetim_tiklandi(ActionEvent event) throws IOException {
        AnaEkran anaEkran = new AnaEkran("yonetim.fxml");
    }

}