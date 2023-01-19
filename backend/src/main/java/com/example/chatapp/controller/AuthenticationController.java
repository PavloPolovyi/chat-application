package com.example.chatapp.controller;

import com.example.chatapp.dto.RegistrationDto;
import com.example.chatapp.dto.Token;
import com.example.chatapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegistrationDto registrationDto) {
        authenticationService.register(registrationDto.getNickName(),
                registrationDto.getPassword());
    }

    @PostMapping("/login")
    public Token login(@RequestBody RegistrationDto registrationDto) {
        String value = authenticationService
                .login(registrationDto.getNickName(), registrationDto.getPassword());
        return new Token(value);
    }
}
