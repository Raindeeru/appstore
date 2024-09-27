package com.guoxquiboloy.le4;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class AppJsonParser {
    
    public static String appPath = "appStore.json";

    public static ArrayList<App> getApps() throws IOException{
        ArrayList<Application> apps = new ArrayList<Application>();

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
