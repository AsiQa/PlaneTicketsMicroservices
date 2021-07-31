package com.raf.user.service.controller;


import com.raf.user.service.dto.*;
import com.raf.user.service.secutiry.CheckSecurity;
import com.raf.user.service.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get all users")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestHeader("Authorization") String authorization,
                                                     Pageable pageable) {

        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}/discount")
    public ResponseEntity<DiscountDto> getDiscount(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findDiscount(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Register user")
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.add(userCreateDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Login")
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }

    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/{id}/addKartica")
    public ResponseEntity<Void> addKartica(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id, @RequestBody @Valid KarticaCreateDto karticaCreateDto) {
        userService.addKartica(id, karticaCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}/addMilje")
    public ResponseEntity<Void> addMilje(@PathVariable("id") Long id,
                                         @RequestParam(name = "milje") Integer milje) {
        userService.addMilje(id, milje);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/removeMilje")
    public ResponseEntity<Void> removeMilje(@PathVariable("id") Long id,
                                            @RequestParam(name = "milje") Integer milje) {
        userService.removeMilje(id, milje);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_USER"})
    @PutMapping("/{id}/updateUser")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.updateUser(id, userCreateDto), HttpStatus.OK);
    }

}




