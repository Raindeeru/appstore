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

    //Scene to ng buong app, scene.setroot niyo nalang kung magswiswitch lang
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        StoreMenu storeMenu = new StoreMenu();
        scene = new Scene(storeMenu.getParent(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    //Needed Code, pang switch ng scene

    public static void main(String[] args) throws IOException{
        launch();
    }

}