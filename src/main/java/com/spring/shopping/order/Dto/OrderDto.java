package com.spring.shopping.order.Dto;

import com.spring.shopping.base.Dto.BaseDto;
import com.spring.shopping.usermanagement.Dto.AppUserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(name = "Order Entity")
@Getter
@Setter
public class OrderDto extends BaseDto <Long>{

    private LocalDate orderDate;

    private double totalAmount;

    private AppUserDto user;

}
