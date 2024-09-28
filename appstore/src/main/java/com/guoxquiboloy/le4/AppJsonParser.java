package com.guoxquiboloy.le4;

import java.io.*;
import java.lang.reflect.Array;
import java.util.List;
import com.fasterxml.jackson.databind;


import java.util.ArrayList;


public class AppJsonParser {
    
    
    public static String appPath = "appStore.json";

    public static ArrayList<App> getApps() throws IOException{
        ArrayList<App> apps = new ArrayList<App>();

        FileReader reader = new FileReader(new File(appPath));

        if (reader.read() != (int)'[') {
            reader.close();
            return apps;
        }

        int c;
        String appString = "";
        ArrayList<String> appStrings = new ArrayList<String>();
        boolean inObject = false;
        while ((c = reader.read()) != ']') {
            if ((char)c == ',') {
                appStrings.add(appString);
                appString = "";
            }
        }

        reader.close();
        return apps;
    }

}