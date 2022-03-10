package com.test.api.service;

import com.google.gson.Gson;
import com.test.api.Configuration.TokenConfiguration;
import com.test.api.Model.Collection;
import com.test.api.Util.JsonBodyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ApiService implements IApiService {

    @Autowired
    private TokenConfiguration config;

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();


    /*
    Filtro de la lista por un unico parametro filter
     */
    public List<Collection> filterPeticion(List<Collection> listCollection, String filter){
        List<Collection> listCollectionNew  = listCollection;
        if(filter!=null){
            listCollectionNew = listCollection.stream().filter(l -> ( addList(filter, l.getId()) || addList(filter, l.getTitle()) || addList(filter, l.getDescription())
                    || addList(filter, l.getDescriptionPhoto().getCover_photo_description()))).collect(Collectors.toList());
        }
        return listCollectionNew;
    }

    /*
    Filtro de la lista por diferentes parametros
     */
    public List<Collection> filterPeticionList(List<Collection> listCollection, String id, String desc, String title, String descPhoto){
        List<Collection> listCollectionNew  = listCollection;
        if(id!=null || desc!=null || title!=null || descPhoto!=null){
            listCollectionNew = listCollection.stream().filter(l -> ( addList(id, l.getId()) || addList(title, l.getTitle()) || addList(desc, l.getDescription())
                    || addList(descPhoto, l.getDescriptionPhoto().getCover_photo_description()))).collect(Collectors.toList());
        }
        return listCollectionNew;
    }

    public String peticionListaAPIfilter(String basicURL, String filter){
        List<Collection> listCollection = new ArrayList<>();
        String token = config.getToken();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(basicURL))
                    .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token )
                    .build();
            HttpResponse<Collection[]> response = httpClient.send(request, new JsonBodyHandler<>(Collection[].class));
            String statusCode = String.valueOf(response.statusCode());
            listCollection = filterPeticion(Arrays.asList(response.body()), filter);
            Gson gson = new Gson();
            String json = gson.toJson(listCollection);
            return statusCodeStr(response.statusCode()) + json;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error al realizar la petición GET";
        }
    }

    public String peticionListaAPI(String basicURL, String id, String desc, String title, String descPhoto){
        List<Collection> listCollection = new ArrayList<>();
        String token = config.getToken();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(basicURL))
                    .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token )
                    .build();
            HttpResponse<Collection[]> response = httpClient.send(request, new JsonBodyHandler<>(Collection[].class));
            String statusCode = String.valueOf(response.statusCode());
            listCollection = filterPeticionList(Arrays.asList(response.body()),id,desc,title,descPhoto);
            Gson gson = new Gson();
            String json = gson.toJson(listCollection);
            return statusCodeStr(response.statusCode()) + json;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error al realizar la petición GET";
        }
    }

    private boolean addList(String identificador, String valor){
        if(identificador == null || valor==null){
            return false;
        }
        if(identificador!=null){
            if(valor!=null && valor.contains(identificador)){
                return true;
            }
        }
        return false;
    }

    private String statusCodeStr (int code){
        String strCode = String.valueOf(code);
        if(code == 200){
            strCode = strCode + " OK ";
        }
        return strCode;
    }

}
