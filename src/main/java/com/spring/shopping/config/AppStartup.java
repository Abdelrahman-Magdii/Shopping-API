package com.spring.shopping.config;

import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import com.spring.shopping.usermanagement.Entity.RoleEntity;
import com.spring.shopping.usermanagement.Services.AppUserServices;
import com.spring.shopping.usermanagement.Services.RoleServices;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AppStartup implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppStartup.class);

    @Lazy
    private final AppUserServices appUserServices;
    private final RoleServices roleServices;

    @Override
    public void run(String... args) {
        try {
            addRoleDemoData();
            addUserDemoData();
        } catch (Exception e) {
            logger.error("Error initializing demo data: {}", e.getMessage(), e);
        }
    }

    private void addUserDemoData() {
        if (appUserServices.findAll().isEmpty()) {
            RoleEntity adminRole = roleServices.findByName("ADMIN");
            RoleEntity userRole = roleServices.findByName("USER");

            if (adminRole != null && userRole != null) {
                appUserServices.insert(createUser("abdo", "123", Arrays.asList(adminRole)));
                appUserServices.insert(createUser("medo", "123", Arrays.asList(userRole)));
                appUserServices.insert(createUser("Mo", "123", Arrays.asList(userRole)));
            } else {
                logger.warn("Required roles not found.");
            }
        }
    }

    private void addRoleDemoData() {
        if (roleServices.findAll().isEmpty()) {
            roleServices.insert(new RoleEntity("ADMIN"));
            roleServices.insert(new RoleEntity("USER"));
        }
    }

    private AppUserEntity createUser(String username, String password, List<RoleEntity> roles) {
        return new AppUserEntity(username, password,"01220430770", "Egypt", roles);
    }
}
