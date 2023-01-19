package com.example.chatapp.service;

public interface AuthenticationService {
    void register(String nickName, String password);

    String login(String nickName, String password);
}
