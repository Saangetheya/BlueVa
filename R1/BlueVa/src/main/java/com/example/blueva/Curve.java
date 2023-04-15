package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Curve extends Application {
    private double startX, startY, endX, endY;
    private Path line;
    private Label label1, label2;
    private boolean lineVisible = false;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        label1 = new Label("Label 1");
        label2 = new Label("Label 2");
        label1.setTranslateX(50);
        label1.setTranslateY(50);
        label2.setTranslateX(300);
        label2.setTranslateY(200);
        pane.getChildren().addAll(label1, label2);

        label1.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                startX = label1.getTranslateX() + label1.getWidth() / 2;
                startY = label1.getTranslateY() + label1.getHeight() / 2;
                endX = startX;
                endY = startY;
                line = new Path();
                line.setStrokeWidth(2);
                line.setStroke(Color.BLACK);
                pane.getChildren().add(line);
                lineVisible = true;
            }
        });

        label1.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY && lineVisible) {
                endX = event.getX();
                endY = event.getY();
                updateArrowLine();
            }
        });

        label1.setOnMouseReleased(event -> {
            if (event.getButton() == MouseButton.PRIMARY && lineVisible) {
                boolean isLineTouchingLabel2 = line.intersects(label2.getBoundsInParent());
                if (isLineTouchingLabel2) {
                    // Line touches Label 2, update the arrow line
                    endX = label2.getTranslateX() + label2.getWidth() / 2;
                    endY = label2.getTranslateY() + label2.getHeight() / 2;
                    updateArrowLine();
                } else {
                    // Line released outside of Label 2, remove line
                    pane.getChildren().remove(line);
                    lineVisible = false;
                }
                line = null; // Reset the line reference
            }
        });


        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Arrow Line");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateArrowLine() {
        double arrowSize = 10; // Size of the arrowhead
        double angle = Math.atan2(endY - startY, endX - startX); // Angle of the line
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);

        // Calculate the coordinates of the arrowhead points
        double x1 = endX - arrowSize * cos - arrowSize * sin;
        double y1 = endY - arrowSize * sin + arrowSize * cos;
        double x2 = endX - arrowSize * cos + arrowSize * sin;
        double y2 = endY - arrowSize * sin - arrowSize * cos;

        // Update the arrow line
        line.getElements().clear();
        line.getElements().add(new MoveTo(startX, startY));
        line.getElements().add(new LineTo(endX, endY));
        line.getElements().add(new MoveTo(endX, endY));
        line.getElements().add(new LineTo(x1, y1));
        line.getElements().add(new MoveTo(endX, endY));
        line.getElements().add(new LineTo(x2, y2));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
