package com.guoxquiboloy.le4;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.geometry.Orientation;

public class StoreMenu {
    
    Button button = new Button();
    int currentApp = 0;
    
        

    ScrollPane scrollScreen = new ScrollPane();
    VBox parentContainer = new VBox();  
    
    
    HBox titleBox = new HBox();
    Label titleLabel = new Label("AppStore");
    
    double imageWidth = 200;
    double imageHeight = 200;
    ImageView imageView1, imageView2;
    //genre1 element code
    
    //PICTURE BUTTON
    
    public static ArrayList<App> sliderApps;

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

        //mali pa po image pls helpppppp (DONE!)
        Label titleLabel = new Label(app.getTitle()); 
        Label rateLabel = new Label(app.getStar_rating() + " ★");

        //Label style 
        gameContain.setSpacing(2);
        //gameContain.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        
        gameContain.setPadding(new Insets(0, 5, 0 ,5));
        titleLabel.setStyle("-fx-text-fill: #F2F0EF; -fx-font-weight: bold; -fx-font-size: 20;");
        rateLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #eb7255;");


        
        //scrollbar
        scrollScreen.setStyle("-fx-background-color: #191a1c; -fx-background: transparent");
        
        gameContain.getChildren().addAll(imageView, titleLabel, rateLabel); 

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

        Rectangle roundImage = new Rectangle(
            imageView.getFitWidth(), imageView.getFitHeight()
        );
        roundImage.setArcHeight(30);
        roundImage.setArcWidth(30);
        imageView.setClip(roundImage);

        hi.getChildren().addAll(gameContain);
        
        
        return hi; 
    }

    public void addGenreRows(VBox parent) throws IOException{
        
        for(ArrayList<App> genreApps: getGenreApps()){
            Font appFont = new Font("Trebuchet MS",30);

            VBox genreCategory = new VBox();
            Label genreLabel = new Label(genreApps.get(0).genre);
            ScrollPane appScroll = new ScrollPane();
            genreLabel.setMaxWidth(800);
            genreLabel.setFont(appFont);
            genreLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-weight:bold; -fx-font-family: Trebuchet MS");
            genreLabel.setPadding(new Insets(0,0,10,0));
            HBox row = new HBox();
            appScroll.setContent(row);
            addAppsToRow(row, genreApps);
            appScroll.setMaxWidth(800);
            appScroll.setVbarPolicy(ScrollBarPolicy.NEVER);
            appScroll.setPrefHeight(300);
            appScroll.setFitToHeight(true);
            genreCategory.setAlignment(Pos.CENTER);
            
            
            row.setSpacing(10);
            genreCategory.setPadding(new Insets(0, 20, 0, 20));
            genreCategory.setPrefWidth(1200);
            parent.getChildren().add(genreCategory);
            appScroll.setStyle("-fx-background-color: transparent;");

            styleScrollBars(appScroll);

            genreCategory.getChildren().add(genreLabel);
            genreCategory.getChildren().add(appScroll);
            
            
        }
    }

    public static void styleScrollBars(ScrollPane scrollPane) {
        // Add a listener to the skin property to ensure the skin is set before accessing the scrollbars
        scrollPane.skinProperty().addListener((obs, oldSkin, newSkin) -> {
            // Delay the execution to ensure the scrollbars and thumbs are fully initialized
            Platform.runLater(() -> {
                // Find all ScrollBars in the ScrollPane after the skin is applied
                for (javafx.scene.Node node : scrollPane.lookupAll(".scroll-bar")) {
                    if (node instanceof ScrollBar) {
                        ScrollBar scrollBar = (ScrollBar) node;

                        // Customize the vertical scrollbar
                        if (scrollBar.getOrientation() == Orientation.HORIZONTAL) {
                            scrollBar.setStyle("-fx-background-color: #191a1c;"); // Scrollbar background color
                        }

                        // Customize the thumb (draggable part)
                        javafx.scene.Node thumb = scrollBar.lookup(".thumb");
                        thumb.setStyle("-fx-background-color: #eb7255;");
                        
                    }
                }
            });
        });
    }
    
    public StackPane appSlider() throws IOException{
        StackPane appSlide = new StackPane();
        sliderApps = AppJsonParser.getApps();

        Button forward = new Button(">");
        Button back = new Button("<");
        ImageView frontImageView = new ImageView(new Image(getClass().getResource(sliderApps.get(0).getApp_image_path()).toExternalForm()));
        
        frontImageView.setFitHeight(300);
        frontImageView.setFitWidth(800);

        HBox appPreview = new HBox();
        ImageView appPreviewImageView = new ImageView(new Image(getClass().getResource(sliderApps.get(0).getApp_image_path()).toExternalForm()));
        appPreviewImageView.setFitHeight(250);
        appPreviewImageView.setFitWidth(250);

        VBox titlePublisherRating = new VBox();
        Label title = new Label(sliderApps.get(0).getTitle());
        Label publisher = new Label(sliderApps.get(0).getPublisher());
        Label rating = new Label(Float.toString(sliderApps.get(0).getStar_rating()));

        title.setMaxWidth(250);
        title.setWrapText(true);
        publisher.setMaxWidth(250);
        publisher.setWrapText(true);

        title.setStyle("-fx-font-size: 30");;

        titlePublisherRating.getChildren().addAll(title, publisher, rating);
        appPreview.setAlignment(Pos.CENTER);
        appPreview.setSpacing(20);
        titlePublisherRating.setAlignment(Pos.CENTER_LEFT);

        appPreview.getChildren().addAll(appPreviewImageView, titlePublisherRating);

        appPreview.setCursor(Cursor.HAND);
        appPreview.setOnMouseClicked(event -> {
            {
                try{Main.switchToAppMenu(sliderApps.get(currentApp));}
                catch(IOException e){throw new RuntimeException(e);}
            }
        }
        );
        
        GaussianBlur blur = new GaussianBlur(20);
        frontImageView.setEffect(blur);

        frontImageView.setOpacity(0.5);

        forward.setTranslateX(350);
        back.setTranslateX(-350);

        if (currentApp == 0) {
            back.setDisable(true);
        }else if(currentApp == sliderApps.size()-1){
            forward.setDisable(true);
        }
        else{
            forward.setDisable(false);
            back.setDisable(false);
        }
    
        System.out.println(currentApp);
        forward.setOnAction(event ->{
            moveImageForward(frontImageView);
            System.out.println(currentApp);
            if (currentApp == 0) {
                back.setDisable(true);
            }else if(currentApp == sliderApps.size()-1){
                forward.setDisable(true);
            }
            else{
                forward.setDisable(false);
                back.setDisable(false);
            }
            appPreviewImageView.setImage(frontImageView.getImage());
            title.setText(sliderApps.get(currentApp).getTitle());
            publisher.setText(sliderApps.get(currentApp).getPublisher());
            rating.setText(Float.toString(sliderApps.get(currentApp).getStar_rating()));
        });
        back.setOnAction(event ->{         
            moveImageBackward(frontImageView);
            System.out.println(currentApp);
            if (currentApp == 0) {
                back.setDisable(true);
            }else if(currentApp == sliderApps.size()-1){
                forward.setDisable(true);
            }
            else{
                forward.setDisable(false);
                back.setDisable(false);
            }
            appPreviewImageView.setImage(frontImageView.getImage());
            title.setText(sliderApps.get(currentApp).getTitle());
            publisher.setText(sliderApps.get(currentApp).getPublisher());
            rating.setText(Float.toString(sliderApps.get(currentApp).getStar_rating()));


        });
        


        appSlide.getChildren().addAll(frontImageView, appPreview, forward, back);
        return appSlide;
    }

    void moveImageForward(ImageView image){
        currentApp ++;
        image.setImage(new Image(getClass().getResource(sliderApps.get(currentApp).getApp_image_path()).toExternalForm()));
    }
    void moveImageBackward(ImageView image){
        currentApp --;
        image.setImage(new Image(getClass().getResource(sliderApps.get(currentApp).getApp_image_path()).toExternalForm()));
    }

    public Parent getParent() throws IOException{
        
        HBox titleBar = new HBox();
        Label title = new Label("FatBoy Repacks");
        VBox content = new VBox();
        title.setFont(new Font("Trebuchet MS",40));
        title.setStyle("-fx-text-fill: #FFFFFF; -fx-font-weight:bold");
        titleBar.getChildren().add(title);
        parentContainer.getChildren().add(titleBar);
        
        titleBar.setStyle("-fx-border-style: hidden hidden solid hidden; -fx-border-width: 2; -fx-border-color: #eb7255;");
        titleBar.setPadding(new Insets(5, 5, 5, 5));
        addGenreRows(content);
        StackPane slider = appSlider();
        VBox contentAndSlider = new VBox();
        contentAndSlider.getChildren().addAll(slider, content);
        scrollScreen.setContent(contentAndSlider);
        scrollScreen.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollScreen.setFitToWidth(true);
        content.setStyle("-fx-background-color: transparent");
        parentContainer.setStyle("-fx-background-color: #191a1c");

        parentContainer.getChildren().addAll(scrollScreen);
        
        return (Parent)parentContainer;
    }
    

    
}
