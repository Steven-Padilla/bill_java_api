package com.api.simplecrud.controllers;

import com.api.simplecrud.models.UserModel;
import com.api.simplecrud.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    /*@Autowired
    private UserService userService;

    @GetMapping
    public UserModel login(String username, String password) {
        return userService.login(username, password);
    }*/
}
