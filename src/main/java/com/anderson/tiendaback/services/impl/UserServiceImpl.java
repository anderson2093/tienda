package com.anderson.tiendaback.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
	@Override
	public User insertOrUpdate(User entity) {
		// TODO Auto-generated method stub
		return userRepository.save(entity);
	}

	@Override
	public Optional<User> getOne(UUID id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAll(int page, int size, String sortDir, String sort) {
		// TODO Auto-generated method stub
		PageRequest pageReq = PageRequest.of(page, size,Sort.Direction.fromString(sortDir),sort);
		return userRepository.findAll(pageReq).getContent();
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
		// TODO Auto-generated method stub
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return userRepository.findAll(pageable);
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		System.out.print(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
	}


}
