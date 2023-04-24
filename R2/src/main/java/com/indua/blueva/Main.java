package com.indua.blueva;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    public static Scene scene;
    public static Stage stage0;
    @Override
    public void start(Stage stage) throws IOException,IllegalArgumentException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Loading.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 400);
        stage0 = stage;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}