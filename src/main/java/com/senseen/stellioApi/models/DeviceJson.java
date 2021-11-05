package com.senseen.stellioApi.models;

import com.google.gson.JsonObject;

public class DeviceJson {
    String id;
    String type;
    JsonObject category;
    JsonObject controlledProperty;
    JsonObject dateFirstUsed;
    JsonObject deviceState;
    JsonObject owner;
    JsonObject macAddress;
    JsonObject serialNumber;
    JsonObject temperature;
    JsonObject humidity;
    JsonObject tempLamp;
    JsonObject batteryLevel;

    public DeviceJson(String id, String type, JsonObject category, JsonObject controlledProperty, JsonObject dateFirstUsed, JsonObject deviceState, JsonObject owner, JsonObject macAddress, JsonObject serialNumber, JsonObject temperature, JsonObject humidity, JsonObject tempLamp, JsonObject batteryLevel) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.controlledProperty = controlledProperty;
        this.dateFirstUsed = dateFirstUsed;
        this.deviceState = deviceState;
        this.owner = owner;
        this.macAddress = macAddress;
        this.serialNumber = serialNumber;
        this.temperature = temperature;
        this.humidity = humidity;
        this.tempLamp = tempLamp;
        this.batteryLevel = batteryLevel;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public JsonObject getCategory() {
        return category;
    }

    public JsonObject getControlledProperty() {
        return controlledProperty;
    }

    public JsonObject getDateFirstUsed() {
        return dateFirstUsed;
    }

    public JsonObject getDeviceState() {
        return deviceState;
    }

    public JsonObject getOwner() {
        return owner;
    }

    public JsonObject getMacAddress() {
        return macAddress;
    }

    public JsonObject getSerialNumber() {
        return serialNumber;
    }

    public JsonObject getTemperature() {
        return temperature;
    }

    public JsonObject getHumidity() {
        return humidity;
    }

    public JsonObject getTempLamp() {
        return tempLamp;
    }

    public JsonObject getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public String toString() {
        return "DeviceJson{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", category=" + category +
                ", controlledProperty=" + controlledProperty +
                ", dateFirstUsed=" + dateFirstUsed +
                ", deviceState=" + deviceState +
                ", owner=" + owner +
                ", macAddress=" + macAddress +
                ", serialNumber=" + serialNumber +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", tempLamp=" + tempLamp +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
