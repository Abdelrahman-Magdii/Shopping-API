package com.spring.shopping.catalog.Repo;

import com.spring.shopping.base.Repo.BaseRepo;
import com.spring.shopping.catalog.Entity.ProductEntity;
import com.spring.shopping.usermanagement.Entity.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends BaseRepo<ProductEntity,Long> {


}
