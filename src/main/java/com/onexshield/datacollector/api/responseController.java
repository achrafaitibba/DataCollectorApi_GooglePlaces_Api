package com.onexshield.datacollector.api;

import com.onexshield.datacollector.model.request;
import com.onexshield.datacollector.model.response;
import com.onexshield.datacollector.service.responseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("api/v1/response")
@RestController
public class responseController {

    private final responseService responseService;

    @Autowired
    public responseController(responseService responseService){

        this.responseService = responseService;
    }
    /*
    * to enable crossOrigin only for this methode use :
    * @CrossOrigine(origins="*")
    * */
    @GetMapping("/")
    public ArrayList<response> getData(@Valid @NotNull @RequestBody request request)throws Exception{
        return responseService.getData(request);
    }
    @GetMapping()
    public ArrayList<response> getData( @RequestParam(value = "domain", required = true) String domain,
                                        @RequestParam(value = "city", required = true) String city,
                                        @RequestParam(value = "country", required = true) String country,
                                        @RequestParam(value = "radius" ,required = true) int radius)throws Exception{
        return responseService.getData(new request(domain,city,country,radius));
    }
    @GetMapping("/test")
    public String[] test(){
        String[] testMessage= {"{This is a testing endpoint , now you are in the correct path to test/consume the API hh",
        "You can send a GET request to the following endpoint :",
        "/api/v1/response/",
        "the JSON body should be like this :",
        "{domain:something_hh,city:city_hh,country:country_hh,radius:radius_hh}",
        "or you can use the following endpoint to pass values within the link as follow :",
        "/api/v1/response?domain=domain&city=city&country=country&radius=radius",
        "domain & city & country : are String values, the radius must be an INTEGER}"};
        return testMessage;
    }

}
