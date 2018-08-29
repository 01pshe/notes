package com.vol.notes.services;

public interface SecurityService {

    String findLoggedInUserName();

    void autoLogin(String userName, String password);
}
