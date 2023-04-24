package com.indua.blueva;

import com.indua.blueva.props.BJClass;
import com.indua.blueva.props.BJField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class OpenClassAttrController implements Initializable {
    @FXML
    Button removeAttr;
    @FXML
    private TableView<ClassAttrObj> table_attr;
    @FXML
    private TableColumn<ClassAttrObj,String> accColumn;
    @FXML
    private TableColumn<ClassAttrObj, String> naccColumn;

    @FXML
    private TableColumn<ClassAttrObj, String > nameColumn;

    @FXML
    private TableColumn<ClassAttrObj, String > typeColumn;

    @FXML
    private TableColumn<ClassAttrObj, String> valColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<ClassAttrObj,String>("nameColumn"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<ClassAttrObj,String>("typeColumn"));
        accColumn.setCellValueFactory(new PropertyValueFactory<ClassAttrObj,String>("accColumn"));
        naccColumn.setCellValueFactory(new PropertyValueFactory<ClassAttrObj,String>("naccColumn"));
        valColumn.setCellValueFactory(new PropertyValueFactory<ClassAttrObj,String>("valColumn"));
        table_attr.getSelectionModel().selectedItemProperty().addListener((v,o,d)-> {
            removeAttr.setDisable(o == d);
        });
    }
    public void viewClassAttTable(ObservableList<ClassAttrObj> classAttrObjs){
        table_attr.setItems(classAttrObjs);
    }
    @FXML
    void removeAttribute(MouseEvent event) {
        int selID = table_attr.getSelectionModel().getSelectedIndex();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        ClassAttrObj classAttrObj = table_attr.getItems().get(selID);
        bjClass.removeField(Misc.againMapped.get(classAttrObj.getNameColumn()));
        Misc.againMapped.remove(classAttrObj.getNameColumn());
        table_attr.getItems().remove(selID);
        removeAttr.setDisable(true);
    }
}
