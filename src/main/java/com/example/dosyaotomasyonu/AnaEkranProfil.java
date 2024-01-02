package com.example.dosyaotomasyonu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

// Ana ekran üzerinde profil sekmesi için kullanılan controller
public class AnaEkranProfil extends AnaEkranUI {

    @FXML
    private Label adLabel;

    @FXML
    private Button arsivlerButon;

    @FXML
    private Label epostaLabel;

    @FXML
    private Label kullaniciAdiLabel;

    @FXML
    private Button profilButon;

    @FXML
    private Label soyadLabel;

    @FXML
    private Label telefonLabel;

    @FXML
    void arsivler_tiklandi(ActionEvent event) throws IOException {
        super.arsivler_tiklandi(event);
    }
    @FXML
    void profil_tiklandi(ActionEvent event) throws IOException{
        super.profil_tiklandi(event);
    }

    @FXML
    public void initialize() {
        adLabel.setText(AktifKullanici.returnAd());
        soyadLabel.setText(AktifKullanici.returnSoyad());
        kullaniciAdiLabel.setText(AktifKullanici.returnKullaniciAdi());
        epostaLabel.setText(AktifKullanici.returnEposta());
        telefonLabel.setText(AktifKullanici.returnTelefon());
    }

}