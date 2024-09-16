package com.spring.shopping.order.Controller;

import com.spring.shopping.order.Dto.OrderDetailsDto;
import com.spring.shopping.order.Entity.OrderDetails;
import com.spring.shopping.order.Mapper.OrderDetailsMapper;
import com.spring.shopping.order.Services.OrderDetailsServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Order Details")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailsController {

    private final OrderDetailsServices orderDetailsServices;
    private final OrderDetailsMapper orderDetailsMapper;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<OrderDetailsDto> dtos = orderDetailsMapper.map(orderDetailsServices.findAll());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        OrderDetails entity = orderDetailsServices.findById(id);
       if (entity != null) {
           OrderDetailsDto dto = orderDetailsMapper.map(entity);
           return ResponseEntity.ok(dto);
       }else{
           return new ResponseEntity<>("Catalog with id :" +id+"not found", HttpStatus.NOT_FOUND);
       }
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody OrderDetailsDto orderDetailsDto) {
        OrderDetails entity = orderDetailsMapper.unMap(orderDetailsDto);
        orderDetailsServices.insert(entity);
        OrderDetailsDto dto = orderDetailsMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody OrderDetailsDto orderDetailsDto) {
        OrderDetails entity = orderDetailsMapper.unMap(orderDetailsDto);
        orderDetailsServices.update(entity);
        OrderDetailsDto dto = orderDetailsMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        OrderDetails entity = orderDetailsServices.findById(id);
        if (entity != null) {
            orderDetailsServices.deleteById(id);
            return new ResponseEntity<>("Successfully deleted catalog with id: " + id, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Catalog with id :" +id+"not found", HttpStatus.NOT_FOUND);
        }
    }
}
