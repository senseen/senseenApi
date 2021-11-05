package com.senseen.stellioApi.adapter;

import com.senseen.stellioApi.models.Device;
import com.senseen.stellioApi.models.DeviceJson;
import com.squareup.moshi.FromJson;

public class DeviceAdapter {
    @FromJson
    public Device deviceFromJson(DeviceJson deviceJson){
        Device device = new Device();
        device.setId(deviceJson.getId());
        device.setType(deviceJson.getType());
        device.setCategory(deviceJson.getCategory().get("value").getAsString());
        device.setControlledProperty(deviceJson.getControlledProperty().get("value").getAsString());
        device.setDateFirstUsed(deviceJson.getDateFirstUsed().get("value").getAsString());
        device.setDeviceState(deviceJson.getDeviceState().get("value").getAsString());
        device.setOwner(deviceJson.getOwner().get("value").getAsString());
        device.setMacAddress(deviceJson.getMacAddress().get("value").getAsString());
        device.setSerialNumber(deviceJson.getSerialNumber().get("value").getAsString());
        device.setTemperature(deviceJson.getTemperature().get("value").getAsString());
        device.setHumidity(deviceJson.getHumidity().get("value").getAsString());
        device.setTempLamp(deviceJson.getTempLamp().get("value").getAsString());
        device.setBatteryLevel(deviceJson.getBatteryLevel().get("value").getAsString());
        device.setObservedAt(deviceJson.getOwner().get("observedAt").getAsString());
        return device;
    }
}
