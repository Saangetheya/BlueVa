package com.example.blueva;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Loading implements Initializable {
    @FXML
    private ProgressBar loadingprgrs;
    double prgs;
    public void initialize(URL arg0, ResourceBundle arg1){
        loadingprgrs.setStyle("-fx-accent: #ffb3b3;");
        loadingBar();
    }

    public void loadingBar(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(prgs<=1) {
                    prgs += 0.01;
                    loadingprgrs.setProgress(prgs);
                }
                else{
                    timer.cancel();
                    try {
                        SceneController.afterLoad();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task,0,90);
    }
}
