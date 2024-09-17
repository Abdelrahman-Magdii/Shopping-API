package com.spring.shopping.security;

import com.spring.shopping.security.Jwt.AuthenticationService;
import com.spring.shopping.security.Jwt.JwtUtils;
import com.spring.shopping.security.model.LoginResponse;
import com.spring.shopping.security.model.LoginUserDto;
import com.spring.shopping.security.model.RegisterUserDto;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Schema(name = "Authentication Entity")
@Tag(name = "Authentication")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtils jwtUtils;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody RegisterUserDto registerUserDto) {
         authenticationService.signup(registerUserDto);

        return ResponseEntity.ok("User registered successfully");
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        AppUserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtUtils.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtUtils.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }



}
