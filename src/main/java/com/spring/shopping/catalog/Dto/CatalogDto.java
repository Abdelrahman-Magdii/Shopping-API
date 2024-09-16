package com.spring.shopping.catalog.Dto;

import com.spring.shopping.base.Dto.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "Category Entity")
@Getter
@Setter
public class CatalogDto extends BaseDto <Long>{

    private String name ;

}
