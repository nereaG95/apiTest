package com.test.api.Configuration;

import com.test.api.Model.Authorize;
import com.test.api.controller.AuthController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Getter
@Setter
@Configuration
@ConfigurationProperties("token.properties")
public class TokenConfiguration {

    String token;

    @Autowired
    AuthController authController;

    @Bean
    public void myBeanAuthentication() throws IOException {
        this.token = authController.connect();
    }

}
