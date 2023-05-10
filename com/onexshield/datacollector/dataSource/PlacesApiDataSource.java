package com.onexshield.datacollector.dataSource;

import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PlacesApiDataSource {




    public GeoApiContext getApiAccess()throws Exception{
        // Set up the GeoApiContext with your API key
        return new GeoApiContext.Builder()
                .apiKey("AIzaSyBClQoqpOm4VjA8UJP9VDm9XCQkgXu4Luw")
                .build();
    }


}
