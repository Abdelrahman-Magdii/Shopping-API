package com.spring.shopping.catalog.Mapper;

import com.spring.shopping.base.Mapper.BaseMapper;
import com.spring.shopping.catalog.Dto.ProductDto;
import com.spring.shopping.catalog.Entity.ProductEntity;
import com.spring.shopping.usermanagement.Dto.RoleDto;
import com.spring.shopping.usermanagement.Entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<ProductEntity, ProductDto> {

}
