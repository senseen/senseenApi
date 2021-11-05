package com.senseen.stellioApi.adapter;



import com.senseen.stellioApi.models.Person;
import com.senseen.stellioApi.models.PersonJson;
import com.squareup.moshi.FromJson;

public class PersonAdapter {
    @FromJson
    public Person personFromJson(PersonJson personJson){
        Person person = new Person();
        person.setId(personJson.getId());
        person.setType(personJson.getType());
        person.setLastName(personJson.getLastName().get("value").getAsString());
        person.setFirstName(personJson.getFirstName().get("value").getAsString());
        person.setAddressLocality(personJson.getAddressLocality().get("value").getAsString());
        person.setAddressCountry(personJson.getAddressCountry().get("value").getAsString());
        person.setAddressStreet(personJson.getAddressStreet().get("value").getAsString());
        person.setEmail(personJson.getEmail().get("value").getAsString());
        person.setTelephone(personJson.getTelephone().get("value").getAsString());
        return person;
    }
}
