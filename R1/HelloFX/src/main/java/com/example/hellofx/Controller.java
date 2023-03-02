package com.example.hellofx;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.Scanner;


public class Controller {

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
    public RadioButton rb9;

    public TextField name1;
    private ChangeListener<String> currentListener;

    private EventHandler<ActionEvent> radioButtonHandler = event -> {
        if (currentListener != null) {
            name1.textProperty().removeListener(currentListener);
        }

        if (rb1.isSelected()) {
            name1.clear();
            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    name1.setText(newValue.replaceAll("[^\\d]", ""));
                }

            };
        } else if (rb2.isSelected()) {
            name1.clear();
            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*\\.?\\d*")) {
                    name1.setText(oldValue);
                }
            };
        } else if (rb3.isSelected()) {
            name1.clear();
            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*\\.?\\d*[dD]?")) {
                    name1.setText(oldValue);
                }
            };
        } else if (rb4.isSelected()) {
            name1.clear();
            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\p{L}?")) {
                    name1.setText(oldValue);
                }
            };
        } else if (rb5.isSelected()) {
            name1.clear();
            currentListener = (observable, oldValue, newValue) -> {
                if (!newValue.matches(".*")) {
                    name1.setText(oldValue);
                }
            };
        }
      /*  else if (rb6.isSelected()) {
            currentListener = (observable, oldValue, newValue) -> {
                if (newValue.equals("true") || newValue.equals("false")) {
                    name1.setText(newValue);
                } else {
                    name1.setText(oldValue);
                }
            };
        }*/
        else if (rb7.isSelected()) {
            name1.clear();
            currentListener = (observable, oldValue, newValue) -> {
                try {
                    short value = Short.parseShort(newValue);
                    name1.setText(String.valueOf(value));
                } catch (NumberFormatException e) {
                    name1.setText(oldValue);
                }
            };
        }
        else if (rb8.isSelected()) {
            name1.clear();
            currentListener = (observable, oldValue, newValue) -> {
                try {
                    long value = Long.parseLong(newValue);
                    name1.setText(String.valueOf(value));
                } catch (NumberFormatException e) {
                    name1.setText(oldValue);
                }
            };
        }
        else if (rb9.isSelected()) {
            currentListener = (observable, oldValue, newValue) -> {
                try {
                    byte value = Byte.parseByte(newValue);
                    name1.setText(String.valueOf(value));
                } catch (NumberFormatException e) {
                    name1.setText(oldValue);
                }
            };
        }

        name1.textProperty().addListener(currentListener);
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
    }





}
