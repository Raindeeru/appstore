package com.guoxquiboloy.le4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        StoreMenu storeMenu = new StoreMenu();
        Scene storePageScene = storeMenu.getScene();
        stage.setScene(storePageScene);
        stage.show();
    }

    //Needed Code, pang switch ng scene

    public static void main(String[] args) {
        launch();
    }

}