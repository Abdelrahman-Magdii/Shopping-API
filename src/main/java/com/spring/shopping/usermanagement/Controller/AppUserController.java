package com.spring.shopping.usermanagement.Controller;

import com.spring.shopping.usermanagement.Dto.AppUserDto;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import com.spring.shopping.usermanagement.Mapper.AppUserMapper;
import com.spring.shopping.usermanagement.Services.AppUserServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class AppUserController {

    private final AppUserServices appUserService;
    private final AppUserMapper appUserMapper;


    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<AppUserDto> dtos = appUserMapper.map(appUserService.findAll());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        AppUserEntity entity = appUserService.findById(id);
        if (entity != null) {
            AppUserDto dto = appUserMapper.map(entity);
            return ResponseEntity.ok(dto);
        }else{
            return new ResponseEntity<>("User with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<AppUserDto> insert(@RequestBody AppUserDto dto) {
        AppUserEntity entity = appUserMapper.unMap(dto);
        entity = appUserService.insert(entity);
        AppUserDto savedDto = appUserMapper.map(entity);
        return ResponseEntity.ok(savedDto);
    }

    @PutMapping("")
    public ResponseEntity<AppUserDto> update(@RequestBody AppUserDto dto) {
        AppUserEntity entity = appUserMapper.unMap(dto);
        entity = appUserService.update(entity);
        AppUserDto savedDto = appUserMapper.map(entity);
        return ResponseEntity.ok(savedDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (appUserService.findById(id) != null) {
            appUserService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted user with id: " + id, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }



}
