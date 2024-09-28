package com.guoxquiboloy.le4;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StoreMenu {
    
    Button button = new Button();
    
        

    ScrollPane scrollScreen = new ScrollPane();
    VBox parentContainer = new VBox();  
    
    
    HBox titleBox = new HBox();
    Label titleLabel = new Label("AppStore");
    
    double imageWidth = 200;
    double imageHeight = 200;
    ImageView imageView1, imageView2;
    //genre1 element code
    
    //PICTURE BUTTON
    
    

    public StoreMenu(){
        
        
    }

    public ArrayList<ArrayList<App>> getGenreApps() throws IOException{
        ArrayList<String> genres = AppJsonParser.getGenres();
        ArrayList<App> apps = AppJsonParser.getApps();


        ArrayList<ArrayList<App>> genreApps = new ArrayList<ArrayList<App>>(); 
        for(String genre: genres){
            ArrayList<App> appsInGenre = new ArrayList<App>();
            for(App app: apps){
                if (genre.equals(app.getGenre())) {
                    appsInGenre.add(app);
                }
            }
            genreApps.add(appsInGenre);
        }
        return genreApps;
    }

    public void addAppsToRow(HBox row, ArrayList<App> apps) throws IOException{
        for(App app: apps){
            Parent gamerz = getGame(app);
            row.getChildren().add(gamerz);
        }
    }

    public Parent getGame(App app) throws IOException{ 
        //This is the layout of the games in storemenu :o
        
        VBox gameContain = new VBox(); 

        ImageView imageView = new ImageView(getClass().getResource(app.getApp_image_path()).toExternalForm()); 
        imageView.setFitHeight(imageHeight);
        imageView.setFitWidth(imageWidth);

        //mali pa po image pls helpppppp
        Label titleLabel = new Label(app.getTitle()); 
        Label pubLabel = new Label("By: " + app.getPublisher()); 
        Label genreLabel = new Label(app.getGenre()); 
        Label rateLabel = new Label("Rating: " + app.getStar_rating());

        //Label style 
        gameContain.setSpacing(2);
        //gameContain.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        
        gameContain.setPadding(new Insets(0, 3, 0 ,3));
        titleLabel.setStyle("-fx-text-fill: #F2F0EF; -fx-font-weight: bold; -fx-font-size: 20;");
        pubLabel.setStyle("-fx-text-fill: #F2F0EF; -fx-font-size: 16;");
        genreLabel.setStyle("-fx-text-fill: #F2F0EF;-fx-font-size: 14;");
        rateLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #eb7255;");

        
        //scrollbar
        scrollScreen.setStyle("-fx-background-color: #191a1c; -fx-background: transparent");
        
        gameContain.getChildren().addAll(imageView, titleLabel, pubLabel, genreLabel,rateLabel); 

        //just made this para mastart ko na layout ng vbox u can remove once nagawa na main button hehehhe
        
        gameContain.setCursor(Cursor.HAND);
        gameContain.setOnMouseClicked(event -> {
            {
                try{Main.switchToAppMenu(app);}
                catch(IOException e){throw new RuntimeException(e);}
            }
        }
        );
        gameContain.setMaxWidth(200);
        VBox hi = new VBox();
        titleLabel.setWrapText(true);
        hi.getChildren().addAll(gameContain);
        
        
        return hi; 
    }

    public void addGenreRows(VBox parent) throws IOException{
        
        for(ArrayList<App> genreApps: getGenreApps()){
            Font appFont = new Font("Verdana",25);

            VBox genreCategory = new VBox();
            Label genreLabel = new Label(genreApps.get(0).genre);
            ScrollPane appScroll = new ScrollPane();
            genreLabel.setMaxWidth(800);
            genreLabel.setFont(appFont);
            genreLabel.setStyle("-fx-text-fill: #FFFFFF");
            HBox row = new HBox();
            appScroll.setContent(row);
            addAppsToRow(row, genreApps);
            appScroll.setMaxWidth(800);
            appScroll.setVbarPolicy(ScrollBarPolicy.NEVER);
            appScroll.setPrefHeight(350);
            appScroll.setFitToHeight(true);
            genreCategory.setAlignment(Pos.CENTER);
            genreCategory.getChildren().add(genreLabel);
            genreCategory.getChildren().add(appScroll);
            row.setSpacing(10);
            parent.getChildren().add(genreCategory);
           
            appScroll.setStyle("-fx-background-color: transparent;");
            
        }
    }
    
    public Parent getParent() throws IOException{
        
        Label title = new Label("FatBoy Repacks");
        
        parentContainer.getChildren().add(title);
        
        addGenreRows(parentContainer);
        scrollScreen.setContent(parentContainer);
        scrollScreen.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollScreen.setFitToWidth(true);
        parentContainer.setSpacing(30);
        parentContainer.setStyle("-fx-background-color: #191a1c");
        
        return (Parent)scrollScreen;
    }
    

    
}
