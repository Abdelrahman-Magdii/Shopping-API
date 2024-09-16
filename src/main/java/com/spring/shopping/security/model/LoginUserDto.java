package com.spring.shopping.security.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Login Entity")
@Setter
@Getter
public class LoginUserDto {
    private String username;
    private String password;
}
