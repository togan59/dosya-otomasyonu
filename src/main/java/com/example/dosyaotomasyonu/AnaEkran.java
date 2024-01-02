package com.example.dosyaotomasyonu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AnaEkran {
    // Ana ekran üzerinden türeyen diğer ekranlar için kullanılan constructor
    public AnaEkran(String sceneFxml) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(sceneFxml));
        stage.setTitle("Dosya Otomasyonu");
        stage.setScene(new Scene(root, 680, 400));
        stage.show();
    }
}