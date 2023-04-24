package com.indua.blueva;

import com.indua.blueva.props.BJClass;
import com.indua.blueva.props.BJInterface;
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

public class OpenInterAttrController implements Initializable {
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
        BJInterface bjInterface = Misc.hashInter.get(Misc.ImVeryConfused);
        ClassAttrObj classAttrObj = table_attr.getItems().get(selID);
        bjInterface.removeField(Misc.againMapped0.get(classAttrObj.getNameColumn()));
        Misc.againMapped0.remove(classAttrObj.getNameColumn());
        table_attr.getItems().remove(selID);
        removeAttr.setDisable(true);
    }
}
