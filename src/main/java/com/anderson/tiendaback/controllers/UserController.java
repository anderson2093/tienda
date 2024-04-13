package com.anderson.tiendaback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.tiendaback.models.User;
import com.anderson.tiendaback.services.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/auth/register")
    public User register(@RequestBody User user) {
    	System.out.println("Contraseña: "+user.getPassword());
        return userService.register(user);
    }
}