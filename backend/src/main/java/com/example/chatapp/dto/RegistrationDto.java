package com.example.chatapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {
    @NotBlank
    private String nickName;
    @NotBlank
    private String password;
}
