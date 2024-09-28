package com.guoxquiboloy.le4;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StoreMenu {
    
    Button button = new Button();
        private ArrayList<String> genreArrayList = new ArrayList<>();
        

        ScrollPane scrollScreen = new ScrollPane();
        VBox parentContainer = new VBox();  
        
        
        HBox titleBox = new HBox();
        Label titleLabel = new Label("AppStore");
        
        double imageWidth = 200;
        double imageHeight = 200;

        Image newImage, freakyAppImage;
        ImageView imageView1, imageView2;
        //genre1 element code
        
        //PICTURE BUTTON
        
        

        
    



    public StoreMenu(){
        
        scrollScreen.setVbarPolicy(ScrollBarPolicy.ALWAYS);
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
            
            genreContainer.getChildren().addAll(genreLabel);
            parentContainer.getChildren().addAll(genreContainer,genreAppBox);
            
        }
        
        scrollScreen.setContent(parentContainer);
        
        //appCheckButton.setGraphic(newImageView);
        //genre1AppBox.getChildren().addAll(appCheckButton);
        
        
        
    }

    public ScrollPane getScrollPane(){
        return scrollScreen;
    }

    public Parent getParent(){

        return (Parent)parentContainer;
    }
    
    
}
