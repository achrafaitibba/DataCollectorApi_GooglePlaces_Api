package com.onexshield.datacollector.model;


import com.google.maps.model.OpeningHours;
import com.google.maps.model.PriceLevel;

import java.net.URL;

public class response {

    private final String name;
    private final String city;
    private final String country;
    private final String address;
    private final String PhoneNumber;
    private final URL website;
    private final String internationalPhoneNumber;
    private final boolean permanentlyClosed;
    private final OpeningHours openingHours;
    private final PriceLevel priceLevel;
    private final String url;
    private final double rating;
    private final int userRatingsTotal;

    public response(String name, String city, String country,
                    String address, String phoneNumber,
                    URL website, String internationalPhoneNumber,
                    boolean permanentlyClosed, OpeningHours openingHours,
                    PriceLevel priceLevel, String url, double rating, int userRatingsTotal) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.address = address;
        this.PhoneNumber = phoneNumber;
        this.website = website;
        this.internationalPhoneNumber = internationalPhoneNumber;
        this.permanentlyClosed = permanentlyClosed;
        this.openingHours = openingHours;
        this.priceLevel = priceLevel;
        this.url = url;
        this.rating = rating;
        this.userRatingsTotal = userRatingsTotal;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public URL getWebsite() {
        return website;
    }

    public String getInternationalPhoneNumber() {
        return internationalPhoneNumber;
    }

    public boolean isPermanentlyClosed() {
        return permanentlyClosed;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public PriceLevel getPriceLevel() {
        return priceLevel;
    }

    public String getUrl() {
        return url;
    }

    public double getRating() {
        return rating;
    }

    public int getUserRatingsTotal() {
        return userRatingsTotal;
    }
}
