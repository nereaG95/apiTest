package com.test.api.service;

import com.test.api.Model.Authentication;

public interface IAuthService {

    String firstConnect(String urlFinal);

    Authentication secondConnect(String urlFinal, String Code);
}
