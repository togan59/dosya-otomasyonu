package com.example.dosyaotomasyonu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Uygulama extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("giris.fxml"));
        stage.setTitle("Dosya Otomasyonu");
        stage.setScene(new Scene(root, 680, 400));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
