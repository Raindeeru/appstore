package com.guoxquiboloy.le4;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StoreMenu {
    
    Button button = new Button();

    @FXML
    private void switchToSecondary() throws IOException {
        Main.setRoot("secondary");
    }
}
