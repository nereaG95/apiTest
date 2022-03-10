package com.test.api.controller;

import com.test.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

    private String basicURL = "https://api.unsplash.com/collections";

    @Autowired
    public ApiService service;


    @GetMapping(value ="/collection/all/op2", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String allCollections(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "description", required = false) String desc, @RequestParam(value = "title", required = false) String title, @RequestParam(value="", required=false) String descPhoto){
        String response =service.peticionListaAPI(basicURL, id,desc,title,descPhoto);
        return  response ;
    }

    @Primary
    @GetMapping(value ="/collection/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String allCollections(@RequestParam(value = "filter", required = false) String filter ){
        String response =service.peticionListaAPIfilter(basicURL, filter);
        return  response ;
    }
}
