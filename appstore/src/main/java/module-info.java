module com.guoxquiboloy.le4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    

    opens com.guoxquiboloy.le4 to javafx.fxml;
    exports com.guoxquiboloy.le4;
}
