package com.example.hellofx;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MethodInterface {
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


}

