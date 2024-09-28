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

    public void addAppsToRow(HBox row, ArrayList<App> apps){
        for(App app: apps){
            Parent gamerz = getGame(app);
            row.getChildren().add(gamerz);
        }
    }

    public Parent getGame(App app){ 
        //This is the layout of the games in storemenu :o
        VBox gameContain = new VBox(); 

        ImageView imageView = new ImageView(getClass().getResource("Mapua.png").toExternalForm()); 
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
        Button hello = new Button(); 
        hello.setOnAction(event -> {
            Main.switchToAppMenu(app);
        }
        );
        
        VBox hi = new VBox();
        hi.getChildren().addAll(gameContain, hello);
        hi.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        return hi; 
    }

    public void addGenreRows(VBox parent) throws IOException{
        for(ArrayList<App> genreApps: getGenreApps()){
            HBox row = new HBox();
            addAppsToRow(row, genreApps);
            parent.getChildren().add(row);
        }
    }
    
    public Parent getParent() throws IOException{
        addGenreRows(parentContainer);
        return (Parent)parentContainer;
    }
    
    
}
