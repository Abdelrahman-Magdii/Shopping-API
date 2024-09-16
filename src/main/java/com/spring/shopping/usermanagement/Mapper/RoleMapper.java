package com.spring.shopping.usermanagement.Mapper;

import com.spring.shopping.base.Mapper.BaseMapper;
import com.spring.shopping.usermanagement.Dto.AppUserDto;
import com.spring.shopping.usermanagement.Dto.RoleDto;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import com.spring.shopping.usermanagement.Entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<RoleEntity, RoleDto> {

}
