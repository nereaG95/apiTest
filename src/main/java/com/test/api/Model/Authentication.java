package com.test.api.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Authentication {
    public String access_token;

    public String token_type ;

    public String refresh_token;

    public String scope;

    public String created_at;


    @Override
    public String toString() {
        return "Authentication{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", scope='" + scope + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
