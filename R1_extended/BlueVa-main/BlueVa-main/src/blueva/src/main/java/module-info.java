module com.indua.blueva {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.indua.blueva to javafx.fxml;
    exports com.indua.blueva;
}
