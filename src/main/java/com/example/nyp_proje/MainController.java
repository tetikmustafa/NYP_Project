package com.example.nyp_proje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainController {
    @FXML
    Label warn;
    @FXML
    TextField loginUsername;
    @FXML
    PasswordField loginPassword;
    public void handleLogin() throws IOException {
        String enteredUsername = loginUsername.getText();
        String enteredPassword = loginPassword.getText();
        if (isCorrect(enteredUsername, enteredPassword)) {
            User.setFileName(loginUsername.getText() + ".txt" );
            openProgram();
        } else {
            warn.setText("Incorrect username or password.");
        }
    }
    private boolean isCorrect(String username, String psw) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String storedUsername = parts[0].trim();
                    String storedPassword = parts[1].trim();
                    if (username.equals(storedUsername) && psw.equals(storedPassword)) {
                        return true;
                    }
                }
            }
        }catch (Exception e) {
            warn.setText("File not found.");
        }
        return false;
    }
    @FXML
    public void signUp() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signupScene.fxml"));
        Stage stage = (Stage)warn.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Signup Screen");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openProgram() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prgScene.fxml"));
        Stage stage = (Stage)warn.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }
}