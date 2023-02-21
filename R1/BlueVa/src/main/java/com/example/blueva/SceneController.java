package com.example.blueva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class SceneController {
    @FXML
    private static Stage stage = new Stage();
    private static Scene scene;
    private static Parent root;
    public static void afterLoad() throws IOException{
//        root = FXMLLoader.load(Objects.requireNonNull(SceneController.class.getResource("Blueprints.fxml")));
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Blueprints.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 400);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
}