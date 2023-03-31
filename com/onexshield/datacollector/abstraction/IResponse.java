package com.onexshield.datacollector.abstraction;

import com.onexshield.datacollector.model.request;
import com.onexshield.datacollector.model.response;

import java.util.ArrayList;

public interface IResponse {
    public ArrayList<response> getData(request request) throws Exception;
}
