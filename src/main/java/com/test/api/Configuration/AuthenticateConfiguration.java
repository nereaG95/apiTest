package com.test.api.Configuration;

import com.test.api.Model.Authentication;
import com.test.api.Model.Authorize;
import com.test.api.controller.AuthController;
import com.test.api.service.AuthService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Getter
@Setter
@Configuration
@ConfigurationProperties("authentication.properties")
public class AuthenticateConfiguration {

    @Value("${access.username}") String userName;
    @Value("${access.pass}") String pass;
    @Value("${access.clientid}") String clientId;
    @Value("${access.cookie}") String cookie;
    @Value("${access.redirect_uri}") String redirect_uri;
    @Value("${access.response_type}") String response_type;
    @Value("${access.scope}") String scope;
    @Value("${access.clientsecret}") String clientSecret;
    @Value("${access.grantype}") String grantType;


    @Bean
    public Authorize myBean() {
        return new Authorize(clientId , redirect_uri,response_type, scope );
    }



}
