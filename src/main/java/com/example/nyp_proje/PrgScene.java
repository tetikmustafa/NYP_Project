package com.example.nyp_proje;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class PrgScene{
    @FXML
    Label label;
    public void showSyllabus() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("syllabusScene.fxml"));
        Stage stage = (Stage)label.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 1500, 800);
        stage.setTitle("Syllabus Screen");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    public void exit(){
        Platform.exit();
    }
}
