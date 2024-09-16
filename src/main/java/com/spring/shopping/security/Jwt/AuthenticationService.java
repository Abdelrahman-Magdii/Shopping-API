package com.spring.shopping.security.Jwt;

import com.spring.shopping.security.model.LoginUserDto;
import com.spring.shopping.security.model.RegisterUserDto;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import com.spring.shopping.usermanagement.Repo.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public void signup(RegisterUserDto input) {
        AppUserEntity user = new AppUserEntity();
        user.setUserNName(input.getUserName());
        user.setPhoneNumber(input.getPhoneNumber());
        user.setAddress(input.getAddress());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        appUserRepo.save(user);
    }

    public AppUserEntity authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return appUserRepo.findByUserNName(input.getUsername())
                .orElseThrow();
    }
}