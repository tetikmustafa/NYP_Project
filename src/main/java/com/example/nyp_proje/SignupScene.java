package com.example.nyp_proje;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class SignupScene {
    @FXML
    Label warn;
    @FXML
    TextField signupUsername;
    @FXML
    TextField signupPassword;
    @FXML
    public void handleSignup(){
        String username = signupUsername.getText();
        String password = signupPassword.getText();
        if (isTaken(username)) {
            warn.setText("Username is already taken.");
        }else {
            if (Objects.equals(username, "") || Objects.equals(password, "")) {
                warn.setText("Please fill in all required fields to proceed.");
            } else {
                try (FileWriter writer = new FileWriter("users.txt", true)) {
                    writer.write(username + ":" + password + "\n");
                } catch (Exception e) {
                    warn.setText("File not found.");
                }
                createSyllabus();
            }
        }
    }
    private boolean isTaken(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String storedUsername = parts[0].trim();
                    if (username.equals(storedUsername)) {
                        return true;
                    }
                }
            }
        }catch (Exception e) {
            warn.setText("File not found.");
        }
        return false;
    }
    public void createSyllabus(){
        String fileName = signupUsername.getText() + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for(int i = 0; i<8;i++){
                for(int j =0; j<7;j++){
                    writer.write("" + ":" + "" + ":" + "" + ":" + "" + ":" + "" + ";");
                }
                writer.write("\n");
            }
        } catch (Exception e) {
            warn.setText("File could not be created.");
        }
    }
    @FXML
    public void turnBack() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("loginScene.fxml"));
        Stage stage = (Stage) warn.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Login Screen");
        stage.setScene(scene);
        stage.show();
    }
}
