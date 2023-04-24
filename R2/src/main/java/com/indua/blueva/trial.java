package com.indua.blueva;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class trial extends Application {
    public void trial0(Stage stage){
        stage.setTitle("TESTING");
        RadioButton radioButton0 = new RadioButton("Public");
        RadioButton radioButton1 = new RadioButton("Protected");
        RadioButton radioButton2 = new RadioButton("Private");
        ToggleGroup group = new ToggleGroup();
        radioButton0.setToggleGroup(group);
        radioButton1.setToggleGroup(group);
        radioButton2.setToggleGroup(group);
        Separator separator0 = new Separator(Orientation.HORIZONTAL);
        Separator separator1 = new Separator(Orientation.HORIZONTAL);
        separator0.setMinWidth(120);
//        separator0.setHalignment(HPos.CENTER);
        separator1.setMinWidth(120);
//        separator1.setHalignment(HPos.CENTER);
        Button button00 = new Button("ATTRIBUTES");
        Button button01 = new Button("+");
        Button button10 = new Button("METHODS");
        button10.setMinWidth(80);
        Button button11 = new Button("+");
        Button button2 = new Button("DELETE");
        button2.setMinWidth(80);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setTopAnchor(radioButton0,2.0);
        anchorPane.setTopAnchor(radioButton1,21.0);
        anchorPane.setTopAnchor(radioButton2,40.0);
        anchorPane.setLeftAnchor(radioButton0,1.0);
        anchorPane.setLeftAnchor(radioButton1,1.0);
        anchorPane.setLeftAnchor(radioButton2,1.0);
        anchorPane.setTopAnchor(separator0,70.0);
        anchorPane.setTopAnchor(separator1,140.0);
        anchorPane.setTopAnchor(button2,145.0);
        anchorPane.setTopAnchor(button00,80.0);
        anchorPane.setTopAnchor(button01,80.0);
        anchorPane.setTopAnchor(button10,110.0);
        anchorPane.setTopAnchor(button11,110.0);
        anchorPane.setLeftAnchor(separator0,2.0);
        anchorPane.setLeftAnchor(separator1,2.0);
        anchorPane.setLeftAnchor(button00,1.0);
        anchorPane.setLeftAnchor(button01,100.0);
        anchorPane.setLeftAnchor(button10,1.0);
        anchorPane.setLeftAnchor(button11,100.0);
        anchorPane.setLeftAnchor(button2,20.0);
//        anchorPane.setPrefHeight(200);
        anchorPane.setMaxWidth(200.0);
        anchorPane.setMaxHeight(200.0);
//        anchorPane.setRightAnchor(radioButton0,5.0);
//        anchorPane.setRightAnchor(radioButton1,5.0);
//        anchorPane.setRightAnchor(radioButton2,5.0);
//        anchorPane.setBottomAnchor(radioButton0,70.0);
//        anchorPane.setBottomAnchor(radioButton1,40.0);
//        anchorPane.setBottomAnchor(radioButton2,10.0);
        anchorPane.getChildren().addAll(radioButton0,radioButton1,radioButton2,button00,button01,button11,button10, separator0,separator1,button2);

        TitledPane titledPane = new TitledPane("CLASS: Cname",anchorPane);
//        DragResizeMod.makeResizable(titledPane,null);
        DragResizeMod.makeResizable(titledPane);
//        titledPane.setMaxWidth(200);
//        titledPane.
        titledPane.setLayoutX(100);
        titledPane.setLayoutY(30);
        Group root = new Group(titledPane);
        Scene scene = new Scene(root,600,600);

//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        trial0(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
