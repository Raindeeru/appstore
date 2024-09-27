package com.guoxquiboloy.le4;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class AppMenu {

    VBox vbox = new VBox();
    
    @FXML
    private void switchToPrimary() throws IOException {
        Main.setRoot("primary");
        
    }
}