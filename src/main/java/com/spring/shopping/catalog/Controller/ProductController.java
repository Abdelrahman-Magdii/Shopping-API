package com.spring.shopping.catalog.Controller;

import com.spring.shopping.catalog.Dto.ProductDto;
import com.spring.shopping.catalog.Entity.ProductEntity;
import com.spring.shopping.catalog.Mapper.ProductMapper;
import com.spring.shopping.catalog.Services.ProductServices;
import com.spring.shopping.usermanagement.Dto.RoleDto;
import com.spring.shopping.usermanagement.Mapper.RoleMapper;
import com.spring.shopping.usermanagement.Services.RoleServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Product")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {


    private final ProductServices productServices;
    private final ProductMapper productMapper;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<ProductDto> dtos = productMapper.map(productServices.findAll());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ProductEntity entity = productServices.findById(id);
        if (entity != null) {
            ProductDto dto = productMapper.map(entity);
            return ResponseEntity.ok(dto);
        }else{
            return new ResponseEntity<>("Product with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody ProductDto productDto) {
        ProductEntity entity = productMapper.unMap(productDto);
        entity = productServices.insert(entity);
        ProductDto dto = productMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody ProductDto productDto) {
        ProductEntity entity = productMapper.unMap(productDto);
        entity = productServices.update(entity);
        ProductDto dto = productMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ProductEntity entity = productServices.findById(id);
        if (entity != null) {
            productServices.deleteById(id);
            return new ResponseEntity<>("Successfully deleted product with id: " + id, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Product with id :" +id+"not found", HttpStatus.NOT_FOUND);
        }
    }




}
