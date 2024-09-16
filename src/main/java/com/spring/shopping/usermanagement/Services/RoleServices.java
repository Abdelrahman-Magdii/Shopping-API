package com.spring.shopping.usermanagement.Services;

import com.spring.shopping.base.Services.BaseServices;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import com.spring.shopping.usermanagement.Entity.RoleEntity;
import com.spring.shopping.usermanagement.Repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServices extends BaseServices<RoleEntity,Long> {

    private final RoleRepo roleRepo;

    public RoleEntity findByName(String name){
        return roleRepo.findByName(name);
    }

}
