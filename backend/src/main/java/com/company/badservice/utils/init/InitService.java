package com.company.badservice.utils.init;

import com.company.badservice.dto.GiraffeRequest;
import com.company.badservice.dto.TigerRequest;
import com.company.badservice.service.GiraffeService;
import com.company.badservice.service.TigerService;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

@Component
public class InitService {

    @Autowired
    private TigerService tigerService;

    @Autowired
    private GiraffeService giraffeService;


    /**
     * Load initial default entities into the DB on startup.
     */
    @PostConstruct
    public void init() throws IOException, URISyntaxException {

        ObjectMapper objectMapper = new ObjectMapper();

        TigerRequest tigerRequest = objectMapper.readValue(new InputStreamReader(InitService.class.getClassLoader().getResourceAsStream("tiger.json")), TigerRequest.class);
        tigerService.createTiger(tigerRequest);


        GiraffeRequest giraffeRequest = objectMapper.readValue(new File(InitService.class.getClassLoader().getResource("giraffe.json").toURI()), GiraffeRequest.class);
        giraffeService.createGiraffe(giraffeRequest);
    }

}
