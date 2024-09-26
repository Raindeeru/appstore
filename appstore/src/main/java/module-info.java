module com.guoxquiboloy.le4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.guoxquiboloy.le4 to javafx.fxml;
    exports com.guoxquiboloy.le4;
}
