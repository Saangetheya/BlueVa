package com.indua.blueva;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Testing extends Application {
    @FXML
    AnchorPane anchor1;

    @Override
    public void start(Stage stage) throws Exception {
//        Draggable draggable = new Draggable();
////        draggable.makeDraggable(anchor1);
//        DragResizeMod.makeResizable(anchor1);
//        titledPane.setMaxWidth(200);
//        titledPane.
//        anchor1.setLayoutX(100);
//        anchor1.setLayoutY(30);
        StackPane stackPane = new StackPane(anchor1);
        Group root = new Group(stackPane);
        Scene scene = new Scene(root,600,600);
        stage.setTitle("NS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
