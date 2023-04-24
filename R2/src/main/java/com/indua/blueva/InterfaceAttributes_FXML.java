package com.indua.blueva;

        import com.indua.blueva.props.BJClass;
        import com.indua.blueva.props.BJField;
        import com.indua.blueva.props.BJFieldI;
        import com.indua.blueva.props.BJInterface;
        import com.indua.blueva.utils.*;
        import javafx.beans.value.ChangeListener;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;

        import javafx.scene.control.Alert;
        import javafx.scene.control.Button;
        import javafx.scene.control.RadioButton;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;

        import javax.lang.model.element.Modifier;

public class InterfaceAttributes_FXML {
    @FXML

    public void Add(ActionEvent e){
        System.out.println("print integer");
    }
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public RadioButton rb5;
    public RadioButton rb6;
    public RadioButton rb7;
    public RadioButton rb8;
    public RadioButton rb9,r11,r12;
    public Button cl1;
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

    }
    private EventHandler<ActionEvent> radioButtonHandler = event -> {
        if (currentListener != null) {
            name1.textProperty().removeListener(currentListener);
        }

        if (rb1.isSelected()) {
            // name1.setDisable(false);
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


    @FXML
    void addAttribute0(MouseEvent event) {
        BJInterface bjClass = Misc.hashInter.get(Misc.ImVeryConfused);
        BJFieldI bjField = BJFieldI.createInstance();
        bjField.setName(n1.getText());
        bjField.setAccModifier(Modifier.PUBLIC);
        bjField.setNaccModifier(Modifier.FINAL);
        bjField.setValue(name1.getText());
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
        if(Misc.againMapped0.containsKey(bjField.getName())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate Names!");
            alert.setContentText("The name has already been defined before!");
            alert.show();
        }
        else {
            Misc.againMapped0.put(bjField.getName(),bjField);
            bjClass.addField(bjField);
            Button add = (Button) event.getSource();
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
        }
    }


}