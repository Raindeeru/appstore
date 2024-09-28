package com.guoxquiboloy.le4;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        HBox imageAndTitle = new HBox();
        VBox titles = new VBox();
        appContain.setMaxWidth(1920);

        appContain.setStyle("-fx-background-color: #191a1c;");

        Button backButton = new Button("< Back");
        backButton.setOnAction(event -> {
            try {
                Main.switchToStoreMenu();
                System.out.println("hahaha");
            } catch (IOException e) {
                System.out.println(e);
            }
        });


        StackPane stackedImages = new StackPane();                

        Image semiTransparentImage = new Image(getClass().getResource(app.getApp_image_path()).toExternalForm());
        ImageView semiTransparentImageView = new ImageView(semiTransparentImage);
        
        ColorAdjust adj = new ColorAdjust(0, -0.9, -0.5, 0);
        GaussianBlur blur = new GaussianBlur(20); // 55 is just to show edge effect more clearly.
        adj.setInput(blur);
        semiTransparentImageView.setEffect(blur);
        semiTransparentImageView.setOpacity(0.5);


        semiTransparentImageView.setFitWidth(800);
        semiTransparentImageView.setPreserveRatio(false); 
        semiTransparentImageView.maxWidth(Double.MAX_VALUE); 
        appContain.widthProperty().addListener((ChangeListener<? super Number>) new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                semiTransparentImageView.setFitWidth(appContain.getWidth());
            }
        });


       
        Label titleL = new Label(app.getTitle());
        Label pubL = new Label("By: " + app.getPublisher());
        Label rateL = new Label("Rating: " + app.getStar_rating());
        Label genreL = new Label(app.getGenre());
        Label descriL = new Label("Description" + "\n" + app.getDescription());
        Label downL = new Label("Downloads: " + app.getDownloads());

      
        appContain.setSpacing(2);
        titleL.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: white;");

        pubL.setStyle("-fx-font-size: 30; -fx-text-fill: white;");

        genreL.setStyle("-fx-font-size: 30; -fx-text-fill: white;");

        rateL.setStyle("-fx-font-size: 20; -fx-text-fill: red;");

        descriL.setStyle("-fx-font-size: 16; -fx-text-fill: white;");

        downL.setStyle("-fx-font-size: 11; -fx-text-fill: white;");

        descriL.setWrapText(true);
        titleL.setWrapText(true);

        ImageView imageView = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageAndTitle.getChildren().addAll(imageView, titles);
        titles.getChildren().addAll(titleL, pubL);
        stackedImages.getChildren().addAll( semiTransparentImageView, imageAndTitle, backButton);
        stackedImages.setAlignment(Pos.BOTTOM_LEFT);
        titles.setAlignment(Pos.BOTTOM_LEFT);
        appContain.getChildren().addAll( stackedImages, genreL, rateL, descriL, downL);

        return appContain;
    }
}