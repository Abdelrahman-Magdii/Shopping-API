package com.spring.shopping.usermanagement.Repo;

import com.spring.shopping.base.Repo.BaseRepo;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import com.spring.shopping.usermanagement.Entity.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends BaseRepo<RoleEntity,Long> {

    RoleEntity findByName(String name);

}
