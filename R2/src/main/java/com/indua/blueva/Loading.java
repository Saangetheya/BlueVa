package com.indua.blueva;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.indua.blueva.Main.stage0;

public class Loading implements Initializable {
    public static StartPage staticstartPage;
    public static Stage staticStartStage;
    @FXML
    private Stage stage ;
    private Scene scene;
    private Parent root;
    @FXML
    ProgressBar progressBar;
    public void initialize(URL arg0, ResourceBundle arg1){
        progressBar.setStyle("-fx-accent: #BD586F;");
        loadingBar();
    }

    public void loadingBar(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(50), event -> {
                    double progress = progressBar.getProgress() + 0.01;
                    progressBar.setProgress(progress);
                })
        );
        timeline.setCycleCount(100);//100
        timeline.setOnFinished(event -> {
            try {
                afterLoad0();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        timeline.play();
    }
    public void afterLoad(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void afterLoad0() throws IOException {
        stage0.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Loading.class.getResource("StartPage.fxml"));
        Parent root = fxmlLoader.load();
        staticstartPage = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setOnCloseRequest(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are you sure you want to close BlueVa?");
            alert.setContentText("Any unsaved changes will be lost.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                stage.close(); // close the window if the user confirms
            } else {
                e.consume();
                alert.close();
            }
        });
        stage.getIcons().add(new Image("D:\\PHOTOS\\assets\\BlueVa.jpg"));
        stage.setTitle("BlueVa");
        stage.setMinWidth(250);
        stage.setScene(scene);
        staticStartStage = stage;
        stage.show();
    }
}
