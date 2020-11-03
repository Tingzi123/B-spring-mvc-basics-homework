package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistsException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid User user) {
        if (user == null) {
            throw new UserExistsException("User is nul");
        }

        userService.register(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/login")
    public ResponseEntity<User> login(@RequestParam
                                      @NotBlank
                                      @Pattern(regexp = "[0-9A-Za-z_]{3,10}")
                                      @Length(min = 3, max = 10) String username,
                                      @RequestParam
                                      @NotBlank
                                      @Length(min = 5, max = 12) String password) {
        User user = userService.login(username, password);

        return ResponseEntity.ok(user);
    }
}
