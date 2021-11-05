package com.senseen.stellioApi.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AgriCropRecordJson {
    String id;
    String type;
    JsonObject hasAgriCrop;
    JsonObject pressure;
    JsonObject humidity;
    JsonObject temperature;
    JsonObject location;
    JsonObject redox;
    JsonObject conductivity;
    JsonObject pH;
    JsonObject observedBy;
    JsonArray absorbance;

    public AgriCropRecordJson(String id, String type, JsonObject hasAgriCrop, JsonObject pressure, JsonObject humidity, JsonObject temperature, JsonObject location, JsonObject redox, JsonObject conductivity, JsonObject pH, JsonObject observedBy, JsonArray absorbance) {
        this.id = id;
        this.type = type;
        this.hasAgriCrop = hasAgriCrop;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temperature = temperature;
        this.location = location;
        this.redox = redox;
        this.conductivity = conductivity;
        this.pH = pH;
        this.observedBy = observedBy;
        this.absorbance = absorbance;
    }

    public AgriCropRecordJson(String id, String type, JsonObject hasAgriCrop, JsonObject pressure, JsonObject humidity, JsonObject temperature, JsonObject location, JsonObject observedBy, JsonArray absorbance) {
        this.id = id;
        this.type = type;
        this.hasAgriCrop = hasAgriCrop;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temperature = temperature;
        this.location = location;
        this.observedBy = observedBy;
        this.absorbance = absorbance;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public JsonObject getHasAgriCrop() {
        return hasAgriCrop;
    }

    public JsonObject getPressure() {
        return pressure;
    }

    public JsonObject getHumidity() {
        return humidity;
    }

    public JsonObject getTemperature() {
        return temperature;
    }

    public JsonObject getLocation() {
        return location;
    }

    public JsonObject getRedox() {
        return redox;
    }

    public JsonObject getConductivity() {
        return conductivity;
    }

    public JsonObject getpH() {
        return pH;
    }

    public JsonObject getObservedBy() {
        return observedBy;
    }

    public JsonArray getAbsorbance() {
        return absorbance;
    }

    @Override
    public String toString() {
        return "AgriCropRecordJson{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", hasAgriCrop=" + hasAgriCrop +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                ", location=" + location +
                ", redox=" + redox +
                ", conductivity=" + conductivity +
                ", pH=" + pH +
                ", observedBy=" + observedBy +
                ", absorbance=" + absorbance +
                '}';
    }
}
