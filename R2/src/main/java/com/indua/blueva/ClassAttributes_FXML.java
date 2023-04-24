package com.indua.blueva;


        import com.indua.blueva.Misc;
        import com.indua.blueva.props.BJClass;
        import com.indua.blueva.props.BJField;
        import com.indua.blueva.utils.*;
        import javafx.beans.value.ChangeListener;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;

        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;

        import javax.lang.model.element.Modifier;
        import java.util.Scanner;

//        import static com.sun.beans.introspect.ClassInfo.clear;

public class ClassAttributes_FXML {
    @FXML

    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public RadioButton rb5;
    public RadioButton rb6;
    public RadioButton rb7;
    public RadioButton rb8;
    public RadioButton rb9,r11,r12,p1,p2,p3,p4,f1,f2;
    public Button cl1;
    public Button add_btn;

    public TextField name1;
    public TextField n1;

    private ChangeListener<String> currentListener;
    public void clear() {
        name1.clear();
        n1.clear();
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
        rb5.setSelected(false);
        rb6.setSelected(false);
        rb7.setSelected(false);
        rb8.setSelected(false);
        rb9.setSelected(false);
        r11.setSelected(false);
        r12.setSelected(false);

        p1.setSelected(false);
        p2.setSelected(false);
        p3.setSelected(false);
        p4.setSelected(false);
        f1.setSelected(false);
        f2.setSelected(false);
    }


    private EventHandler<ActionEvent> radioButtonHandler = event -> {
        if (currentListener != null) {
            name1.textProperty().removeListener(currentListener);
        }

        if (rb1.isSelected()) {
            name1.clear();
            r11.setVisible(false);
            r12.setVisible(false);
            name1.setVisible(true);
            name1.setPromptText("Enter an integer valColumn");

            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    name1.setText(newValue.replaceAll("[^\\d]", ""));
                }
            };
        } else if (rb2.isSelected()) {
            name1.clear();
            r11.setVisible(false);
            r12.setVisible(false);
            name1.setVisible(true);
            name1.setPromptText("Enter a decimal valColumn");

            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*\\.?\\d*")) {
                    name1.setText(oldValue);
                }
            };
        } else if (rb3.isSelected()) {
            name1.clear();
            r11.setVisible(false);
            r12.setVisible(false);
            name1.setVisible(true);
            name1.setPromptText("Enter a double valColumn");

            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*\\.?\\d*[dD]?")) {
                    name1.setText(oldValue);
                }
            };
        } else if (rb4.isSelected()) {
            name1.clear();
            r11.setVisible(false);
            r12.setVisible(false);
            name1.setVisible(true);
            name1.setPromptText("Enter a letter");

            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\p{L}?")) {
                    name1.setText(oldValue);
                }
            };
        } else if (rb5.isSelected()) {
            name1.clear();
            r11.setVisible(false);
            r12.setVisible(false);
            name1.setVisible(true);
            name1.setPromptText("Enter any valColumn");

            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches(".*")) {
                    name1.setText(oldValue);
                }
            };
        } else if (rb6.isSelected()) {
            name1.clear();
            name1.setVisible(false);
            r11.setDisable(false);
            r12.setDisable(false);
            r11.setVisible(true);
            r12.setVisible(true);
        }else if (rb7.isSelected()) {
            name1.clear();
            r11.setVisible(false);
            r12.setVisible(false);
            name1.setVisible(true);
            name1.setPromptText("Enter a short valColumn");

            currentListener = (observable, oldValue, newValue) -> {
                try {
                    short value = Short.parseShort(newValue);
                    name1.setText(String.valueOf(value));
                } catch (NumberFormatException e) {
                    name1.setText(oldValue);
                }
            };
        } else if (rb8.isSelected()) {
            name1.clear();
            r11.setVisible(false);
            r12.setVisible(false);
            name1.setVisible(true);
            name1.setPromptText("Enter a long valColumn");

            currentListener = (observable, oldValue, newValue) -> {
                try {
                    long value = Long.parseLong(newValue);
                    name1.setText(String.valueOf(value));
                } catch (NumberFormatException e) {
                    name1.setText(oldValue);
                }
            };
        } else if (rb9.isSelected()) {
            name1.clear();
            r11.setVisible(false);
            r12.setVisible(false);
            name1.setVisible(true);
            name1.setPromptText("Enter a byte valColumn");

            currentListener = (observable, oldValue, newValue) -> {
                try {
                    byte value = Byte.parseByte(newValue);
                    name1.setText(String.valueOf(value));
                } catch (NumberFormatException e) {
                    name1.setText(oldValue);
                }
            };
        }


    };
    @FXML
    void attributeAdded(MouseEvent event) {
        BJClass bjClass = Misc.hashClass.get(Misc.ImVeryConfused);
        BJField bjField = BJField.createInstance();
        bjField.setName(n1.getText());
        if(p1.isSelected()){
            bjField.setAccModifier(BJAccessModifier.PUBLIC);
        }
        else if(p2.isSelected()){
            bjField.setAccModifier(BJAccessModifier.PRIVATE);
        }
        else if(p3.isSelected()){
            bjField.setAccModifier(BJAccessModifier.PROTECTED);
        }
        else {
            bjField.setAccModifier(BJAccessModifier.DEFAULT);
        }
        bjField.setValue(name1.getText());
        if(f1.isSelected()){
            bjField.setNaccModifier(Modifier.FINAL);
        }
        else if(f2.isSelected()){
            bjField.setNaccModifier(Modifier.STATIC);
        }
        else{
            bjField.setNaccModifier(Modifier.DEFAULT);
        }
        if(rb1.isSelected()){
            bjField.setOutput(BJPrimTypes.INT);
        }
        else if(rb2.isSelected()){
            bjField.setOutput(BJPrimTypes.FLOAT);
        }
        else if(rb3.isSelected()){
            bjField.setOutput(BJPrimTypes.DOUBLE);
        }
        else if(rb4.isSelected()){
            bjField.setOutput(BJPrimTypes.CHAR);
        }
        else if(rb5.isSelected()){
            bjField.setOutput(BJPrimTypes.STRING);
        }
        else if(rb6.isSelected()){
            bjField.setOutput(BJPrimTypes.BOOLEAN);
        }
        else if(rb7.isSelected()){
            bjField.setOutput(BJPrimTypes.SHORT);
        }
        else if(rb8.isSelected()){
            bjField.setOutput(BJPrimTypes.LONG);
        }
        else if(rb9.isSelected()){
            bjField.setOutput(BJPrimTypes.BYTE);
        }
        if(Misc.againMapped.containsKey(bjField.getName())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate Names!");
            alert.setContentText("The name has already been defined before!");
            alert.show();
        }
        else{
            bjClass.addField(bjField);
            Misc.againMapped.put(bjField.getName(),bjField);
            Button add = (Button) event.getSource();
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
        }
    }

    public void initialize() {
        rb1.setOnAction(radioButtonHandler);
        rb2.setOnAction(radioButtonHandler);
        rb3.setOnAction(radioButtonHandler);
        rb4.setOnAction(radioButtonHandler);
        rb5.setOnAction(radioButtonHandler);
        rb6.setOnAction(radioButtonHandler);
        rb7.setOnAction(radioButtonHandler);
        rb8.setOnAction(radioButtonHandler);
        rb9.setOnAction(radioButtonHandler);
        cl1.setOnAction(event -> clear());
    }
}