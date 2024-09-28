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
        
        gameContain.setCursor(Cursor.HAND);
        gameContain.setOnMouseClicked(event -> {
            {
                try{Main.switchToAppMenu(app);}
                catch(IOException e){throw new RuntimeException(e);}
            }
        }
        );
        gameContain.setMaxWidth(100);
        titleLabel.setWrapText(true);
        VBox hi = new VBox();
        hi.getChildren().addAll(gameContain);
        hi.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        return hi; 
    }

    public void addGenreRows(VBox parent) throws IOException{
        
        for(ArrayList<App> genreApps: getGenreApps()){
            VBox genreCategory = new VBox();
            Label genreLabel = new Label(genreApps.get(0).genre);
            ScrollPane appScroll = new ScrollPane();
            HBox row = new HBox();
            appScroll.setContent(row);
            appScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            addAppsToRow(row, genreApps);
            genreCategory.getChildren().add(genreLabel);
            genreCategory.getChildren().add(appScroll);
            parent.getChildren().add(genreCategory);
        }
    }
    
    public Parent getParent() throws IOException{
        Label Title = new Label("FatBoy Repacks");
        parentContainer.getChildren().add(Title);
        addGenreRows(parentContainer);
        scrollScreen.setContent(parentContainer);
        scrollScreen.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        return (Parent)scrollScreen;
    }
    

    
}
