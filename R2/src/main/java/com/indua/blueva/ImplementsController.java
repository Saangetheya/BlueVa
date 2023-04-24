package com.indua.blueva;

import com.indua.blueva.props.BJClass;
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

public class ImplementsController implements Initializable {
    public TableColumn<ImplementObj, String > nameColumn;
    @FXML
    Button removeAttr;
    @FXML
    private TableView<ImplementObj> table_attr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<ImplementObj,String>("nameColumn"));
        table_attr.getSelectionModel().selectedItemProperty().addListener((v,o,d)-> {
            removeAttr.setDisable(o == d);
        });
    }
    public void viewImplements(ObservableList<ImplementObj> implementObjs){
        table_attr.setItems(implementObjs);
    }
    @FXML
    void removeAttribute(MouseEvent event) {
        int selID = table_attr.getSelectionModel().getSelectedIndex();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        ImplementObj implementObj = table_attr.getItems().get(selID);
        bjClass.removeInterface(implementObj.getNameColumn());
        table_attr.getItems().remove(selID);
        removeAttr.setDisable(true);
    }
}
