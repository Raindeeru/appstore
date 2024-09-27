package com.guoxquiboloy.le4;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AppMenu {

    VBox vbox = new VBox();
    App app;

    public AppMenu(App app){
        this.app = app;
    }  

    public Parent getApp(){ 
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