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

public class OpenClassMethController implements Initializable {
    @FXML
    private TableView<ClassMethObj> table_meth;
    @FXML
    private TableColumn<ClassMethObj,String> accColumn;
    @FXML
    private TableColumn<ClassMethObj, String> naccColumn;

    @FXML
    private TableColumn<ClassMethObj, String > nameColumn;

    @FXML
    private TableColumn<ClassMethObj, String > returnColumn;

    @FXML
    private TableColumn<ClassMethObj, String > parameterColumn;

    @FXML
    private TableColumn<ClassMethObj, String> bodyColumn;


    @FXML
    private Button removeMeth;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<ClassMethObj,String>("nameColumn"));
        returnColumn.setCellValueFactory(new PropertyValueFactory<ClassMethObj,String>("returnColumn"));
        accColumn.setCellValueFactory(new PropertyValueFactory<ClassMethObj,String>("accColumn"));
        naccColumn.setCellValueFactory(new PropertyValueFactory<ClassMethObj,String>("naccColumn"));
        bodyColumn.setCellValueFactory(new PropertyValueFactory<ClassMethObj,String>("bodyColumn"));
        parameterColumn.setCellValueFactory(new PropertyValueFactory<ClassMethObj,String>("parameterColumn"));
        table_meth.getSelectionModel().selectedItemProperty().addListener((v,o,d)-> removeMeth.setDisable(o == d));
    }
    public void viewClassMethTable(ObservableList<ClassMethObj> classMethObjs){
        table_meth.setItems(classMethObjs);
    }
    @FXML
    void removeMethod(MouseEvent event) {
        int selID = table_meth.getSelectionModel().getSelectedIndex();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        ClassMethObj classMethObj = table_meth.getItems().get(selID);
        bjClass.removeMethod(Misc.notagain.get(classMethObj.getNameColumn()));
        Misc.notagain.remove(classMethObj.getNameColumn());
        removeMeth.setDisable(true);
        table_meth.getItems().remove(selID);
    }
}
