package com.example.hellofx;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Interface {
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
            name1.setPromptText("Enter an integer value");

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
            name1.setPromptText("Enter a decimal value");

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
            name1.setPromptText("Enter a double value");

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
            name1.setPromptText("Enter any value");

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
            name1.setPromptText("Enter a short value");

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
            name1.setPromptText("Enter a long value");

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
            name1.setPromptText("Enter a byte value");

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




}
