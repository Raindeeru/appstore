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
import javafx.scene.shape.Rectangle;

public class AppMenu {

    VBox vbox = new VBox();
    App app;

    public AppMenu(App app){
        this.app = app;
    }  

    public Parent getGame(){ 
        //This is the layout of the games in storemenu :o
        VBox gameContain = new VBox(); 

        ImageView imageView = new ImageView(getClass().getResource(app.app_image_path).toExternalForm());
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        Rectangle clip = new Rectangle(imageView.getFitHeight(), imageView.getFitWidth());
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        imageView.setClip(clip);
        //mali pa po image pls helpppppp
        Label titleLabel = new Label(app.getTitle()); 
        Label pubLabel = new Label("By: " + app.getPublisher()); 
        Label genreLabel = new Label(app.getGenre()); 
        Label rateLabel = new Label("Rating: " + app.getStar_rating());

        //Label style 
        gameContain.setSpacing(2);
        //gameContain.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        pubLabel.setStyle("-fx-font-size: 16;");
        genreLabel.setStyle("-fx-font-size: 14;");
        rateLabel.setStyle("-fx-font-size: 12; -fx-text-fill: red;");

        gameContain.getChildren().addAll(imageView, titleLabel, pubLabel, genreLabel,rateLabel); 

        //just made this para mastart ko na layout ng vbox u can remove once nagawa na main button hehehhe
        Button hello = new Button(); 
        hello.setOnAction(event -> {
            AppMenu mainApp = new AppMenu(app); 
            Main.switchToAppMenu(app);
        }
        );
        
        VBox hi = new VBox();
        hi.getChildren().addAll(gameContain, hello);
        hi.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        return hi; 
    }

    public Parent getApp(){ 
        //This is the layout for the main app hehehe ;>
        VBox appContain = new VBox(); 
        
        ImageView ImageView = new ImageView(getClass().getResource(app.app_image_path).toExternalForm()); 
        ImageView.setFitHeight(100);
        ImageView.setFitWidth(100);
        Rectangle clip = new Rectangle(ImageView.getFitHeight(), ImageView.getFitWidth());
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        ImageView.setClip(clip);
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