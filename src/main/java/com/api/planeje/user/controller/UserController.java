package com.api.planeje.user.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.planeje.user.entity.User;
import com.api.planeje.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public @ResponseBody String Auth(@RequestBody User body) {
        return userService.auth(body);
    }

    @PostMapping()
    public @ResponseBody String saveUser(@RequestBody User body) {
        return userService.saveUser(body);
    }

}
