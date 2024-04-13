package com.anderson.tiendaback.security;

import java.util.Optional;

import com.anderson.tiendaback.models.User;

public class AuthDTO {
    public record LoginRequest(String username, String password) {
    }

    public record Response(String message, String token, Optional<User> user) {
    }
}