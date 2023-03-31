package com.onexshield.datacollector.service;

import com.onexshield.datacollector.abstraction.IResponse;
import com.onexshield.datacollector.client.responseRepository;
import com.onexshield.datacollector.model.request;
import com.onexshield.datacollector.model.response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class responseService implements IResponse {

    private final responseRepository responseRepository;
    @Autowired
    public responseService(@Qualifier("v1")responseRepository responseRepository){
        this.responseRepository = responseRepository;
    }


    @Override
    public ArrayList<response> getData(request request) throws Exception {
        return responseRepository.getData(request);
    }
}
