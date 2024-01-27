package com.example.nyp_proje;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddScene implements Initializable {
    @FXML
    TextField name;
    @FXML
    TextField code;
    @FXML
    TextField teacher;
    @FXML
    TextField classroom;
    @FXML
    ChoiceBox<String> courseTime;
    @FXML
    ChoiceBox<String> courseDay;
    @FXML
    ChoiceBox<String> courseType;
    @FXML
    Label warn;
    @FXML
    public void close(){
        Stage stage1 = (Stage) name.getScene().getWindow();
        stage1.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseTime.getItems().addAll("08:30-09:20","09:30-10:20","10:30-11:20","11:30-12:20","13:00-13:50","14:00-14:50","15:00-15:50","16:00-16:50");
        courseDay.getItems().addAll("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday");
        courseType.getItems().addAll("Theoretical","Laboratory","Online");
    }
    @FXML
    public void addCourse(){
        try {
            if(courseType.getSelectionModel().getSelectedIndex()==0) {
                Course course = new theoricCourse(name.getText(), code.getText(), teacher.getText(), classroom.getText(),courseTime.getSelectionModel().getSelectedIndex(), courseDay.getSelectionModel().getSelectedIndex());
                course.AddCourse(courseTime.getSelectionModel().getSelectedIndex(), courseDay.getSelectionModel().getSelectedIndex(),courseType.getSelectionModel().getSelectedItem());
            } else if (courseType.getSelectionModel().getSelectedIndex()==1) {
                Course course = new labCourse(name.getText(), code.getText(), teacher.getText(), classroom.getText(),courseTime.getSelectionModel().getSelectedIndex(), courseDay.getSelectionModel().getSelectedIndex());
                course.AddCourse(courseTime.getSelectionModel().getSelectedIndex(), courseDay.getSelectionModel().getSelectedIndex(),courseType.getSelectionModel().getSelectedItem());
            }else if(courseType.getSelectionModel().getSelectedIndex()==2){
                Course course = new onlineCourse(name.getText(), code.getText(), teacher.getText(), classroom.getText(),courseTime.getSelectionModel().getSelectedIndex(), courseDay.getSelectionModel().getSelectedIndex());
                course.AddCourse(courseTime.getSelectionModel().getSelectedIndex(), courseDay.getSelectionModel().getSelectedIndex(),courseType.getSelectionModel().getSelectedItem());
            } else {
                warn.setText("Choose Course Type.");
            }
        }
        catch (Exception e)
        {
            warn.setText("Choose Course Time and Day.");
        }
    }
    @FXML
    public void delCourse(){
        try {
            SyllabusScene.cellItems.get(courseTime.getSelectionModel().getSelectedIndex()).get(courseDay.getSelectionModel().getSelectedIndex()).setAll("","","","","");
            SyllabusScene.cellLists.get(courseTime.getSelectionModel().getSelectedIndex()).get(courseDay.getSelectionModel().getSelectedIndex()).setStyle("-fx-control-inner-background: white;");
        }
        catch (Exception e)
        {
            warn.setText("Choose Course Time and Day.");
        }
    }
    @FXML
    public void delWarn(){
        warn.setText("");
    }
}
