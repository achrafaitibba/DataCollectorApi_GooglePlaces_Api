package com.onexshield.datacollector.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;


public class request {
    @NotBlank
    private final String domain;
    @NotBlank
    private final String city;
    @NotBlank
    private final String country;

    private final int ridus;


    public request(@JsonProperty("domain") String domain,
                   @JsonProperty("city") String city,
                   @JsonProperty("country") String country,
                   int ridus) {
        this.domain = domain;
        this.city = city;
        this.country = country;
        if(ridus>50){
            this.ridus = 50;
        }else {
            this.ridus = ridus;
        }

    }

    public request(String domain, String city, String country) {
        this.domain = domain;
        this.city = city;
        this.country = country;
        ridus = 10;
    }

    public String getDomain() {
        return domain;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
    public int getRidus(){return ridus; }

}
