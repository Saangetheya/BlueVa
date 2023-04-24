package com.indua.blueva;

import com.indua.blueva.props.BJClass;
import com.indua.blueva.props.BJImport;
import com.indua.blueva.props.BJImports;
import com.indua.blueva.props.BJPackage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.IOException;
import java.util.Optional;

public class ImportController {
    @FXML
    void addImport(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddImports.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
        AddImports addImports = fxmlLoader.getController();
        Button getBtn = addImports.doneImportBtn;
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        getBtn.setOnMouseClicked(e -> {
            String[] X = addImports.importText.getText().split("\n");
            BJImports bjImports = BJImports.createInstance();
            BJImport bjImport;
            for (String x:
                 X) {
                System.out.println(x);
                x = x.trim();
                String[] y= x.split("\\.");
                bjImport = BJImport.createInstance();
                if(y.length==1){
                    bjImport.setPackageName(y[0]);
                    bjImport.setLeafName("");
                    bjImport.setSimpleName("");
                }
                else if(y.length==2){
                    bjImport.setPackageName(y[0]);
                    bjImport.setLeafName("");
                    bjImport.setSimpleName(y[1]);
                }
                else if(y.length==3){
                    bjImport.setPackageName(y[0]);
                    bjImport.setLeafName(y[2]);
                    bjImport.setSimpleName(y[1]);
                    System.out.println(y[0]+" "+y[1]+" "+y[2]);
                }

                else{
                    bjImport.setPackageName(y[0]);
                    bjImport.setLeafName("");
                    bjImport.setSimpleName("");
                }
                bjImports.addImport(bjImport);
            }
            bjClass.setStaticImports(bjImports);
            stage.close();
        });
    }

    @FXML
    void currentImport(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentImports.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        CurrentImports currentImports = fxmlLoader.getController();
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        StringBuilder stringBuilder = new StringBuilder();
        BJImports bjImports = bjClass.getStaticImports();
        for (BJImport bjImport:
             bjImports.getImportColl()) {
            stringBuilder.append(bjImport.getPackageName()+"."+bjImport.getSimpleName()+"."+bjImport.getLeafName()+"\n");
        }
        currentImports.currentImp.setText(stringBuilder.toString());
    }
    @FXML
    void deleteImports(MouseEvent event) {
        Button dlt = (Button)event.getSource();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Imports");
        alert.setHeaderText("Are you sure you want to delete the Imports?");
        alert.setContentText("This action cannot be undone.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            AnchorPane anchorPane = (AnchorPane) dlt.getParent().getParent().getParent().getParent();
            AnchorPane parentAnchor = (AnchorPane) anchorPane.getParent();
            parentAnchor.getChildren().remove(anchorPane);
        } else {
            alert.close();
        }
    }
}
