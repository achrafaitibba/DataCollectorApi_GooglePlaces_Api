package com.onexshield.datacollector.client;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import com.onexshield.datacollector.abstraction.IResponse;
import com.onexshield.datacollector.dataSource.PlacesApiDataSource;
import com.onexshield.datacollector.model.request;
import com.onexshield.datacollector.model.response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
@Repository("v1")
public class responseRepository implements IResponse {

    public final int maxResults = 100;
    private final PlacesApiDataSource placesApiDataSource;

    @Autowired
    public responseRepository(PlacesApiDataSource placesApiDataSource){
        this.placesApiDataSource = placesApiDataSource;
    }

    public static LatLng getLatLng(String address, GeoApiContext context) throws ApiException, IOException, InterruptedException {
        // Perform a geocode request for the specified address
        GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
        // Extract the latitude and longitude from the first result (assuming it's the most accurate)
        double lat = results[0].geometry.location.lat;
        double lng = results[0].geometry.location.lng;
        return new LatLng(lat, lng);
    }

    public PlacesSearchResponse extarctAllData(request request)throws Exception{
        GeoApiContext context = placesApiDataSource.getApiAccess();

        // Retrieve the latitude and longitude of the specified city and country using Geocoding API
        LatLng location = getLatLng(request.getCity() + ", " + request.getCountry(), context);
        // Perform a nearby search for places matching the specified domain within the specified radius and location
        return  PlacesApi.nearbySearchQuery(context, location)
                .radius(request.getRidus()*1000) // 10km default radius ;
                .keyword(request.getDomain())
                .await();
    }

    public ArrayList<response> getData(request request) throws Exception{
        PlacesSearchResponse response = extarctAllData(request);


        ArrayList<PlaceDetails> detailsList = new ArrayList<>();



        while (detailsList.size() < maxResults && response.results != null && response.results.length > 0) {
            for (PlacesSearchResult result : response.results) {
                // Get detailed information about this place
                PlaceDetails details = PlacesApi.placeDetails(placesApiDataSource.getApiAccess(), result.placeId).await();
                detailsList.add(details);
            }

            // If there are more results, fetch the next page using the nextPageToken
            if (response.nextPageToken != null && !response.nextPageToken.isEmpty()) {
                response = PlacesApi.nearbySearchNextPage(placesApiDataSource.getApiAccess(), response.nextPageToken).await();
            } else {
                break;
            }
        }

        // Extract the required data from the details and store them in an ArrayList of String arrays
        ArrayList<response> data = new ArrayList<>();
        for (PlaceDetails details : detailsList) {

            data.add(new response(
                    details.name = details.name == null ? "NoData_Hh" : details.name,
                    request.getCity(),
                    request.getCountry(),
                    details.formattedAddress = details.formattedAddress == null ? "NoData_Hh" : details.formattedAddress,
                    details.formattedPhoneNumber = details.formattedPhoneNumber == null ? "NoData_Hh" : details.formattedPhoneNumber,
                    details.website /*= details.website == null ? new URL(" https://www.example.com:8080/path?param1=value1") : details.website*/,
                    details.internationalPhoneNumber = details.internationalPhoneNumber == null ? "NoData_Hh" : details.internationalPhoneNumber,
                    details.permanentlyClosed = !details.permanentlyClosed ? false : details.permanentlyClosed,
                    details.openingHours,
                    details.priceLevel = details.priceLevel == null ? PriceLevel.UNKNOWN : details.priceLevel,
                    details.url.toString(),
                    details.rating = Float.isNaN(details.rating)? 0 : details.rating,
                    details.userRatingsTotal = Float.isNaN(details.userRatingsTotal) ? 0 : details.userRatingsTotal));

        }


        return data;
    }




}
