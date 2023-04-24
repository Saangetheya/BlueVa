package com.indua.blueva;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClassExtend {

    @FXML
    Button clrExt;
    @FXML
    TextField extendClass;
    @FXML
    Button doneExt;

    @FXML
    void doneExtend(MouseEvent event) {
        String className = extendClass.getText();
    }
}
