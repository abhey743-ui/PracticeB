package com.Apigateway.CorelationFilters;


import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FilterUtility {

    public String createId(){
        return   java.util.UUID.randomUUID().toString();
    }

}
