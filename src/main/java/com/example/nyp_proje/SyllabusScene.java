package com.example.nyp_proje;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SyllabusScene implements Initializable {
    @FXML
    TableView<Row> table;
    @FXML
    TableColumn<Row, String> timeCol;
    @FXML
    TableColumn<Row, ListView> mondayCol;
    @FXML
    TableColumn<Row, ListView> tuesdayCol;
    @FXML
    TableColumn<Row, ListView> wednesdayCol;
    @FXML
    TableColumn<Row, ListView> thursdayCol;
    @FXML
    TableColumn<Row, ListView> fridayCol;
    @FXML
    TableColumn<Row, ListView> saturdayCol;
    @FXML
    TableColumn<Row, ListView> sundayCol;
    public void write(){
        try (BufferedReader reader = new BufferedReader(new FileReader(User.getFileName()))) {
            String line;
            int row=0;
            while ((line = reader.readLine()) != null) {
                String[] days = line.split(";");
                for(int i=0;i<7;i++){
                    String[] course = days[i].split(":");
                    if (course.length == 5 ) {
                        cellItems.get(row).get(i).setAll(course[0].trim(),course[1].trim(),course[2].trim(),course[3].trim(),course[4].trim());
                        switch (course[4].trim()) {
                            case "Theoretical" ->
                                    cellLists.get(row).get(i).setStyle("-fx-control-inner-background: #BECFDA;");
                            case "Laboratory" ->
                                    cellLists.get(row).get(i).setStyle("-fx-control-inner-background: #DCD0D0;");
                            case "Online" ->
                                    cellLists.get(row).get(i).setStyle("-fx-control-inner-background: #D9E1E8;");
                        }
                    }
                }
                row++;
            }
        }catch (Exception e) {
            e.printStackTrace();//
        }
    }
    static List<List<ObservableList<String>>> cellItems = IntStream.range(0, 8)
            .mapToObj(i -> IntStream.range(0, 7)
                    .mapToObj(j ->
                            FXCollections.observableArrayList("","","","","")
                    )
                    .collect(Collectors.toList())
            )
            .collect(Collectors.toList());
    static List<List<ListView<String>>> cellLists = IntStream.range(0, 8)
            .mapToObj(i -> IntStream.range(0, 7)
                    .mapToObj(j -> new ListView<>(cellItems.get(i).get(j)))
                    .collect(Collectors.toList())
            )
            .collect(Collectors.toList());
    static Row row1 = new Row("\n\n  08:30\n     -\n  09.20",cellLists.get(0).get(0), cellLists.get(0).get(1), cellLists.get(0).get(2), cellLists.get(0).get(3), cellLists.get(0).get(4), cellLists.get(0).get(5), cellLists.get(0).get(6));
    static Row row2 = new Row("\n\n  09:30\n     -\n  10.20",cellLists.get(1).get(0), cellLists.get(1).get(1), cellLists.get(1).get(2), cellLists.get(1).get(3), cellLists.get(1).get(4), cellLists.get(1).get(5), cellLists.get(1).get(6));
    static Row row3 = new Row("\n\n  10:30\n     -\n  11.20",cellLists.get(2).get(0), cellLists.get(2).get(1), cellLists.get(2).get(2), cellLists.get(2).get(3), cellLists.get(2).get(4), cellLists.get(2).get(5), cellLists.get(2).get(6));
    static Row row4 = new Row("\n\n  11:30\n     -\n  12.20",cellLists.get(3).get(0), cellLists.get(3).get(1), cellLists.get(3).get(2), cellLists.get(3).get(3), cellLists.get(3).get(4), cellLists.get(3).get(5), cellLists.get(3).get(6));
    static Row row5 = new Row("\n\n  13:00\n     -\n  13.50",cellLists.get(4).get(0), cellLists.get(4).get(1), cellLists.get(4).get(2), cellLists.get(4).get(3), cellLists.get(4).get(4), cellLists.get(4).get(5), cellLists.get(4).get(6));
    static Row row6 = new Row("\n\n  14:00\n     -\n  14.50",cellLists.get(5).get(0), cellLists.get(5).get(1), cellLists.get(5).get(2), cellLists.get(5).get(3), cellLists.get(5).get(4), cellLists.get(5).get(5), cellLists.get(5).get(6));
    static Row row7 = new Row("\n\n  15:00\n     -\n  15.50",cellLists.get(6).get(0), cellLists.get(6).get(1), cellLists.get(6).get(2), cellLists.get(6).get(3), cellLists.get(6).get(4), cellLists.get(6).get(5), cellLists.get(6).get(6));
    static Row row8 = new Row("\n\n  16:00\n     -\n  16.50",cellLists.get(7).get(0), cellLists.get(7).get(1), cellLists.get(7).get(2), cellLists.get(7).get(3), cellLists.get(7).get(4), cellLists.get(7).get(5), cellLists.get(7).get(6));
//    StringConverter<String> converter = new DefaultStringConverter();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//      for(int i=0;i<8;i++) {
//            for(int j=0;j<7;j++) {
//                cellLists.get(i).get(j).setEditable(true);
//                cellLists.get(i).get(j).setCellFactory(param -> new TextFieldListCell<>(converter));
//            }
//        }
        write();
        timeCol.setCellValueFactory(new PropertyValueFactory<Row,String>("time"));
        mondayCol.setCellValueFactory(new PropertyValueFactory<Row,ListView>("monday"));
        tuesdayCol.setCellValueFactory(new PropertyValueFactory<Row,ListView>("tuesday"));
        wednesdayCol.setCellValueFactory(new PropertyValueFactory<Row,ListView>("wednesday"));
        thursdayCol.setCellValueFactory(new PropertyValueFactory<Row,ListView>("thursday"));
        fridayCol.setCellValueFactory(new PropertyValueFactory<Row,ListView>("friday"));
        saturdayCol.setCellValueFactory(new PropertyValueFactory<Row,ListView>("saturday"));
        sundayCol.setCellValueFactory(new PropertyValueFactory<Row,ListView>("sunday"));
        table.setItems(getRows());
    }
    public static ObservableList<Row> getRows(){
        ObservableList<Row> rows = FXCollections.observableArrayList();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);
        return rows;
    }
    @FXML
    public void turnBack() throws IOException {
        Stage stage1 = (Stage) table.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prgScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage1.setTitle("Welcome");
        stage1.setMaximized(false);
        stage1.setScene(scene);
        stage1.show();
    }
    @FXML
    public void addScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addScene.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Add/Update Course");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void saveToFile(){
        try (FileWriter writer = new FileWriter(User.getFileName())) {
            for(int i = 0; i<8;i++){
                for(int j =0; j<7;j++){
                    writer.write(cellItems.get(i).get(j).get(0) + ":" + cellItems.get(i).get(j).get(1) + ":" + cellItems.get(i).get(j).get(2) + ":" + cellItems.get(i).get(j).get(3) + ":" +cellItems.get(i).get(j).get(4)+ ";");
                }
                writer.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

