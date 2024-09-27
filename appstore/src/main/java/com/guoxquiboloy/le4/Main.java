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

        //hardcode bla bla kill me now hehhehe 
        HBox setGame = new HBox(); 

        App[] games = new App[] {
            new App("CraftMine", "Jangmo", "Fantasy", "Explore the world of CraftMine", 4, 100, "Mapua.png"),
            new App("Stardew Valley", "Concered Ape", "Fantasy", "Explore the world of Stradew Valley", 5,1000000, "Mapua.png")
        }; 

        for (App game : games) {
            AppMenu appSetOne = new AppMenu(game);
            Parent gamerz = appSetOne.getGame();
            setGame.getChildren().add(gamerz);
        }

        VBox gameLayout = (VBox) storeMenu.getParent();
        gameLayout.getChildren().add(2, setGame);

        scene = new Scene(storeMenu.getParent(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    //Needed Code, pang switch ng scene
    public static void switchToAppMenu(App app) {
        AppMenu appMenu = new AppMenu(app);
        scene.setRoot(appMenu.getApp());
    }

    public static void main(String[] args) {
        launch();
    }

}