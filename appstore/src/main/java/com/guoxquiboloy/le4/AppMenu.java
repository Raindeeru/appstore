package com.guoxquiboloy.le4;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class AppMenu {

    VBox vbox = new VBox();
    App app;

    public AppMenu(App app){
        this.app = app;
    }  

    public Parent getGame(){ 
        //This is the layout of the games in storemenu :o
        VBox gameContain = new VBox(); 

        //ImageView ImageView = new ImageView(app.app_image_path); //mali pa ito pls pahelp pls pls pls 
        Label titleLable = new Label(app.getTitle()); 
        Label pubLable = new Label("By: " + app.getPublisher()); 
        Label rateLable = new Label("Rating: " + app.getStar_rating());

        gameContain.getChildren().addAll(titleLable, pubLable, rateLable); 
        gameContain.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        //Button hello = new Button(); //just made this para mastart ko na layout ng vbox
        //hello.setOnAction(happy);
        
        return gameContain; 
    }

    public Parent getApp(){ 
        //This is the layout for the main app hehehe ;>
        VBox gameContain = new VBox(); 

        Label titleL = new Label(app.getTitle()); 
        Label pubL = new Label("By: " + app.getPublisher()); 
        Label rateL = new Label("Rating: " + app.getStar_rating()); 
        Label genreL = new Label(app.getGenre()); 
        Label descriL = new Label("Description"+ "\n" + app.getDescription()); 
        Label downL = new Label("Downloads: " + app.getDownloads()); 

        gameContain.getChildren().addAll(titleL,pubL, genreL, rateL, descriL, downL); 
        gameContain.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        
        return gameContain; 
    }
}