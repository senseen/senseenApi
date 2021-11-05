package com.senseen.stellioApi.models;

public class Device {
    String id;
    String type;
    String category;
    String controlledProperty;
    String dateFirstUsed;
    String deviceState;
    String owner;
    String macAddress;
    String serialNumber;
    String temperature;
    String humidity;
    String tempLamp;
    String batteryLevel;
    String observedAt;

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setControlledProperty(String controlledProperty) {
        this.controlledProperty = controlledProperty;
    }

    public void setDateFirstUsed(String dateFirstUsed) {
        this.dateFirstUsed = dateFirstUsed;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setTempLamp(String tempLamp) {
        this.tempLamp = tempLamp;
    }

    public void setBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void setObservedAt(String observedAt) {
        this.observedAt = observedAt;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", controlledProperty='" + controlledProperty + '\'' +
                ", dateFirstUsed='" + dateFirstUsed + '\'' +
                ", deviceState='" + deviceState + '\'' +
                ", owner='" + owner + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", tempLamp='" + tempLamp + '\'' +
                ", batteryLevel='" + batteryLevel + '\'' +
                ", observedAt='" + observedAt + '\'' +
                '}';
    }
}
