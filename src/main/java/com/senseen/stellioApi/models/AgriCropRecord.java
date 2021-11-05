package com.senseen.stellioApi.models;



public class AgriCropRecord {
    String id;
    String type;
    String hasAgriCrop;
    String pressure;
    String humidity;
    String temperature;
    String location;
    String redox;
    String conductivity;
    String pH;
    String observedBy;
    String absorbance;
    String observedAt;

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHasAgriCrop(String hasAgriCrop) {
        this.hasAgriCrop = hasAgriCrop;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRedox(String redox) {
        this.redox = redox;
    }

    public void setConductivity(String conductivity) {
        this.conductivity = conductivity;
    }

    public void setpH(String pH) {
        this.pH = pH;
    }

    public void setObservedBy(String observedBy) {
        this.observedBy = observedBy;
    }

    public void setAbsorbance(String absorbance) {
        this.absorbance = absorbance;
    }

    public void setObservedAt(String observedAt) {
        this.observedAt = observedAt;
    }

    @Override
    public String toString() {
        return "AgriCropRecord{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", hasAgriCrop='" + hasAgriCrop + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", temperature='" + temperature + '\'' +
                ", location='" + location + '\'' +
                ", redox='" + redox + '\'' +
                ", conductivity='" + conductivity + '\'' +
                ", pH='" + pH + '\'' +
                ", observedBy='" + observedBy + '\'' +
                ", absorbance='" + absorbance + '\'' +
                ", observedAt='" + observedAt + '\'' +
                '}';
    }
}
