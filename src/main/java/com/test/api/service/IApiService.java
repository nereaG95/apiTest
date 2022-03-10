package com.test.api.service;

import com.test.api.Model.Collection;

import java.net.http.HttpResponse;
import java.util.List;

public interface IApiService {

    List<Collection> filterPeticionList(List<Collection> listCollection, String id, String desc, String title, String descPhoto);

    List<Collection> filterPeticion(List<Collection> listCollection, String filter);

    String peticionListaAPI(String basicURL, String id, String desc, String title, String url) ;

    String peticionListaAPIfilter(String basicURL, String filter);


}
