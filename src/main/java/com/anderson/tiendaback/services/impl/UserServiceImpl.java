package com.anderson.tiendaback.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.anderson.tiendaback.repositories.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anderson.tiendaback.models.User;
import com.anderson.tiendaback.repositories.UserRepository;
import com.anderson.tiendaback.services.UserService;

@Service
public class UserServiceImpl extends CRUDImpl<User,UUID> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    


	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		System.out.print(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
	}


	@Override
	protected IGenericRepo<User, UUID> getRepo() {
		return userRepository;
	}
}
