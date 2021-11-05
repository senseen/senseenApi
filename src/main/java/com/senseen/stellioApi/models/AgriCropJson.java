package com.senseen.stellioApi.models;

import com.google.gson.JsonObject;

public class AgriCropJson {
    String id;
    String type;
    JsonObject description;
    JsonObject name;
    JsonObject cityName;
    JsonObject owner;

    public AgriCropJson(String id, String type, JsonObject description, JsonObject name, JsonObject cityName, JsonObject owner) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.name = name;
        this.cityName = cityName;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public JsonObject getDescription() {
        return description;
    }

    public JsonObject getName() {
        return name;
    }

    public JsonObject getCityName() {
        return cityName;
    }

    public JsonObject getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "AgriCropJson{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", description=" + description +
                ", name=" + name +
                ", cityName=" + cityName +
                ", owner=" + owner +
                '}';
    }
}
