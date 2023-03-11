package com.example.hellofx;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MethodController {
    @FXML
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public RadioButton rb5;
    public RadioButton rb6;
    public RadioButton rb7;
    public RadioButton rb8;
    public RadioButton rb9,p1,p2,p3,f1,f2,d1;
    public TextField name1;
    public Button cl1;
    @FXML
    public TextField l1;
    @FXML
    public TextArea c1;

    public void clear() {
        name1.clear();
        l1.clear();
        c1.clear();
        d1.setSelected(false);
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
        rb5.setSelected(false);
        rb6.setSelected(false);
        rb7.setSelected(false);
        rb8.setSelected(false);
        rb9.setSelected(false);
        f1.setSelected(false);
        f2.setSelected(false);
        p1.setSelected(false);
        p2.setSelected(false);
        p3.setSelected(false);
    }
    public void initialize() {
        cl1.setOnAction(event -> clear());
    }


}

