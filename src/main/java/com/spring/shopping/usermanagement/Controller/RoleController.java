package com.spring.shopping.usermanagement.Controller;

import com.spring.shopping.usermanagement.Dto.RoleDto;
import com.spring.shopping.usermanagement.Entity.RoleEntity;
import com.spring.shopping.usermanagement.Mapper.RoleMapper;
import com.spring.shopping.usermanagement.Services.RoleServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Role")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/role")
public class RoleController {


    private final RoleServices roleService;
    private final RoleMapper roleMapper;


    @GetMapping("")
    public ResponseEntity<List<RoleDto>> findAll() {
        List<RoleDto> dtos = roleMapper.map(roleService.findAll());
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        RoleEntity entity = roleService.findById(id);

        if (entity != null) {
            RoleDto dto = roleMapper.map(entity);
            return ResponseEntity.ok(dto);
        } else {
            return new ResponseEntity<>("Role with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<RoleDto> insert(@RequestBody RoleDto roleDto) {
        RoleEntity entity = roleMapper.unMap(roleDto);
        entity = roleService.insert(entity);
        RoleDto dto = roleMapper.map(entity);
        return ResponseEntity.ok(dto);
    }


    @PutMapping("")
    public ResponseEntity<RoleDto> update(@RequestBody RoleDto roleDto) {
        RoleEntity entity = roleMapper.unMap(roleDto);
        entity = roleService.update(entity);
        RoleDto dto = roleMapper.map(entity);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (roleService.findById(id)!=null) {
            roleService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted role with id: " + id, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Role with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }

    }
}
