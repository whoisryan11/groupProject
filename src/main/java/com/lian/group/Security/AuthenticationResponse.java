package com.lian.group.Security;

public class AuthenticationResponse {

    private final String jwd;

    public AuthenticationResponse(String jwd) {
        this.jwd = jwd;
    }

    public String getJwd() {
        return jwd;
    }
}
