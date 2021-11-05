package com.senseen.stellioApi.adapter;

import com.senseen.stellioApi.models.AgriCrop;
import com.senseen.stellioApi.models.AgriCropJson;
import com.squareup.moshi.FromJson;

public class AgriCropAdapter {
    @FromJson
    public AgriCrop agriCropFromJson(AgriCropJson agriCropJson){
        AgriCrop agriCrop = new AgriCrop();
        agriCrop.setId(agriCropJson.getId());
        agriCrop.setType(agriCropJson.getType());
        agriCrop.setDescription(agriCropJson.getDescription().get("value").getAsString());
        agriCrop.setName(agriCropJson.getName().get("value").getAsString());
        agriCrop.setCityName(agriCropJson.getCityName().get("value").getAsString());
        agriCrop.setOwner(agriCropJson.getOwner().get("value").getAsString());
        return agriCrop;
    }
}
