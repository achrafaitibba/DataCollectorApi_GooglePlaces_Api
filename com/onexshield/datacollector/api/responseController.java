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
   

}
