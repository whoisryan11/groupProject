package com.lian.group;

public class AuthenticationResponse {

    private final String jwd;

    public AuthenticationResponse(String jwd) {
        this.jwd = jwd;
    }

    public String getJwd() {
        return jwd;
    }
}
