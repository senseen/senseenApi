package com.senseen.stellioApi.models;

public class AgriCrop {

    String id;
    String type;
    String description;
    String name;
    String cityName;
    String owner;

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "AgriCrop{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", cityName='" + cityName + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
