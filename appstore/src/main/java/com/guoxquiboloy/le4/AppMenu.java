package com.guoxquiboloy.le4;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.scene.Cursor;


public class AppMenu {

    VBox vbox = new VBox();
    App app;

    public AppMenu(App app){
        this.app = app;
    }

    public Parent getApp() throws IOException{


        VBox appContain = new VBox();
        HBox imageAndTitle = new HBox();
        VBox titles = new VBox();
        appContain.setMaxWidth(1920);

        appContain.setStyle("-fx-background-color: #191a1c;");

        

       

        Button backButton = new Button();
        Image backButtonImage = new Image(getClass().getResourceAsStream("backbutton.png"));
        ImageView backButtonImageView = new ImageView(backButtonImage);
        backButtonImageView.setFitHeight(75);
        backButtonImageView.setFitWidth(100);
        backButtonImageView.setPreserveRatio(true);
        backButton.setGraphic(backButtonImageView);
        backButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        backButton.setCursor(Cursor.HAND);
        backButton.setOnAction(event -> {
            try {
                Main.switchToStoreMenu();
                System.out.println("hahaha");
            } catch (IOException e) {
                System.out.println(e);
            }
        });

        Button installButton = new Button("Install");
        installButton.setPadding(new Insets(5, 10, 5, 10));
        VBox.setMargin(installButton, new Insets(10, 0, 0, 0));
        installButton.setStyle("-fx-font-size: 30; -fx-font-weight: bold;-fx-text-fill: white; -fx-background-color: #eb7255; -fx-background-radius:10");
        installButton.setOnMouseEntered(event ->{
            installButton.setStyle("-fx-font-size: 30; -fx-font-weight: bold;-fx-text-fill: white; -fx-background-color: #b35740; -fx-background-radius:10");
        });
        installButton.setOnMouseExited(event -> {
            installButton.setStyle("-fx-font-size: 30; -fx-font-weight: bold;-fx-text-fill: white; -fx-background-color: #eb7255; -fx-background-radius:10");

        });

        installButton.setTranslateX(320);
        Label titleL = new Label(app.getTitle());
        Label pubL = new Label("By: " + app.getPublisher());
        Label rateL = new Label("Rating: " + app.getStar_rating() + "★");
        Label genreL = new Label(app.getGenre());
        Label descriL = new Label(app.getDescription());
        Label downL = new Label("Downloads: " + app.getDownloads());

        StackPane stackedImages = new StackPane();   

        ScrollPane bottomText = new ScrollPane();
        VBox bottomStuff = new VBox();
        bottomStuff.getChildren().addAll(rateL, descriL, downL);
        bottomText.setContent(bottomStuff);
        bottomStuff.setStyle("-fx-background-color: #191a1c");
        bottomText.setStyle("-fx-background: #191a1c; -fx-background-color: #191a1c");
        bottomText.setVbarPolicy(ScrollBarPolicy.NEVER);
        Image semiTransparentImage = new Image(getClass().getResource(app.getapp_background_image_path()).toExternalForm());
        ImageView semiTransparentImageView = new ImageView(semiTransparentImage);
        bottomText.setPrefHeight(9999);
        
        GaussianBlur blur = new GaussianBlur(20);
        semiTransparentImageView.setEffect(blur);
        semiTransparentImageView.setOpacity(0.5);


        semiTransparentImageView.setFitWidth(800);
        semiTransparentImageView.setFitHeight(350);
        semiTransparentImageView.maxHeight(350);
        semiTransparentImageView.setPreserveRatio(false); 
        semiTransparentImageView.maxWidth(Double.MAX_VALUE); 

        appContain.widthProperty().addListener((ChangeListener<? super Number>) new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                semiTransparentImageView.setFitWidth(appContain.getWidth());
                bottomStuff.setMaxWidth(appContain.getWidth() - 50);
            }
        });


       
        

      
        appContain.setSpacing(2);
        titleL.setStyle("-fx-font-family: 'Trebuchet MS'; -fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: white;");

        pubL.setStyle("-fx-font-family: 'Trebuchet MS';   -fx-font-size: 30; -fx-text-fill: white;");

        genreL.setStyle("-fx-font-size: 15; -fx-font-weight: bold;-fx-text-fill: white; -fx-background-color: #eb7255; -fx-background-radius:10");
        genreL.setTextAlignment(TextAlignment.CENTER);
        genreL.setPadding(new Insets(5, 10, 5, 10));
        VBox.setMargin(genreL, new Insets(10, 0, 0, 10));
        rateL.setStyle("-fx-font-size: 20; -fx-text-fill: #eb7255;");
        rateL.setPadding(new Insets(0, 0, 0, 10));
        descriL.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        descriL.setPadding(new Insets(0, 0, 0, 10));
        downL.setStyle("-fx-font-size: 11; -fx-text-fill: white;");
        downL.setPadding(new Insets(0, 0, 0, 10));

        descriL.setWrapText(true);
        titleL.setWrapText(true);

        ImageView imageView = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        imageView.setTranslateY(65);
        Rectangle clip = new Rectangle(imageView.getFitHeight(), imageView.getFitWidth());
        clip.setArcHeight(30);
        clip.setArcWidth(30);
        imageView.setClip(clip);
        HBox imageContainer = new HBox();
        imageContainer.setAlignment(Pos.CENTER_LEFT);
        HBox.setMargin(imageView, new Insets(0, 10, 0, 0));
        imageContainer.getChildren().add(imageView);
        imageContainer.setPadding(new Insets(5));
        imageAndTitle.getChildren().addAll(imageContainer);
        imageAndTitle.getChildren().addAll(imageView, titles);
        titles.getChildren().addAll(titleL, pubL);
        stackedImages.getChildren().addAll( semiTransparentImageView, imageAndTitle, backButton);
        stackedImages.setAlignment(Pos.BOTTOM_LEFT);
        imageAndTitle.setAlignment(Pos.BOTTOM_LEFT);
        titles.setAlignment(Pos.BOTTOM_LEFT);
        backButton.setTranslateY(-300);
        

        appContain.getChildren().addAll( stackedImages, installButton, genreL, bottomText);
        appContain.setMaxHeight(9999);
        return appContain;
    }
}