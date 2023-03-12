package com.example.hellofx;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Curve extends Application {
    private double startX, startY;
    private Line line;

    public void start(Stage stage) {
        line = new Line();
        line.setStartX(100);
        line.setStartY(100);
        line.setEndX(200);
        line.setEndY(200);

        Circle startNode = createNode(line.getStartX(), line.getStartY());
        Circle endNode = createNode(line.getEndX(), line.getEndY());

        Pane pane = new Pane(line, startNode, endNode);
        Scene scene = new Scene(pane, 400, 400);

        // event handlers for start node
        startNode.setOnMousePressed(event -> {
            startX = event.getX();
            startY = event.getY();
        });
        startNode.setOnMouseDragged(event -> {
            double offsetX = event.getX() - startX;
            double offsetY = event.getY() - startY;
            line.setStartX(line.getStartX() + offsetX);
            line.setStartY(line.getStartY() + offsetY);
            startX = event.getX();
            startY = event.getY();
        });

        // event handlers for end node
        endNode.setOnMousePressed(event -> {
            startX = event.getX();
            startY = event.getY();
        });
        endNode.setOnMouseDragged(event -> {
            double offsetX = event.getX() - startX;
            double offsetY = event.getY() - startY;
            line.setEndX(line.getEndX() + offsetX);
            line.setEndY(line.getEndY() + offsetY);
            startX = event.getX();
            startY = event.getY();
        });

        stage.setScene(scene);
        stage.show();
    }

    private Circle createNode(double x, double y) {
        Circle node = new Circle(x, y, 5, Color.RED);
        node.setCursor(Cursor.HAND);
        return node;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
