package com.indua.blueva;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ImportTable implements Initializable {
    @FXML
    private TableColumn<ImportObj,String> nameColumn;

    @FXML
    private Button removeImport;

    @FXML
    private TableView<ImportObj> table_import;

    @FXML
    void removeMethod(MouseEvent event) {
        int selID = table_import.getSelectionModel().getSelectedIndex();
        table_import.getItems().remove(selID);
        removeImport.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<ImportObj,String>("nameColumn"));
        table_import.getSelectionModel().selectedItemProperty().addListener((v,o,d)-> {
            removeImport.setDisable(o == d);
        });
    }
    public void viewClassAttTable(ObservableList<ImportObj> importObjs){
        table_import.setItems(importObjs);
    }
}
