package com.spring.shopping.usermanagement.Services;

import com.spring.shopping.base.Services.BaseServices;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AppUserServices extends BaseServices<AppUserEntity, Long> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUserEntity insert(AppUserEntity entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.insert(entity);
    }

}
