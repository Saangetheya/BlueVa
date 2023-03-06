package com.example.hellofx;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Zoom extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create an AnchorPane with a Label inside
        Label label = new Label("Hello Sandeep");
        label.setStyle("-fx-font-size: 48px;");
        label.setTextFill(Color.BLUE);
        AnchorPane anchorPane = new AnchorPane(label);
        AnchorPane.setTopAnchor(label, 100.0);
        AnchorPane.setLeftAnchor(label, 100.0);

        // create a controller for zooming
        MyController zoomController = new MyController(anchorPane);

        // create a StackPane to hold the AnchorPane and the zoom controller
        StackPane root = new StackPane(zoomController);
        root.setPrefSize(600, 400);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MyController extends ScrollPane {
    private double scaleValue = 1.0;
    private double zoomIntensity = 0.02;
    private Node target;
    private Node zoomNode;

    public MyController(Node target) {
        super();
        this.target = target;
        this.zoomNode = new Group(target);
        setContent(outerNode(zoomNode));

        setPannable(true);
        setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // add horizontal scrollbar
        setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // add vertical scrollbar
        setFitToHeight(true);
        setFitToWidth(true);

        updateScale();

        target.setOnScroll(e -> {
            e.consume();
            onScroll(e.getTextDeltaY(), new Point2D(e.getX(), e.getY()));
        });
    }

    private Node outerNode(Node node) {
        Node outerNode = centeredNode(node);
        return outerNode;
    }

    private Node centeredNode(Node node) {
        VBox vBox = new VBox(node);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    private void updateScale() {
        target.setScaleX(scaleValue);
        target.setScaleY(scaleValue);
    }

    private void onScroll(double wheelDelta, Point2D mousePoint) {
        double zoomFactor = Math.exp(wheelDelta * zoomIntensity);

        scaleValue = scaleValue * zoomFactor;
        updateScale();
        this.layout(); // refresh ScrollPane scroll positions & target bounds

        // convert target coordinates to zoomTarget coordinates
        Point2D posInZoomTarget = target.parentToLocal(zoomNode.parentToLocal(mousePoint));

        // calculate adjustment of scroll position (pixels)
        Point2D adjustment = target.getLocalToParentTransform().deltaTransform(posInZoomTarget.multiply(zoomFactor - 1));

        // convert back to [0, 1] range
        // (too large/small values are automatically corrected by ScrollPane)
        Bounds updatedInnerBounds = zoomNode.getBoundsInLocal();
        this.setHvalue((this.getHvalue() * (updatedInnerBounds.getWidth() - this.getViewportBounds().getWidth()) + adjustment.getX()) / (updatedInnerBounds.getWidth() - this.getViewportBounds().getWidth()));
        this.setVvalue((this.getVvalue() * (updatedInnerBounds.getHeight() - this.getViewportBounds().getHeight()) + adjustment.getY()) / (updatedInnerBounds.getWidth() - this.getViewportBounds().getWidth()));
    }
}

