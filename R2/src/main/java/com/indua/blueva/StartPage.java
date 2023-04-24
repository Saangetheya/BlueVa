package com.indua.blueva;

import com.indua.blueva.props.BJPackage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class StartPage implements Initializable {
    @FXML
    TabPane tabPane;

    @FXML
    ImageView imageOnStack;
    @FXML
    StackPane imageStack;

    public void newPackTab(String pname) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartPage.class.getResource("Page.fxml"));
        AnchorPane classAnchor = fxmlLoader.load();
        Page page = fxmlLoader.getController();
        page.setPackageName(pname);
        Label label = (Label) classAnchor.lookup("#package_name");
        label.setText(pname);
        Tab tab = new Tab(pname,classAnchor);
        tabPane.getTabs().add(tab);
        Misc.tabPageHashMap.put(tabPane.getTabs().indexOf(tab),page);
        Misc.currentTab = page.getAnchorage();
        Misc.currentPage = page;
        tabPane.getSelectionModel().select(tab);
        BJPackage bjPackage = BJPackage.createInstance(pname);
        page.setBjPackage(bjPackage);
        tab.setOnCloseRequest(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are you sure you want to close this window?");
            alert.setContentText("Any unsaved changes will be lost.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                tabPane.getTabs().remove(tab); // close the window if the user confirms
            }
            else{
                e.consume();
                alert.close();
            }
        });
    }
    public void createPackage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(StartPage.class.getResource("EnterPname.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Package Name");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if(number.intValue()!=-1 && t1.intValue()!=-1) {
                    Page page = Misc.tabPageHashMap.get(tabPane.getSelectionModel().getSelectedIndex());
                    Misc.currentPage = page;
                    Misc.currentTab = page.anchorage;
                }
            }
        });
    }
    @FXML
    void exitPage(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to close BlueVa?");
        alert.setContentText("Any unsaved changes will be lost.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Loading.staticStartStage.close(); // close the window if the user confirms
        } else {
            alert.close();
        }
    }
    @FXML
    void detailAbout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("About.fxml")));
        Scene scene = new Scene(anchorPane,540,550);
        Stage stage = new Stage();
        stage.setTitle("About BlueVa");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(new Image("D:\\PHOTOS\\assets\\BlueVa.jpg"));
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void contribute(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/Saangetheya/BlueVa"));
    }
}
