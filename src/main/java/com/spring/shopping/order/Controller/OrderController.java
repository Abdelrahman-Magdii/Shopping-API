package com.spring.shopping.order.Controller;

import com.spring.shopping.order.Dto.OrderDto;
import com.spring.shopping.order.Entity.Order;
import com.spring.shopping.order.Mapper.OrderMapper;
import com.spring.shopping.order.Services.OrderServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Order")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {


    private final OrderServices orderServices;
    private final OrderMapper orderMapper;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<OrderDto> dtos = orderMapper.map(orderServices.findAll());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Order entity = orderServices.findById(id);
        if (entity != null) {
            OrderDto dto = orderMapper.map(entity);
            return ResponseEntity.ok(dto);
        }else{
            return new ResponseEntity<>("Product with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody OrderDto orderDto) {
        Order entity = orderMapper.unMap(orderDto);
        entity = orderServices.insert(entity);
        OrderDto dto = orderMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody OrderDto orderDto) {
        Order entity = orderMapper.unMap(orderDto);
        entity = orderServices.update(entity);
        OrderDto dto = orderMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Order entity = orderServices.findById(id);
        if (entity != null) {
            orderServices.deleteById(id);
            return new ResponseEntity<>("Successfully deleted product with id: " + id, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Product with id :" +id+"not found", HttpStatus.NOT_FOUND);
        }
    }




}
