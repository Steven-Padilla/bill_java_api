package com.api.simplecrud.controllers;

import com.api.simplecrud.models.UserModel;
import com.api.simplecrud.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Value("${app.auth.user:singing}")
    private String user;
    @Value("${app.auth.password:singing}")
    private String passwordDB;

    @PostMapping
    public boolean login(@RequestParam String username,@RequestParam String password) {
        return username.equals(user) && password.equals(passwordDB);
    }
}
