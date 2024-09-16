package com.spring.shopping.order.Dto;

import com.spring.shopping.base.Dto.BaseDto;
import com.spring.shopping.catalog.Dto.ProductDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Order Details Entity")
@Getter
@Setter
public class OrderDetailsDto extends BaseDto <Long>{

    private OrderDto order_id;

    private ProductDto product_id;

    private double quantity;

    private double price;

}
