package com.senseen.stellioApi.models;

import com.google.gson.JsonObject;

public class PersonJson {
    String id;
    String type;
    JsonObject lastName;
    JsonObject firstName;
    JsonObject addressLocality;
    JsonObject addressCountry;
    JsonObject addressStreet;
    JsonObject email;
    JsonObject telephone;

    public PersonJson(String id, String type, JsonObject lastName, JsonObject firstName, JsonObject addressLocality, JsonObject addressCountry, JsonObject addressStreet, JsonObject email, JsonObject telephone) {
        this.id = id;
        this.type = type;
        this.lastName = lastName;
        this.firstName = firstName;
        this.addressLocality = addressLocality;
        this.addressCountry = addressCountry;
        this.addressStreet = addressStreet;
        this.email = email;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public JsonObject getLastName() {
        return lastName;
    }

    public JsonObject getFirstName() {
        return firstName;
    }

    public JsonObject getAddressLocality() {
        return addressLocality;
    }

    public JsonObject getAddressCountry() {
        return addressCountry;
    }

    public JsonObject getAddressStreet() {
        return addressStreet;
    }

    public JsonObject getEmail() {
        return email;
    }

    public JsonObject getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "PersonJson{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", lastName=" + lastName +
                ", firstName=" + firstName +
                ", addressLocality=" + addressLocality +
                ", addressCountry=" + addressCountry +
                ", addressStreet=" + addressStreet +
                ", email=" + email +
                ", telephone=" + telephone +
                '}';
    }
}
