package com.guoxquiboloy.le4;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AppMenu {
    
    VBox vbox = new VBox();
    App app;

    public AppMenu(App app){
        this.app = app;
    }  

    public Parent getApp(){ 
        //This is the layout for the main app hehehe ;>
        VBox appContain = new VBox(); 
        
        ImageView ImageView = new ImageView(getClass().getResource("Mapua.png").toExternalForm()); 
        //mali pa po image pls helpppppp
        Label titleL = new Label(app.getTitle()); 
        Label pubL = new Label("By: " + app.getPublisher()); 
        Label rateL = new Label("Rating: " + app.getStar_rating()); 
        Label genreL = new Label(app.getGenre()); 
        Label descriL = new Label("Description"+ "\n" + app.getDescription()); 
        Label downL = new Label("Downloads: " + app.getDownloads()); 

        //Label Styles
        appContain.setSpacing(2);
        titleL.setStyle("-fx-font-weight: bold; -fx-font-size: 40;");
        pubL.setStyle("-fx-font-size: 30;");
        genreL.setStyle("-fx-font-size: 30;");
        rateL.setStyle("-fx-font-size: 20; -fx-text-fill: red;");
        descriL.setStyle("-fx-font-size: 16;");

        appContain.getChildren().addAll(ImageView, titleL, pubL, genreL, rateL, descriL, downL); 
        
        return appContain; 
    }
}