package com.spring.shopping.catalog.Repo;

import com.spring.shopping.base.Repo.BaseRepo;
import com.spring.shopping.catalog.Entity.CatalogEntity;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepo extends BaseRepo<CatalogEntity,Long> {

}
