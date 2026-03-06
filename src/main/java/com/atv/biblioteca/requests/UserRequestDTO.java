package com.atv.biblioteca.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
