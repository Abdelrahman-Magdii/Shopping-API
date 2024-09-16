package com.spring.shopping.security.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Schema(name = "Register Entity")
@Setter
@Getter
public class RegisterUserDto {

    private String userName;

    private String password;

    private String phoneNumber;

    private String address ;

}
