package com.test.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Collection {

    @JsonProperty("id")
    String id;

    @JsonProperty("title")
    String title;

    @JsonProperty("description")
    String description;

    @JsonProperty("cover_photo")
    CollectionPhoto descriptionPhoto;

    public Collection(@JsonProperty("id") String id, @JsonProperty("title") String title, @JsonProperty("description") String description, @JsonProperty("cover_photo")
            CollectionPhoto collectionPhoto){
        this.id=id;
        this.title= title;
        this.description = description;
        this.descriptionPhoto = collectionPhoto;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\n' +
                ", title='" + title + '\n' +
                ", description='" + description + '\n' +
                ", descriptionPhoto=" + descriptionPhoto.cover_photo_description +
                '}' + '\n';
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public CollectionPhoto getDescriptionPhoto() {
        return descriptionPhoto;
    }
}