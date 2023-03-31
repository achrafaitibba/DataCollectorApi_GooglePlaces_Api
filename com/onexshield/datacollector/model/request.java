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


    public request(@JsonProperty("domain") String domain,
                   @JsonProperty("city") String city,
                   @JsonProperty("country") String country) {
        this.domain = domain;
        this.city = city;
        this.country = country;
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

}
