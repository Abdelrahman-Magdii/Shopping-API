package com.spring.shopping.usermanagement.Dto;

import com.spring.shopping.base.Dto.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Users Entity")
@Getter
@Setter
public class AppUserDto extends BaseDto <Long>{

    private String userNName;

//    private String password;

    private String phoneNumber;

    private String address ;

}
