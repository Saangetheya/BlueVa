package com.indua.blueva;

import com.indua.blueva.props.BJPackage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.MenuBar;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class Page implements Initializable {    
    AnchorPane anchorage;
    @FXML
    StackPane stackage;
    private String packageName;
    private BJPackage bjPackage;

    public BJPackage getBjPackage() {
        return bjPackage;
    }

    public void setBjPackage(BJPackage bjPackage) {
        this.bjPackage = bjPackage;
    }

    public AnchorPane getAnchorage() {
        return anchorage;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public String getPackageName() {
        return packageName;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        anchorage = new AnchorPane();
        anchorage.setFocusTraversable(false);
        MyController myController = new MyController(anchorage);
        stackage.getChildren().add(myController);
    }


    public void createPSVM(ActionEvent event) throws IOException {
        AnchorPane classAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PSVM_FXML.fxml")));
        DragResizeMod.makeResizable(classAnchor);
        anchorage.getChildren().add(classAnchor);
    }
    public void createImports(ActionEvent event) throws IOException {
        AnchorPane classAnchor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Imports_FXML.fxml")));
        DragResizeMod.makeResizable(classAnchor);
        anchorage.getChildren().add(classAnchor);
    }

    @FXML
    AnchorPane main_anchor;
    @FXML
    void createClass0(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Page.class.getResource("EnterCname.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Class Name");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void createInterface0(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Page.class.getResource("EnterIname.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Interface Name");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void changeTheName(ActionEvent event) throws IOException {
        Label txt = (Label) main_anchor.lookup("#package_name");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EnterNewName.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setTitle("Set Name");
        stage.setScene(scene);
        stage.show();
        EnterNewName enterNewName = fxmlLoader.getController();
        enterNewName.donePack.setOnMouseClicked(e->{
            txt.setText(enterNewName.packNew.getText());
            bjPackage.setPackageName(enterNewName.packNew.getText());
            stage.close();
        });
    }
    @FXML
    void exitPackage(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Tab");
        alert.setHeaderText("Are you sure you want to exit this Tab?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Tab selectedTab = Loading.staticstartPage.tabPane.getSelectionModel().getSelectedItem();
            Loading.staticstartPage.tabPane.getTabs().remove(selectedTab);
        } else {
            alert.close();
        }
    }
    @FXML
    void hideElem(ActionEvent event) throws IOException {
        CheckMenuItem checkMenuItem = (CheckMenuItem) event.getSource();
//        MenuItem menuItem = (MenuItem) event.getSource();
//        Menu menu = checkMenuItem.getParentMenu();
        ContextMenu contextMenu = checkMenuItem.getParentPopup();
        Node ownerNode = contextMenu.getOwnerNode();
        AnchorPane anchorPane = (AnchorPane) ownerNode.getParent().getParent().getParent();
        if(checkMenuItem.isSelected()){
            Label lbl = (Label) anchorPane.lookup("#element_lbl");
            lbl.setVisible(false);
            ScrollPane scroll = (ScrollPane) anchorPane.lookup("#elements_scroll");
            scroll.setVisible(false);
            StackPane stackPane = (StackPane) anchorPane.lookup("#stackage");
            stackPane.setLayoutX(1);
            AnchorPane.setLeftAnchor(stackPane,1.0);
        }
        else {
            Label lbl = (Label) anchorPane.lookup("#element_lbl");
            lbl.setVisible(true);
            ScrollPane scroll = (ScrollPane) anchorPane.lookup("#elements_scroll");
            scroll.setVisible(true);
            StackPane stackPane = (StackPane) anchorPane.lookup("#stackage");
            stackPane.setLayoutX(164);
            AnchorPane.setLeftAnchor(stackPane,164.0);
        }
    }

    @FXML
    void setDirectory(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Stage stage = new Stage();
        File selectedDirectory = directoryChooser.showDialog(stage);
        if(selectedDirectory == null){
        }else{
            String path = selectedDirectory.getAbsolutePath();
            bjPackage.setPackageDir(path);
        }
    }
    @FXML
    void runPackage(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Directory Created!");
        alert.setContentText("Src codes have been successfully generated!!");
        alert.show();
        bjPackage.build();
    }

}
