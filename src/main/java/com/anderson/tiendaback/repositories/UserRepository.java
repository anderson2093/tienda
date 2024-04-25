package com.anderson.tiendaback.repositories;


import java.util.Optional;
import java.util.UUID;

import com.anderson.tiendaback.models.User;

public interface UserRepository extends IGenericRepo<User, UUID> {
    Optional<User> findByUsername(String username);
}