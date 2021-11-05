package com.senseen.stellioApi.models;

public final class Token {
    private final String access_token;

    private final String refresh_token;

    private final int expires_in;

    private final int refresh_expires_in;

    public Token(String access_token, String refresh_token, int expires_in, int refresh_expires_in){
        this.access_token=access_token;
        this.refresh_token=refresh_token;
        this.expires_in=expires_in;
        this.refresh_expires_in=refresh_expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public int getRefresh_expires_in() {
        return refresh_expires_in;
    }
}
