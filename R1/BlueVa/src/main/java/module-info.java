module com.example.blueva {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.blueva to javafx.fxml;
    exports com.example.blueva;
}