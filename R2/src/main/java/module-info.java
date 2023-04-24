module com.indua.blueva {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.compiler;
    requires com.squareup.javapoet;
    requires json.simple;
    requires com.google.gson;

    opens com.indua.blueva to javafx.fxml;
    exports com.indua.blueva;
}