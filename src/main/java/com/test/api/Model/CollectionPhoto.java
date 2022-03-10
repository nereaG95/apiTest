package com.test.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionPhoto {

    @JsonProperty("description")
    String cover_photo_description;


    public CollectionPhoto(@JsonProperty("description") String cover_photo_description) {
        this.cover_photo_description = cover_photo_description;
    }

    public String getCover_photo_description() {
        return cover_photo_description;
    }
}
