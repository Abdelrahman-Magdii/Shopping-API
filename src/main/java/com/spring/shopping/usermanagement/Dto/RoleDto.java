package com.spring.shopping.usermanagement.Dto;

import com.spring.shopping.base.Dto.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Role Entity")
@Getter
@Setter
public class RoleDto extends BaseDto <Long>{

    private String name;
}
