package com.spring.shopping.catalog.Dto;

import com.spring.shopping.base.Dto.BaseDto;
import com.spring.shopping.catalog.Entity.CatalogEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Schema(name = "Product Entity")
@Getter
@Setter
public class ProductDto extends BaseDto <Long>{

    private String name ;

    private CatalogDto category;

    private double price;

    private double quantity;

    private String description;
}
