package com.indua.blueva;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.util.Optional;

public class AddImports {
    public javafx.scene.control.TextArea importText;
    public javafx.scene.control.Button doneImportBtn;

    @FXML
    void clearImports(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Clear PSVM");
        alert.setHeaderText("Are you sure you want to clear the Imports?");
        alert.setContentText("All changes would be lost.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            importText.clear();
        } else {
            alert.close();
        }
    }

    @FXML
    String[] doneImports(MouseEvent event) {
        String text = importText.getText();
        return text.split("\n");
    }

}
