package com.spring.shopping.usermanagement.Repo;

import com.spring.shopping.base.Repo.BaseRepo;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends BaseRepo<AppUserEntity,Long> {

    Optional<AppUserEntity> findByUserNName (String userName);

}
