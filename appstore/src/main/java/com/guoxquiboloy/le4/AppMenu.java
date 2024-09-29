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
        Label rateL = new Label("Rating: " + app.getStar_rating() + app.getStar_symbol());
        Label genreL = new Label(app.getGenre());
        Label descriL = new Label(app.getDescription());
        Label downL = new Label("Downloads: " + app.getDownloads());

        VBox imagecontainer = new VBox();

        HBox row1 = new HBox();
        HBox imageBox1 = new HBox();
        ImageView imageView1 = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView1.setFitHeight(200);
        imageView1.setFitWidth(450);
        imageView1.setPreserveRatio(false);
        Rectangle clip1 = new Rectangle(imageView1.getFitWidth(), imageView1.getFitHeight());
        clip1.setArcWidth(20);
        clip1.setArcHeight(20);
        imageView1.setClip(clip1);
        imageBox1.getChildren().add(imageView1);
        imageBox1.setPadding(new Insets(5, 10, 5, 5));

        HBox imageBox2 = new HBox();
        ImageView imageView2 = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView2.setFitHeight(200);
        imageView2.setFitWidth(450);
        imageView2.setPreserveRatio(false);
        Rectangle clip2 = new Rectangle(imageView2.getFitWidth(), imageView2.getFitHeight());
        clip2.setArcWidth(20);
        clip2.setArcHeight(20);
        imageView2.setClip(clip2);
        imageBox2.getChildren().add(imageView2);
        imageBox2.setPadding(new Insets(5, 10, 5, 5));

        HBox imageBox12 = new HBox();
        ImageView imageView12 = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView12.setFitHeight(200);
        imageView12.setFitWidth(450);
        imageView12.setPreserveRatio(false);
        Rectangle clip12 = new Rectangle(imageView12.getFitWidth(), imageView12.getFitHeight());
        clip12.setArcWidth(20);
        clip12.setArcHeight(20);
        imageView12.setClip(clip12);
        imageBox12.getChildren().add(imageView12);
        imageBox12.setPadding(new Insets(5, 10, 5, 5));

        row1.getChildren().addAll(imageBox1, imageBox2, imageBox12);
        row1.setPadding(new Insets(5, 10, 5, 100));

        HBox row2 = new HBox();

        HBox imageBox3 = new HBox();
        ImageView imageView3 = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView3.setFitHeight(200);
        imageView3.setFitWidth(450);
        imageView3.setPreserveRatio(false);
        Rectangle clip3 = new Rectangle(imageView3.getFitWidth(), imageView3.getFitHeight());
        clip3.setArcWidth(20);
        clip3.setArcHeight(20);
        imageView3.setClip(clip3);
        imageBox3.getChildren().add(imageView3);
        imageBox3.setPadding(new Insets(5, 10, 5, 5));

        HBox imageBox4 = new HBox();
        ImageView imageView4 = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView4.setFitHeight(200);
        imageView4.setFitWidth(450);
        imageView4.setPreserveRatio(false);
        Rectangle clip4 = new Rectangle(imageView4.getFitWidth(), imageView4.getFitHeight());
        clip4.setArcWidth(20);
        clip4.setArcHeight(20);
        imageView4.setClip(clip4);
        imageBox4.getChildren().add(imageView4);
        imageBox4.setPadding(new Insets(5, 10, 5, 5));

        HBox imageBox34 = new HBox();
        ImageView imageView34 = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView34.setFitHeight(200);
        imageView34.setFitWidth(450);
        imageView34.setPreserveRatio(false);
        Rectangle clip34 = new Rectangle(imageView34.getFitWidth(), imageView34.getFitHeight());
        clip34.setArcWidth(20);
        clip34.setArcHeight(20);
        imageView34.setClip(clip34);
        imageBox34.getChildren().add(imageView34);
        imageBox34.setPadding(new Insets(5, 10, 5, 5));

        row2.getChildren().addAll(imageBox3, imageBox4, imageBox34);
        row2.setPadding(new Insets(5, 10, 5, 100));

        HBox row3 = new HBox();

        HBox imageBox5 = new HBox();
        ImageView imageView5 = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView5.setFitHeight(200);
        imageView5.setFitWidth(450);
        imageView5.setPreserveRatio(false);
        Rectangle clip5 = new Rectangle(imageView5.getFitWidth(), imageView5.getFitHeight());
        clip5.setArcWidth(20);
        clip5.setArcHeight(20);
        imageView5.setClip(clip5);
        imageBox5.getChildren().add(imageView5);
        imageBox5.setPadding(new Insets(5, 10, 5, 5));

        HBox imageBox6 = new HBox();
        ImageView imageView6 = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView6.setFitHeight(200);
        imageView6.setFitWidth(450);
        imageView6.setPreserveRatio(false);
        Rectangle clip6 = new Rectangle(imageView6.getFitWidth(), imageView6.getFitHeight());
        clip6.setArcWidth(20);
        clip6.setArcHeight(20);
        imageView6.setClip(clip6);
        imageBox6.getChildren().add(imageView6);
        imageBox6.setPadding(new Insets(5, 10, 5, 5));

        HBox imageBox56 = new HBox();
        ImageView imageView56 = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm());
        imageView56.setFitHeight(200);
        imageView56.setFitWidth(450);
        imageView56.setPreserveRatio(false);
        Rectangle clip56 = new Rectangle(imageView56.getFitWidth(), imageView56.getFitHeight());
        clip56.setArcWidth(20);
        clip56.setArcHeight(20);
        imageView56.setClip(clip56);
        imageBox56.getChildren().add(imageView56);
        imageBox56.setPadding(new Insets(5, 10, 5, 5));

        row3.getChildren().addAll(imageBox5, imageBox6, imageBox56);
        row3.setPadding(new Insets(5, 10, 5, 100));

        imagecontainer.getChildren().addAll(row1, row2, row3);

        StackPane stackedImages = new StackPane();   

        ScrollPane bottomText = new ScrollPane();
        VBox bottomStuff = new VBox();
        bottomStuff.getChildren().addAll(rateL, descriL, downL, imagecontainer);
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