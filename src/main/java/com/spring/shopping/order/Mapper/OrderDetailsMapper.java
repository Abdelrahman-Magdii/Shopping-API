package com.spring.shopping.order.Mapper;

import com.spring.shopping.base.Mapper.BaseMapper;
import com.spring.shopping.catalog.Dto.ProductDto;
import com.spring.shopping.catalog.Entity.ProductEntity;
import com.spring.shopping.order.Dto.OrderDetailsDto;
import com.spring.shopping.order.Entity.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface OrderDetailsMapper extends BaseMapper<OrderDetails, OrderDetailsDto> {

    @Override
    @Mapping(source="order" ,target ="order_id" )
    @Mapping(source ="product" ,target ="product_id" )
    OrderDetailsDto map(OrderDetails orderDetails);

    @Override
    @Mapping(target="order" ,source ="order_id" )
    @Mapping(target ="product" ,source ="product_id" )
    OrderDetails unMap(OrderDetailsDto orderDetailsDto);

    @Override
    @Mapping(source="order" ,target ="order_id" )
    @Mapping(source ="product" ,target ="product_id" )
    List<OrderDetailsDto> map(List<OrderDetails> t);

    @Override
    @Mapping(source="order" ,target ="order_id" )
    @Mapping(source ="product" ,target ="product_id" )
    Set<OrderDetailsDto> map(Set<OrderDetails> t);

    @Override
    @Mapping(target="order" ,source ="order_id" )
    @Mapping(target ="product" ,source ="product_id" )
    List<OrderDetails> unMap(List<OrderDetailsDto> dto);

}
