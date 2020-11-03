package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid User user) {
        userService.register(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);

        return ResponseEntity.ok(user);
    }
}
