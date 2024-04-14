package com.anderson.tiendaback.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.tiendaback.models.User;
import com.anderson.tiendaback.services.UserService;



@RestController
public class UserController {
	
    private UserService userService;

    @Operation(summary = "Register User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Register User",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Error in register",
                    content = @Content)})
    @PostMapping("/api/auth/register")
    public User register(@RequestBody User user) {
    	System.out.println("Contraseña: "+user.getPassword());
    	return userService.register(user);
    }
}