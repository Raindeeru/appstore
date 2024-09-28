module com.guoxquiboloy.le4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;

    opens com.guoxquiboloy.le4 to javafx.fxml, com.google.gson;
    exports com.guoxquiboloy.le4;
}
