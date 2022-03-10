package com.test.api.controller;

import com.test.api.Model.Authentication;
import com.test.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private String basicURL = "https://unsplash.com";
    private String urlToken =basicURL +"/oauth/token";
    private String urlAuth =basicURL +"/oauth/authorize";


    @Autowired
    public AuthService service;


    @GetMapping("/connection")
    public @ResponseBody  String connect() throws IOException {
       String code =  service.firstConnect(urlAuth);
       Authentication au = service.secondConnect(urlToken,code);
       return au.access_token;
    }

}
