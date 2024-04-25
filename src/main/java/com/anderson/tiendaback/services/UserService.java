package com.anderson.tiendaback.services;



import com.anderson.tiendaback.models.User;

import java.util.UUID;

public interface UserService extends ICRUDService<User, UUID> {


    public User register(User user);
}