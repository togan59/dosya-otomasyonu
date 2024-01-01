module com.example.dosyaotomasyonu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dosyaotomasyonu to javafx.fxml;
    exports com.example.dosyaotomasyonu;
}