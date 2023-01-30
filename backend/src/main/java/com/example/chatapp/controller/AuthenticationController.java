package com.example.chatapp.controller;

import com.example.chatapp.dto.UserDto;
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
    public void register(@RequestBody UserDto userDto) {
        authenticationService.register(userDto.getNickName(),
                userDto.getPassword());
    }

    @PostMapping("/login")
    public Token login(@RequestBody UserDto userDto) {
        String value = authenticationService
                .login(userDto.getNickName(), userDto.getPassword());
        return new Token(value);
    }
}
