package com.guoxquiboloy.le4;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Parent;
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
        Label titleLabel = new Label("AppStore");
        
        
    
        //genre1 element code
        
        //PICTURE BUTTON
        
        

        
    



    public StoreMenu(){
        //genres
        genreArrayList.add("Fantasy");
        genreArrayList.add("Puzzle");
        genreArrayList.add("Horror");
        //title label
        parentContainer.getChildren().addAll(titleBox);
        titleBox.getChildren().addAll(titleLabel);

        //add hboxes for buttons and genre names
        for (String genre : genreArrayList){
            HBox genreContainer = new HBox();
            HBox genreAppBox = new HBox();
            Label genreLabel = new Label(genre);
            Button app1 = new Button("HI GAME");
            Button app2 = new Button("HI AGAIN");
            ImageView newImageView = new ImageView(getClass().getResource("Mapua.png").toExternalForm());
            app1.setGraphic(newImageView);
            genreAppBox.getChildren().addAll(app1,app2);
            genreContainer.getChildren().addAll(genreLabel);
            parentContainer.getChildren().addAll(genreContainer,genreAppBox);
        }
        
        
        //appCheckButton.setGraphic(newImageView);
        //genre1AppBox.getChildren().addAll(appCheckButton);
        
        
        
    }

    

    public Parent getParent(){

        return (Parent)parentContainer;
    }
    
    
}
