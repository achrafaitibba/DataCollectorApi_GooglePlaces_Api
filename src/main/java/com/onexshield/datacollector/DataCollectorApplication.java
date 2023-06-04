package com.onexshield.datacollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DataCollectorApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DataCollectorApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DataCollectorApplication.class);
    }

    //todo /UI react
    //todo /export to excel file "downloadable file"
    //todo /api key should be passed in "inputs"
    //todo /pagination
    //todo /change request body
    //todo /no dataSource

}
