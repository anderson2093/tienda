package com.anderson.tiendaback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anderson.tiendaback.models.User;
import com.anderson.tiendaback.repositories.UserRepository;
import com.anderson.tiendaback.viewModels.UserViewModel;

@Component
public class Mapper {

	@Autowired
	private UserRepository userRepository;
	
	
	
	public UserViewModel convertToUsuarioViewModel(User entity) {
		UserViewModel viewModel = new UserViewModel();
		viewModel.setUserId(entity.getUserId());
		viewModel.setEmail(entity.getEmail());
		viewModel.setPassword(entity.getPassword());
		viewModel.setUsername(entity.getUsername());
		return viewModel;

	}

	public User convertToUsuarioEntity(UserViewModel viewModel) {
		User usuario = new User(viewModel.getUserId(),viewModel.getEmail(),viewModel.getPassword(),viewModel.getUsername());
		return usuario;

	}
}
