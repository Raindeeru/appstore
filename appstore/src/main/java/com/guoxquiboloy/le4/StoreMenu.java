package com.guoxquiboloy.le4;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StoreMenu {
    
    Button button = new Button();
        private ArrayList<String> genreArrayList = new ArrayList<>();
        

        ScrollPane scrollScreen = new ScrollPane();
        VBox parentContainer = new VBox();  
        
        
        HBox titleBox = new HBox();
        HBox genre1Container = new HBox();
        HBox genre1AppBox = new HBox();
        HBox genre2Container = new HBox();
        HBox genre2AppBox = new HBox();
        HBox genre3Container = new HBox();
        HBox genre3AppBox = new HBox();
        
    
        //genre1 element code


        
        
        Button appCheckButton = new Button();
        
        
        ImageView newImageView = new ImageView(getClass().getResource("Mapua.png").toExternalForm());
        
        

        //genre2 element code
        
        
        

        //genre3 element code
        

        
    



    public StoreMenu(){
        genreArrayList.add("Fantasy");
        genreArrayList.add("Puzzle");
        genreArrayList.add("Horror");

        Label genreLabel = new Label(genreArrayList.get(0));

        Label genreLabel2 = new Label(genreArrayList.get(1));

        Label genreLabel3 = new Label(genreArrayList.get(1));
        
        parentContainer.getChildren().addAll(genre1Container,genre1AppBox,genre2Container,genre2AppBox,genre3Container,genre3AppBox);
        genre1Container.getChildren().addAll(genreLabel);
        appCheckButton.setGraphic(newImageView);
        genre1AppBox.getChildren().addAll(appCheckButton);
        
        genre2Container.getChildren().addAll(genreLabel2);
        genre2AppBox.getChildren().addAll();
        
        genre3Container.getChildren().addAll(genreLabel3);
        genre3AppBox.getChildren().addAll();
    }

    

    public Scene getScene(){

        return new Scene(parentContainer, 800, 800);
    }

}
