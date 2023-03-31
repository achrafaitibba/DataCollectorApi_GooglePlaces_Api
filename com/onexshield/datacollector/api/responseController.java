package com.onexshield.datacollector.api;

import com.onexshield.datacollector.model.request;
import com.onexshield.datacollector.model.response;
import com.onexshield.datacollector.service.responseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("api/v1/response")
@RestController
public class responseController {

    private final responseService responseService;

    @Autowired
    public responseController(responseService responseService){

        this.responseService = responseService;
    }

    @GetMapping
    public ArrayList<response> getData(@Valid @NotNull @RequestBody request request)throws Exception{
        return responseService.getData(request);
    }

}
