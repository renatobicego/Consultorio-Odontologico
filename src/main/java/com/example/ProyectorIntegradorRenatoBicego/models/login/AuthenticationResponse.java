package com.example.ProyectorIntegradorRenatoBicego.models.login;

public class AuthenticationResponse {

    private final String jwt;
    private final AppUser appUser;

    public AuthenticationResponse(String jwt, AppUser appUser) {
        this.jwt = jwt;
        this.appUser = appUser;
    }

    public String getJwt() {
        return jwt;
    }

    public AppUser getAppUser() {
        return appUser;
    }
}
