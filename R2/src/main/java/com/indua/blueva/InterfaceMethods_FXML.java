package com.indua.blueva;

import com.indua.blueva.props.BJInterface;
import com.indua.blueva.props.BJMethodInterface;
import com.indua.blueva.props.BJParameter;
import com.indua.blueva.utils.BJAccessModifier;
import com.indua.blueva.utils.BJNAccessModifierMethod;
import com.indua.blueva.utils.BJPrimTypes;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class InterfaceMethods_FXML {
    @FXML
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public RadioButton rb5;
    public RadioButton rb6;
    public RadioButton rb7;
    public RadioButton rb8;
    public RadioButton rb9;
    public TextField name1;
    @FXML
    public Button cl1;
    @FXML
    public TextField l1;

    public void clear() {
        name1.clear();
        l1.clear();
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
        rb5.setSelected(false);
        rb6.setSelected(false);
        rb7.setSelected(false);
        rb8.setSelected(false);
        rb9.setSelected(false);

    }
    public void initialize() {
        cl1.setOnAction(event -> clear());
    }

    @FXML
    void addMethod0(MouseEvent event) {
        BJInterface bjInterface = Misc.hashInter.get(Misc.ImVeryConfused);
        BJMethodInterface bjMethodInterface = BJMethodInterface.createInstance();
        bjMethodInterface.setName(name1.getText());
        bjMethodInterface.setAccModifier(BJAccessModifier.PUBLIC);
        bjMethodInterface.setNaccModifier(BJNAccessModifierMethod.STATIC);
        if(rb1.isSelected()){
            bjMethodInterface.setOutput(BJPrimTypes.INT);
        }
        else if(rb2.isSelected()){
            bjMethodInterface.setOutput(BJPrimTypes.FLOAT);
        }
        else if(rb3.isSelected()){
            bjMethodInterface.setOutput(BJPrimTypes.DOUBLE);
        }
        else if(rb4.isSelected()){
            bjMethodInterface.setOutput(BJPrimTypes.CHAR);
        }
        else if(rb5.isSelected()){
            bjMethodInterface.setOutput(BJPrimTypes.STRING);
        }
        else if(rb6.isSelected()){
            bjMethodInterface.setOutput(BJPrimTypes.BOOLEAN);
        }
        else if(rb7.isSelected()){
            bjMethodInterface.setOutput(BJPrimTypes.SHORT);
        }
        else if(rb8.isSelected()){
            bjMethodInterface.setOutput(BJPrimTypes.LONG);
        }
        else if(rb9.isSelected()){
            bjMethodInterface.setOutput(BJPrimTypes.BYTE);
        }
        String X = l1.getText();
        String[] A = X.split(",");
        for (String s : A) {
            s = s.trim();
            String[] B = s.split(" ");
            BJParameter bjParameter = BJParameter.createInstance();
            bjParameter.setName(B[1]);
            if (Objects.equals(B[0], "int")) {
                bjParameter.setOutput(BJPrimTypes.INT);
            } else if (Objects.equals(B[0], "float")) {
                bjParameter.setOutput(BJPrimTypes.FLOAT);
            } else if (Objects.equals(B[0], "double")) {
                bjParameter.setOutput(BJPrimTypes.DOUBLE);
            } else if (Objects.equals(B[0], "char")) {
                bjParameter.setOutput(BJPrimTypes.CHAR);
            } else if (Objects.equals(B[0], "string")) {
                bjParameter.setOutput(BJPrimTypes.STRING);
            } else if (Objects.equals(B[0], "boolean")) {
                bjParameter.setOutput(BJPrimTypes.BOOLEAN);
            } else if (Objects.equals(B[0], "short")) {
                bjParameter.setOutput(BJPrimTypes.SHORT);
            } else if (Objects.equals(B[0], "long")) {
                bjParameter.setOutput(BJPrimTypes.LONG);
            } else if (Objects.equals(B[0], "byte")) {
                bjParameter.setOutput(BJPrimTypes.BYTE);
            }
            bjMethodInterface.addParameter(bjParameter);
        }
        if(Misc.notagain0.containsKey(bjInterface.getName())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate Names!");
            alert.setContentText("The name has already been defined before!");
            alert.show();
        }
        else {
            Misc.notagain0.put(bjInterface.getName(),bjMethodInterface);
            bjInterface.addMethod(bjMethodInterface);
            Button add = (Button) event.getSource();
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
        }

    }

}
