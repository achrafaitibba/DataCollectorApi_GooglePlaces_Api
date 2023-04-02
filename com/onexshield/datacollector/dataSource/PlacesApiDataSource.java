package com.onexshield.datacollector.dataSource;

import com.google.maps.GeoApiContext;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PlacesApiDataSource {


    private String getApiKey() throws Exception{
        Properties properties=new Properties();
        try (InputStream is = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(is);
        }
        return properties.getProperty("apiKey");
    }
    public GeoApiContext getApiAccess()throws Exception{
        // Set up the GeoApiContext with your API key
        return new GeoApiContext.Builder()
                .apiKey("AIzaSyC-Ka758DTqHlJsHkc_H9DkQUZOoaxWwUI")
                .build();
    }






}
