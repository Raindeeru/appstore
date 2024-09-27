module com.guoxquiboloy.le4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    opens com.guoxquiboloy.le4 to javafx.fxml;
    exports com.guoxquiboloy.le4;
}
