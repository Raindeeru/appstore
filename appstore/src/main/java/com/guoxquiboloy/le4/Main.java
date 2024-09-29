package com.guoxquiboloy.le4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
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

        scene = new Scene(storeMenu.getParent(), 950, 600);
        stage.setScene(scene);
        stage.show();
    }

    //Needed Code, pang switch ng scene
    public static void switchToAppMenu(App app) throws IOException {
        AppMenu appMenu = new AppMenu(app);
        scene.setRoot(appMenu.getApp());
    }

    public static void switchToStoreMenu() throws IOException {
        StoreMenu backStore = new StoreMenu();
        scene.setRoot(backStore.getParent());
    }

    public static void main(String[] args) throws IOException{
        launch();
    }

}