package com.spring.shopping.order.Mapper;

import com.spring.shopping.base.Mapper.BaseMapper;
import com.spring.shopping.order.Dto.OrderDto;
import com.spring.shopping.order.Entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<Order, OrderDto> {

}
