package com.spring.shopping.catalog.Controller;

import com.spring.shopping.catalog.Dto.CatalogDto;
import com.spring.shopping.catalog.Entity.CatalogEntity;
import com.spring.shopping.catalog.Mapper.CatalogMapper;
import com.spring.shopping.catalog.Services.CatalogServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CataLog")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogServices catalogServices;
    private final CatalogMapper catalogMapper;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<CatalogDto> dtos = catalogMapper.map(catalogServices.findAll());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
       CatalogEntity entity = catalogServices.findById(id);
       if (entity != null) {
           CatalogDto dto = catalogMapper.map(entity);
           return ResponseEntity.ok(dto);
       }else{
           return new ResponseEntity<>("Catalog with id :" +id+"not found", HttpStatus.NOT_FOUND);
       }
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody CatalogDto catalogDto) {
        CatalogEntity entity = catalogMapper.unMap(catalogDto);
        catalogServices.insert(entity);
        CatalogDto dto = catalogMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody CatalogDto catalogDto) {
        CatalogEntity entity = catalogMapper.unMap(catalogDto);
        catalogServices.update(entity);
        CatalogDto dto = catalogMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        CatalogEntity entity = catalogServices.findById(id);
        if (entity != null) {
            catalogServices.deleteById(id);
            return new ResponseEntity<>("Successfully deleted catalog with id: " + id, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Catalog with id :" +id+"not found", HttpStatus.NOT_FOUND);
        }
    }
}
