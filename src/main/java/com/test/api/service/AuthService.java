package com.test.api.service;

import com.test.api.Configuration.AuthenticateConfiguration;
import com.test.api.Model.Authentication;
import com.test.api.Model.Authorize;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class AuthService implements IAuthService {

    @Autowired
    private AuthenticateConfiguration config;

    public String firstConnect(String urlFinal){

        String username = config.getUserName();
        String password = config.getPass();
        String credentials = username+":"+password;
        byte[] credentialBytes = credentials .getBytes();
        byte[] base64CredentialBytes = Base64.encodeBase64(credentialBytes);
        String base64Credentials = new String(base64CredentialBytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Basic " + base64Credentials );
        headers.add(HttpHeaders.COOKIE, config.getCookie());
        HttpEntity<String> request = new HttpEntity<String>(headers);

        Authorize prue = config.myBean();
        urlFinal = urlFinal +"?client_id="+ config.getClientId()+"&redirect_uri="+ config.getRedirect_uri() + "&response_type="+ config.getResponse_type()+"&scope="
        + config.getScope();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(urlFinal, HttpMethod.GET, request, String.class);
        String code = response.getBody().split("<code>")[1].split("</code")[0];
        return code;
    }

    public Authentication secondConnect(String urlFinal, String Code) {

        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
        parametersMap.add("client_id", config.getClientId());
        parametersMap.add("client_secret", config.getClientSecret());
        parametersMap.add("redirect_uri", config.getRedirect_uri());
        parametersMap.add("code", Code);
        parametersMap.add("grant_type", config.getGrantType());

        Authentication auth = restTemplate.postForObject(urlFinal, parametersMap, Authentication.class);
        return auth;
    }
}
