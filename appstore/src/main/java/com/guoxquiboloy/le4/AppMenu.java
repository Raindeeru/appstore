package com.guoxquiboloy.le4;

import java.io.IOException;

import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;


public class AppMenu {

    VBox vbox = new VBox();
    App app;

    public AppMenu(App app){
        this.app = app;
    }

    public Parent getApp() throws IOException{
        VBox appContain = new VBox();

        appContain.setStyle("-fx-background-color: #191a1c;");

        Button backButton = new Button("< Back");
        backButton.setOnAction(event -> {
            try {
                Main.switchToStoreMenu();
            } catch (IOException e) {
                System.out.println(e);
            }
        });

        backButton.setTranslateY(-225); 

        ImageView imageView = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView.setTranslateX(25); 
        imageView.setTranslateY(-103);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        Rectangle clip = new Rectangle(imageView.getFitHeight(), imageView.getFitWidth());
        clip.setArcHeight(30);
        clip.setArcWidth(30);
        imageView.setClip(clip);

        Image semiTransparentImage = new Image(getClass().getResource(app.getApp_image_path()).toExternalForm());
        ImageView semiTransparentImageView = new ImageView(semiTransparentImage);
        semiTransparentImageView.setOpacity(0.5); 
        
        ColorAdjust adj = new ColorAdjust(0, -0.9, -0.5, 0);
        GaussianBlur blur = new GaussianBlur(20); // 55 is just to show edge effect more clearly.
        adj.setInput(blur);
        semiTransparentImageView.setEffect(blur);


        semiTransparentImageView.setFitWidth(800);
        semiTransparentImageView.setPreserveRatio(false); 
        semiTransparentImageView.maxWidth(Double.MAX_VALUE); 


        appContain.getChildren().add(0, semiTransparentImageView); 

       
        Label titleL = new Label(app.getTitle());
        Label pubL = new Label("By: " + app.getPublisher());
        Label rateL = new Label("Rating: " + app.getStar_rating());
        Label genreL = new Label(app.getGenre());
        Label descriL = new Label("Description" + "\n" + app.getDescription());
        Label downL = new Label("Downloads: " + app.getDownloads());

      
        appContain.setSpacing(2);
        titleL.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: white;");
        titleL.setTranslateX(265);
        titleL.setTranslateY(-320);

        pubL.setStyle("-fx-font-size: 30; -fx-text-fill: white;");
        pubL.setTranslateX(265);
        pubL.setTranslateY(-319);

        genreL.setStyle("-fx-font-size: 30; -fx-text-fill: white;");
        genreL.setTranslateX(265);
        genreL.setTranslateY(-318);

        rateL.setStyle("-fx-font-size: 20; -fx-text-fill: red;");
        rateL.setTranslateX(25);
        rateL.setTranslateY(-250);

        descriL.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        descriL.setTranslateX(25);
        descriL.setTranslateY(-245);

        downL.setStyle("-fx-font-size: 11; -fx-text-fill: white;");
        downL.setTranslateX(25);
        downL.setTranslateY(-240);

        descriL.setWrapText(true);

       
        appContain.getChildren().addAll(backButton, imageView, titleL, pubL, genreL, rateL, descriL, downL);

        return appContain;
    }
}