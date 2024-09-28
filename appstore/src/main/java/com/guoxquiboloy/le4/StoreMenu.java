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
        
        double imageWidth = 200;
        double imageHeight = 200;

        Image newImage, freakyAppImage;
        ImageView imageView1, imageView2;
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
            VBox app1 = new VBox();
            VBox app2 = new VBox();
            app1.setCursor(Cursor.HAND);
            app2.setCursor(Cursor.HAND);
            
            

            switch(genre){
                case "Fantasy":
                newImage = new Image("file:appstore\\src\\main\\resources\\com\\guoxquiboloy\\le4\\Mapua.png");
                freakyAppImage = new Image("file:appstore\\src\\main\\resources\\com\\guoxquiboloy\\le4\\Freaky.png");
                imageView1 = new ImageView(newImage);
                imageView2 = new ImageView(freakyAppImage);

                imageView1.setFitWidth(imageWidth);
                imageView1.setFitHeight(imageHeight);
                imageView2.setFitWidth(imageWidth);
                imageView2.setFitHeight(imageHeight);
            
            
                app1.getChildren().add(imageView1);
                app2.getChildren().add(imageView2);
                genreAppBox.getChildren().addAll(app1,app2);

                break;
                

            }
            
                
            
            
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
