package com.spring.shopping.catalog.Mapper;

import com.spring.shopping.base.Mapper.BaseMapper;
import com.spring.shopping.catalog.Dto.CatalogDto;
import com.spring.shopping.catalog.Entity.CatalogEntity;
import com.spring.shopping.usermanagement.Dto.AppUserDto;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CatalogMapper extends BaseMapper<CatalogEntity, CatalogDto> {

}
