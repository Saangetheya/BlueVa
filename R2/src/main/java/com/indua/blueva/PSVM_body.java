package com.indua.blueva;

import com.indua.blueva.props.*;
import com.indua.blueva.utils.BJAccessModifier;
import com.indua.blueva.utils.BJPrimTypes;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.lang.model.element.Modifier;
import java.awt.*;
import java.util.Optional;

public class PSVM_body {
    public javafx.scene.control.TextArea textAreaPSVM;

    @FXML
    void clearPSVM(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Clear PSVM");
        alert.setHeaderText("Are you sure you want to clear the PSVM?");
        alert.setContentText("All changes would be lost.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            textAreaPSVM.clear();
            BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
            bjClass.removeMethod(Misc.notagain.get("main"));
            Misc.notagain.remove("main");
        } else {
            alert.close();
        }
    }

    @FXML
    void savePSVM(MouseEvent event) {
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        BJMethodClass bjMethodClass = BJMethodClass.createInstance();
        bjMethodClass.setAccModifier(BJAccessModifier.PUBLIC);
        bjMethodClass.setNaccModifier(Modifier.STATIC);
        bjMethodClass.setOutput(BJPrimTypes.VOID);
        bjMethodClass.setName("main");
        Misc.notagain.put("main",bjMethodClass);
        BJParameter bjParameter = BJParameter.createInstance();
        bjParameter.setName("args");
        bjParameter.setIsArray(true);
        bjParameter.setOutput(BJPrimTypes.STRING);
        bjMethodClass.addParameter(bjParameter);
        bjMethodClass.setCode(textAreaPSVM.getText());
        bjClass.addMethod(bjMethodClass);
    }

}
