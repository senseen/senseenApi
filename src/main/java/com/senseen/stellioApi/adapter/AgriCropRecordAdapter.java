package com.senseen.stellioApi.adapter;

import com.senseen.stellioApi.models.AgriCropRecord;
import com.senseen.stellioApi.models.AgriCropRecordJson;
import com.squareup.moshi.FromJson;

public class AgriCropRecordAdapter {
    @FromJson
    public AgriCropRecord agriCropRecordFromJson(AgriCropRecordJson agriCropRecordJson){
        AgriCropRecord agriCropRecord = new AgriCropRecord();
        agriCropRecord.setId(agriCropRecordJson.getId());
        agriCropRecord.setType(agriCropRecordJson.getType());
        agriCropRecord.setHasAgriCrop(agriCropRecordJson.getHasAgriCrop().get("object").getAsString());
        //agriCropRecord.setPressure(agriCropRecordJson.getPressure().get("value").getAsString());
        //agriCropRecord.setHumidity(agriCropRecordJson.getHumidity().get("value").getAsString());
        //agriCropRecord.setTemperature(agriCropRecordJson.getTemperature().get("value").getAsString());
        //agriCropRecord.setLocation(agriCropRecordJson.getLocation().get("value").getAsString());
        //agriCropRecord.setRedox(agriCropRecordJson.getRedox().getAsString());
        //agriCropRecord.setConductivity(agriCropRecordJson.getConductivity().getAsString());
        //agriCropRecord.setpH(agriCropRecordJson.getpH().getAsString());
        agriCropRecord.setObservedBy(agriCropRecordJson.getObservedBy().get("object").getAsString());
        agriCropRecord.setAbsorbance(agriCropRecordJson.getAbsorbance().toString());
        agriCropRecord.setObservedAt(agriCropRecordJson.getObservedBy().get("observedAt").getAsString());

        return agriCropRecord;
    }
}
