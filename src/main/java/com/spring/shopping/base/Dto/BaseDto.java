package com.spring.shopping.base.Dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseDto <ID extends Number>{

    private ID id;

    private String statusCode;

}
