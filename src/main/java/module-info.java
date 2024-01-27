module com.example.nyp_proje {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nyp_proje to javafx.fxml;
    exports com.example.nyp_proje;
}