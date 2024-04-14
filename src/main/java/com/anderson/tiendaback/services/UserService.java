package com.anderson.tiendaback.services;



import com.anderson.tiendaback.models.User;

public interface UserService extends CRUDService<User>{


    public User register(User user);
}