package com.spring.shopping.security.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Token Entity")
@Getter
@Setter
public class LoginResponse {

    private String token;

    private long expiresIn;


}
