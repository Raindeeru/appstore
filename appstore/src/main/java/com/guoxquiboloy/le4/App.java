package com.guoxquiboloy.le4;

public class App {
    String title;
    

    String publisher;
    String genre;
    String description;
    float star_rating;
    String downloads;
    String app_image_path = "Mapua.png";
    String app_background_image_path = "Mapua.png";
    String star_symbol;
    
    public String getApp_image_path() {
        return app_image_path;
    }

    public String getapp_background_image_path()
    {
        return app_background_image_path;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public float getStar_rating() {
        return star_rating;
    }

    public String getStar_symbol()
    {
        return star_symbol;
    }

    public String getDownloads() {
        return downloads;
    }
    public App(String title, String publisher, String genre, String description, float star_rating, String downloads,
            String app_image_path, String app_background_image_path, String star_symbol) {
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.description = description;
        this.star_rating = star_rating;
        this.downloads = downloads;
        this.app_image_path = app_image_path;
        this.app_background_image_path = app_background_image_path;
        this.star_symbol = star_symbol;
    }
    
}
