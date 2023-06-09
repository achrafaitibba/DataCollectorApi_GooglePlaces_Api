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

    private final int radius;


    public request(@JsonProperty("domain") String domain,
                   @JsonProperty("city") String city,
                   @JsonProperty("country") String country,
                   @JsonProperty("radius") int radius) {
        this.domain = domain;
        this.city = city;
        this.country = country;
        if(radius>50){
            this.radius = 50;
        }else if( radius <5 ){
            this.radius = 5;
        }else {
            this.radius = radius;
        }

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
    public int getRadius(){return radius; }

}
