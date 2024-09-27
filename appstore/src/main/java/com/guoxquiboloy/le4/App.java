package com.guoxquiboloy.le4;

public class App {
    String title;
    String publisher;
    String genre;
    String description;
    float star_rating;
    int downloads;
    String app_image_path;
    
    public App(String title, String publisher, String genre, String description, float star_rating, int downloads,String app_image_path) {
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.description = description;
        this.star_rating = star_rating;
        this.downloads = downloads;
        this.app_image_path = app_image_path;
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

    public int getDownloads() {
        return downloads;
    }
    
}
