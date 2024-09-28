package com.guoxquiboloy.le4;

import java.io.*;
import java.lang.reflect.Type;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class AppJsonParser {
    
    
    public static String appPath = "appStore.json";
    public static Gson gson = new Gson();

    public static ArrayList<App> getApps() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(
            new FileReader(appPath)
        );
        Type listType = new TypeToken<ArrayList<App>>(){}.getType();
        ArrayList<App> apps = gson.fromJson(bufferedReader, listType);
        return apps;
    }

    public static ArrayList<String> getGenres() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
            new FileReader(appPath)
        );
        Type listType = new TypeToken<ArrayList<App>>(){}.getType();
        ArrayList<App> apps = gson.fromJson(bufferedReader, listType);
        ArrayList<String> genres = new ArrayList<String>();
        for(App app: apps){
            if(genres.contains(app.getGenre())){
                continue;
            }
            genres.add(app.getGenre());
        }
        return genres;
    }
}